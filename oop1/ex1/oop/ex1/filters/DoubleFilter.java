package oop.ex1.filters;

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
	 */
	public DoubleFilter(String numberString) {
		size = Double.parseDouble(numberString);
	}
}
