package parser;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

import actions.Action;
import exceptions.BadParamException;
import filters.FileFilterBox;


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
		
		int last = 1;
		for (int i=1; i<lines.length; i++)
		{

			if ("FILTER".equals(lines[i]))
			{
				last = i;
				blocks.add(Arrays.copyOfRange(lines, last, i));
			}
		}
		blocks.add(Arrays.copyOfRange(lines, last, lines.length));
		return blocks;
		
		
	}
	
	public static ArrayList<String[]> parseComments(ArrayList<String[]> blocks)
	{
		String[] block = null;
		ArrayList<String> newBlock = new ArrayList<String>();
		ArrayList<String> commentsBlock= new ArrayList<String>();
		
		ArrayList<String[]> commentsBlocks= null;
		for (int i=0; i< Array.getLength(blocks); i++)
		{
			block = blocks.get(i);
			for (String line: block)
			{
				if (line.startsWith("$"))
				{
					commentsBlock.add(line);
				}
				else
				{
					newBlock.add(line);
				}
			}
			blocks.set(i, (newBlock.toArray(new String[newBlock.size()])) );
		}
		return commentsBlocks;
	}
	
	public static String[][] parseIntoSections(String[] lines)
	{
		String[] filters = null;
		String[] actions = null;
		String[] order = null;
		int i = 0;
		int actionsSection = 0;
		for (String line: lines)
		{
			if (ACTION.equals(line))
			{
				filters = Arrays.copyOfRange(lines, 1 , i);
				actionsSection = i + 1 ;
			}
			if (ORDER.equals(line) && actionsSection!= 0)
			{
				actions = Arrays.copyOfRange(lines, actionsSection, i);
				order = Arrays.copyOfRange(lines, i + 1, lines.length);
			}
			else if (ORDER.equals(line) && actionsSection == 0)
			{
				//!!! throw section not right
			}
		}
		
		return new String[][] {filters, actions, order};
	}

	public static ArrayList<Block> parse(String sourceDir,String commandsFile) throws BadParamException, IOException
	{
		String[] lines = readLines(commandsFile);
		ArrayList<String[]> BlockLines = parseIntoBlocks(lines);
		ArrayList<String[]> commentsBlocks = parseComments(BlockLines);
		ArrayList<Block> blocks= new ArrayList<Block>() ;
		String[][] sections = null;
		
		for (int i = 0; i < BlockLines.size(); i++)
		{
			String[] blockLine = BlockLines.get(i);
			
			sections = parseIntoSections(blockLine);
			
			FileFilterBox filters = 	FilterParser.parseLines(sections[0]);
			ArrayList<Action> actions= 	ActionParser.parseLines(sourceDir,sections[1]);
			Comparator<File> order = 	OrderParser.parseLines(sections[2]);
			
			blocks.add(new Block(sourceDir, filters, actions, order, commentsBlocks.get(i)));
			
		}
		return blocks;
		
		
	}
	


	public static String[] readLines(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}
		bufferedReader.close();
		return lines.toArray(new String[lines.size()]);
	}
	
}
