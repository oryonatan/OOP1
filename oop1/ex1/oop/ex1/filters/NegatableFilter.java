package oop.ex1.filters;

/**
 * Filter that can be reversed , return values in the accept method should be XORed with negative
 * 
 * @author yonatan,yuli
 * 
 */
public class NegatableFilter {
	protected boolean negative = false;

	/**
	 * Reverses the filter behavior.
	 * 
	 */
	public void negate() {
		negative = !negative;
	}
}
