package oop.ex1.filters;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.FilterExceptions.DoubleFilterParseFailedException;

/**
 * Abstract class for filters that get a double as string
 * 
 * @author yonatan,yuli
 * 
 */
public class DoubleFilter extends NegatableFilter {
	protected Double size;

	/**
	 * Constructor for the filter
	 * 
	 * @param numberString
	 *            the number as a double
	 * @throws BadParamException
	 */
	public DoubleFilter(String numberString) throws BadParamException {
		try {
			size = Double.parseDouble(numberString);
		} catch (Exception e) {
			throw new DoubleFilterParseFailedException();
		}
	}
}
