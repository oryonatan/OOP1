package oop.ex1.filters;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.FilterExceptions.YesNoFilterYesNoStringException;

/**
 * Filter that gets as a parameter a YES or NO , to decide how to behave
 * 
 * @author yonatan,yuli
 * 
 */
public class YesNoFilter extends NegatableFilter {
	private static String YES = "YES";
	private static String NO = "NO";

	/**
	 * /** Constructor for the filter.
	 * 
	 * @param yesNoString
	 *            If yes is given - does nothing , if no is given- calls
	 *            negate() if something else is given errs.
	 * @throws BadParamException
	 */
	public YesNoFilter(String yesNoString) throws BadParamException {
		if (yesNoString.equals(NO)) {
			negate();
		} else if (!yesNoString.equals(YES)) {
			throw new YesNoFilterYesNoStringException();
		}
	}
}
