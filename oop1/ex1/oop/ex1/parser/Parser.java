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
import oop.ex1.filters.FileFilterBox;



public class Parser {
	
	
	
	private static final String ORDER = "ORDER";
	private static final String ACTION = "ACTION";

	public static ArrayList<String[]> parseIntoBlocks(String[] lines)
	{
		ArrayList<String[]> blocks = new ArrayList<String[]>();
		if (!"FILTER".equals(lines[0]))
		{
			//!!! throw "doesn't start with FILTER"
		}
		
		int last = 0;
		for (int i=1; i<lines.length; i++)
		{

			if ("FILTER".equals(lines[i]))
			{
				blocks.add(Arrays.copyOfRange(lines, last, i));
				last = i;
			}
		}
		blocks.add(Arrays.copyOfRange(lines, last, lines.length));
		return blocks;
		
		
	}
	
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
				if (line.startsWith("$"))
				{
					blockCommentsPart.add(line);
				}
				else
				{
					blockDataPart.add(line);
				}
			}
			allStringBlocks.set(i, (blockDataPart.toArray(new String[blockDataPart.size()])) );
			allCommentBlocks.add(blockCommentsPart.toArray(new String[blockCommentsPart.size()])); 
		}
		return allCommentBlocks;
	}
	
	public static Block parseToBlock(String sourceDir, String[] lines, String[] comments) throws BadParamException
	{
		String[] filters = null;
		String[] actions = null;
		String order = null;
		int i = 0;
		int actionsSection = 0;
		for (String line: lines)
		{
			line = line.trim();
			if (ACTION.equals(line))
			{
				filters = Arrays.copyOfRange(lines, 1 , i);
				actionsSection = i + 1 ;
				break;
			}
			i++;
		}
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

	
		

	private static Block makeBlock(String sourceDir,String[] comments, String[] filters, String[] actions, String order) throws BadParamException {
		
		FileFilterBox blockFilters = 	FilterParser.parseLines(filters);
		ArrayList<Action> blockActions= ActionParser.parseLines(sourceDir,actions);
		Comparator<File> blockOrder = 	OrderParser.parseLines(order);
		
		return new Block(sourceDir, blockFilters, blockActions, blockOrder, comments);
	}

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
			block= parseToBlock(sourceDir, data, comments);	
			blocks.add(block);	
		}
		return blocks;
		
		
	}
	


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
	
}
