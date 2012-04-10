package Parser;


import java.util.Arrays;
import java.util.ArrayList;

public class Parser {
	
	
	
	public ArrayList<String[]> parseIntoBlocks(String[] lines)
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
	
	public ArrayList<String[]> parseComments(ArrayList<String[]> blocks)
	{
		for (ArrayList<String[]> block: blocks)
		{
			for (String line: lines)
		}
	}
	
	public String[][] parseIntoSections(String[] lines)
	{
		String[] filters = null;
		String[] actions = null;
		String[] order = null;
		int i = 0;
		int actionsSection = 0;
		for (String line: lines)
		{
			if ("ACTION".equals(line))
			{
				filters = Arrays.copyOfRange(lines, 1 , i);
				actionsSection = i + 1 ;
			}
			if ("ORDER".equals(line) && actionsSection!= 0)
			{
				actions = Arrays.copyOfRange(lines, actionsSection, i);
				order = Arrays.copyOfRange(lines, i + 1, lines.length);
			}
			else if ("ORDER".equals(line) && actionsSection == 0)
			{
				//!!! throw section not right
			}
		}
		
		return new String[][] {filters, actions, order};
	}
}
