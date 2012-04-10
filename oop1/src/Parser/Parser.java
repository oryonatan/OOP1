package Parser;


import java.io.FileFilter;
import java.util.Arrays;
import java.util.ArrayList;

public class Parser {
	
	public parseIntoBlocks(String[] lines)
	{
		ArrayList<FileFilter> filters 
		if (!"FILTER".equals(lines[0]))
		{
			//!!! throw "doesn't start with FILTER"
		}
		int i = 0;
		for (String line: lines)
		{
			if ("FILTER".equals(lines))
			{
				
			}
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
