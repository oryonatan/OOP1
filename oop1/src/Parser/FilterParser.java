package Parser;

import java.io.FileFilter;
import java.lang.reflect.Constructor;

import Exceptions.BadParamException;
import Filters.FilterLine;
import Filters.FiltersEnum;
import Filters.NegatableFilter;

public class FilterParser {
	private static final int FILTER_TYPE = 0;
	private static final int ARGUMENTS  = 1;
	private static final int NEGATIVE = 2;
	private static final Object NOT = "NOT";
	public static void main(String[] args){
		String[] strs = {"before%11/12/2000%NOT smaller_than%1000",
				"before%11/12/1900",
				"before%11/12/1232%NOT"};
		try {
			parseLines(strs);
		} catch (BadParamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void parseLines(String[] lines) throws BadParamException {
		for (String line : lines) {
			if (line.startsWith("$")){
				continue;
			}
			FilterLine filters = new FilterLine();
			
			String[] filtersInText = line.split(" +");
			for (String filterInText : filtersInText){
				String[] params = filterInText.split("%");
				try {
					@SuppressWarnings("unchecked")
					Class<FileFilter> filterType = (Class<FileFilter>) FiltersEnum.valueOf(params[FILTER_TYPE]).classType;
					Constructor<FileFilter> ctor = filterType.getConstructor(new Class[] {String.class});
					FileFilter filter = ctor.newInstance(params[ARGUMENTS]);
					if (params[NEGATIVE].equals(NOT)){
						((NegatableFilter)filter).negate();
					}
					filters.add(filter);
				} catch (java.lang.Exception e) {
					throw new BadParamException();
				} 
			}
			
		}
	}
}
