package Parser;

import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import Exceptions.BadParamException;
import Filters.FileFilterBox;
import Filters.FilterLine;
import Filters.FiltersEnum;
import Filters.NegatableFilter;

public class FilterParser {
	private static final int MINIMAL_FILTER_LENGTH = 2;
	private static final int FILTER_TYPE = 0;
	private static final int ARGUMENTS  = 1;
	private static final int NEGATIVE = 2;
	private static final int NOT_FILTER_LENGTH = NEGATIVE+1;
	private static final Object NOT = "NOT";
/*	public static void main(String[] args){
		String[] strs = {"before%11/12/2000%NOT smaller_than%1000",
				"before%11/12/1900",
				"before%11/12/1232%NOT"};
		try {
			FileFilterBox fBox = parseLines(strs);
			System.out.println(fBox);
		} catch (BadParamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/

	public static FileFilterBox parseLines(String[] lines) throws BadParamException {
		FileFilterBox filterBox = new FileFilterBox();
		for (String line : lines) {
			FilterLine filtersLine = new FilterLine();
			String[] filtersInText = line.split(" +");
			for (String filterInText : filtersInText){
					String[] params = filterInText.split("%");
					if (params.length < MINIMAL_FILTER_LENGTH){
						throw new BadParamException();
					}
					FileFilter filter = makeFilter(params);
					filtersLine.add(filter);
			}
			filterBox.addFilter(filtersLine);
		}
		return filterBox;
	}


	/**Creates a new instance of a filter object of the desired type
	 * @param params
	 * @return
	 * @throws BadParamException
	 */
	private static FileFilter makeFilter(String[] params)throws BadParamException {
		if (!(params[FILTER_TYPE].equals(params[FILTER_TYPE].toLowerCase()))){
			throw new BadParamException();  
		}
		try {
			@SuppressWarnings("unchecked")
			Class<FileFilter> filterType = (Class<FileFilter>) FiltersEnum
					.fromValue(params[FILTER_TYPE]).classType;
			Constructor<FileFilter> ctor = filterType
					.getConstructor(new Class[] { String.class });
			FileFilter filter;
			filter = ctor.newInstance(params[ARGUMENTS]);
			if ((params.length == NOT_FILTER_LENGTH) && (params[NEGATIVE].equals(NOT))){
				((NegatableFilter)filter).negate();
			}
			return filter;
		} catch (java.lang.Exception e) {
			throw new BadParamException();
		}

	}
}
