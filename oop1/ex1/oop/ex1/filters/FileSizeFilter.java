package oop.ex1.filters;

import oop.ex1.exceptions.BadParamException;

/**
 * Abstract class for filters that get a double as string
 * 
 * @author yonatan,yuli
 * 
 */
public class FileSizeFilter extends DoubleFilter {
	protected Double size;

	/**
	 * Constructor for the filter
	 * 
	 * @param numberString
	 *            the number as a double
	 * @throws BadParamException
	 */
	public FileSizeFilter(String numberString) throws BadParamException {
		super(numberString);
		//Convert to KB
		size = Double.parseDouble(numberString) * 128;
	}
}
