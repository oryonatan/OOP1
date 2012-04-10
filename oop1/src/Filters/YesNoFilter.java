package Filters;

import Exceptions.BadParamException;

public class YesNoFilter extends NegatableFilter {
	public static String YES = "YES";
	public static String NO = "NO";
	
	public YesNoFilter(String yesNoString) throws BadParamException{
		if (yesNoString.equals(NO)) {
			negate();
		}
		else if (!yesNoString.equals(YES)){
			throw new BadParamException();
		}
	}
}
