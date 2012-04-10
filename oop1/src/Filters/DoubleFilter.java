package Filters;

public class DoubleFilter extends NegatableFilter {
	protected Double size;
	public DoubleFilter(String numberString) {
		size = Double.parseDouble(numberString);
	}
}
