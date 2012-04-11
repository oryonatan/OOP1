package Parser;

import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import Exceptions.BadParamException;
import Filters.FileFilterBox;
import Filters.FilterLine;
import Filters.FiltersEnum;
import Filters.NegatableFilter;

/**
 * Parser for filters
 * 
 * @author yonatan,yuli
 * 
 */
public class FilterParser {
	private static final int MINIMAL_FILTER_LENGTH = 2;
	private static final int FILTER_TYPE = 0;
	private static final int ARGUMENTS = 1;
	private static final int NEGATIVE = 2;
	private static final int NOT_FILTER_LENGTH = NEGATIVE + 1;
	private static final Object NOT = "NOT";

	/*
	 * public static void main(String[] args){ String[] strs =
	 * {"before%11/12/2000%NOT smaller_than%1000", "before%11/12/1900",
	 * "before%11/12/1232%NOT"}; try { FileFilterBox fBox = parseLines(strs);
	 * System.out.println(fBox); } catch (BadParamException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

	/**
	 * Creates a filter box from a list of files with filters string inside them
	 * 
	 * @param lines
	 *            list of strings with filters and params.
	 * @return a filter box.
	 * @throws BadParamException
	 */
	public static FileFilterBox parseLines(String[] lines)
			throws BadParamException {
		FileFilterBox filterBox = new FileFilterBox();
		for (String line : lines) {
			FilterLine filtersLine = new FilterLine();
			// Each filter in the line is seperated by a space.
			String[] filtersInText = line.split(" +");
			for (String filterInText : filtersInText) {
				// Each filter is composed form between 2 to 3 sections
				// seperated by an "%"
				String[] params = filterInText.split("%");
				if (params.length < MINIMAL_FILTER_LENGTH) {
					throw new BadParamException();
				}
				FileFilter filter = filterGenerator(params);
				filtersLine.add(filter);
			}
			filterBox.addFilter(filtersLine);
		}
		return filterBox;
	}

	/**
	 * Creates a new instance of a filter object of the desired type
	 * 
	 * @param params
	 *            a list of strings that describes the filter , for example
	 *            before%12/12/2000%NOT should be separated to
	 *            [before,12/12/2000,NOT]
	 * @return a new filter created from the parameters
	 * @throws BadParamException
	 */
	private static FileFilter filterGenerator(String[] params)
			throws BadParamException {
		FileFilter filter;
		// If name is not in lower case - err.
		if (!(params[FILTER_TYPE].equals(params[FILTER_TYPE].toLowerCase()))) {
			throw new BadParamException();
		}
		try {
			// Deserialize the filter type from the enum.
			@SuppressWarnings("unchecked")
			Class<FileFilter> filterType = (Class<FileFilter>) FiltersEnum
					.fromValue(params[FILTER_TYPE]).classType;
			// Create constructor for the given filter , and instantiate it .
			// Notice that using newInstance a class without getting the correct
			// ctor for the param type , will not allow passing parameters.
			Constructor<FileFilter> ctor = filterType
					.getConstructor(new Class[] { String.class });
			filter = ctor.newInstance(params[ARGUMENTS]);
			// Negate negatives
			if ((params.length == NOT_FILTER_LENGTH)
					&& (params[NEGATIVE].equals(NOT))) {
				((NegatableFilter) filter).negate();
			}
			return filter;
		} catch (java.lang.Exception e) {
			throw new BadParamException();
		}

	}
}
