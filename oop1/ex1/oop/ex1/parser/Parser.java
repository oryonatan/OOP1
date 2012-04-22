package oop.ex1.parser;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import oop.ex1.actions.Action;
import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.StringCaseException;
import oop.ex1.filters.FileFilterBox;




public class Parser {
	
	
	public static final String PARAMETER_SEPERATOR = "%"; 
	private static final String COMMNET_PREFIX = "$";
	private static final String FILTER = "FILTER";
	private static final String ORDER = "ORDER";
	private static final String ACTION = "ACTION";

	/**
	 * Parses the file into blocks of [	1:(FILTER, ACTION, ORDER), 
	 * 									2:(FILTER, ACTION, ORDER)...]
	 * 
	 * @param lines - an array which holds all the lines in the command file
	 * 
	 * @return - an ArrayList of blocks (arrays)
	 * @throws BadParamException
	 */
	public static ArrayList<String[]> parseIntoBlocks(String[] lines) throws BadParamException
	{
		ArrayList<String[]> blocks = new ArrayList<String[]>();
		// If file doesn't start with FILTER
		if ( ! FILTER.equals(lines[0]))
		{
			throw new BadParamException();
		}
		
		int last = 0;
		for (int i=1; i<lines.length; i++)
		{
			// we search for the next "FILTER" line
			if (FILTER.equals(lines[i]))
			{
				blocks.add(Arrays.copyOfRange(lines, last, i));
				last = i;
			}
		}
		// we add the last block 
		blocks.add(Arrays.copyOfRange(lines, last, lines.length));
		return blocks;
		
		
	}
	
	
	/**
	 * Retrieves all the comments in the command file divided 
	 * by blocks, on the way changes the blocks so they wouldn't have
	 * any comments
	 * 
	 * @param allStringBlocks - all the blocks in the command file 
	 * 			@see oop.ex1.parser#parseIntoBlocks(java.io.File, java.io.File)
	 * @return - an ArrayList of blocks of comments
	 */
	public static ArrayList<String[]> parseComments(ArrayList<String[]> allStringBlocks)
	{
		String[] stringBlock = null;
		ArrayList<String> blockDataPart;
		ArrayList<String> blockCommentsPart;
		ArrayList<String[]> allCommentBlocks = new ArrayList<String[]>();;
		
		for (int i=0; i< allStringBlocks.size(); i++)
		{
			
			stringBlock = allStringBlocks.get(i);
			blockDataPart = new ArrayList<String>();
			blockCommentsPart= new ArrayList<String>();
			for (String line: stringBlock)
			{
				// if the line is a comment we add 
				// to the blockCommentsPart
				if (line.startsWith(COMMNET_PREFIX))
				{
					blockCommentsPart.add(line);
				}
				// if the line isn't a comment we add 
				// to the blockDataPart
				else
				{
					blockDataPart.add(line);
				}
			}
			// from the blockCommentsPart we make a new array
			allCommentBlocks.add(blockCommentsPart.toArray(new String[blockCommentsPart.size()])); 
			// we change the current data block so it won't have any comments
			allStringBlocks.set(i, (blockDataPart.toArray(new String[blockDataPart.size()])) );
			
		}
		return allCommentBlocks;
	}
	
	
	
	/**
	 * Parses a block of lines (holds (FILTER, ACTION, ORDER))
	 * into subsections of filters, actions and lines and makes
	 * an object of type Block from them
	 * 
	 * @param sourceDir	- the source dir from the project's args
	 * @param lines		- a block of lines (holds (FILTER, ACTION, ORDER))
	 * @param comments	- a block of comments
	 * @return - an Object of type Block
	 * @throws BadParamException
	 */
	public static Block parseToBlock(String sourceDir, String[] lines, String[] comments) throws BadParamException
	{
		String[] filters = null;
		String[] actions = null;
		String order = null;
		int i = 0;
		int actionsSection = 0;

		while( !ACTION.equals(lines[i]))
		{
			i++;
			if (i == lines.length)
			{
				// !!! throw bad subsection name
			}
		}
		
		filters = Arrays.copyOfRange(lines, 1 , i);
		actionsSection = i + 1 ;

			
		
		if (ORDER.equals(lines[lines.length - 2]))
		{
			actions = Arrays.copyOfRange(lines, actionsSection, lines.length - 2);
			order = lines[lines.length-1];
		}
		else if(ORDER.equals(lines[lines.length - 1]))
		{
			actions = Arrays.copyOfRange(lines, actionsSection, lines.length - 1 );
			order = null;
		}
		else 
		{
			actions = Arrays.copyOfRange(lines, actionsSection, lines.length  );
			order = null;
		}
		return  makeBlock(sourceDir, comments, filters,actions,order);
		
	}		

	
		

	/**
	 * Makes an object of type Block 
	 * 
	 * @param sourceDir	- the source directory 
	 * @param comments	- a comments block  
	 * @param filters	- a filters block
	 * @param actions	- an actions block
	 * @param order	- an order
	 * @return
	 * @throws BadParamException
	 */
	private static Block makeBlock(String sourceDir,String[] comments, String[] filters, String[] actions, String order) throws BadParamException {
		
		FileFilterBox blockFilters = 	FilterParser.parseLines(filters);
		ArrayList<Action> blockActions= ActionParser.parseLines(sourceDir,actions);
		Comparator<File> blockOrder = 	OrderParser.parseLines(order);
		
		return new Block(sourceDir, blockFilters, blockActions, blockOrder, comments);
	}

	/**
	 * Parses a commands file and returns an ArrayList of blocks 
	 * 
	 * @param sourceDir		- the source dir from the project's args
	 * @param commandsFile	- the path to the commands file
	 * @return - ArrayList of objects of type Block
	 * @throws BadParamException
	 * @throws IOException
	 */
	public static ArrayList<Block> parse(String sourceDir,String commandsFile) throws BadParamException, IOException
	{
		String[] lines = readLines(commandsFile);
		ArrayList<String[]> blockLines = parseIntoBlocks(lines);
		ArrayList<String[]> commentsBlocks = parseComments(blockLines);
		
		ArrayList<Block> blocks= new ArrayList<Block>() ;
		
		Block block;
		
		for (int i = 0; i < blockLines.size(); i++)
		{			
			String[] data = blockLines.get(i);
			String[] comments = commentsBlocks.get(i);
			// from each block of (FILTER,ACTION,ORDER) 
			// we make a new object of type Block
			block= parseToBlock(sourceDir, data, comments);	
			blocks.add(block);	
		}
		return blocks;
		
		
	}
	


	/**
	 * Reads all the file lines into an array
	 * 
	 * @param filename - the path of the file
	 * @return - an array of all the file lines
	 * @throws IOException
	 */
	public static String[] readLines(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line.trim());
		}
		bufferedReader.close();
		return lines.toArray(new String[lines.size()]);
	}
	
	public static String validateString(String inputString) throws StringCaseException{
		if (inputString == inputString.toLowerCase()){
			return inputString.toUpperCase();
		}
		throw new StringCaseException();
	}
	
}
