package Parser;

import Filters.FiltersEnum;

public class FilterParser {
	
	public parseLines(String[] lines)
	{
		String[] params;
		for (String line: lines)
		{
			if (line.startsWith("$"))
				continue;
			
			params = line.split("%");
			
			
		}
	}
	
	public filterFactory(String[] params)
	{
		FiltersEnum filter = FiltersEnum.valueOf(params[0]);
		
	}
}
