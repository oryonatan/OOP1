package Filters;

/**
 * Filter that can be reversed
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
