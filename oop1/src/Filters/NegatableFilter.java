package Filters;

public class NegatableFilter {
	protected boolean negative = false;
	public void negate(){
		negative=!negative;
	}
}
