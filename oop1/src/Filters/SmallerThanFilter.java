package Filters;
import java.io.File;
import java.io.FileFilter;


public class SmallerThanFilter extends DoubleFilter implements FileFilter {

	public SmallerThanFilter(String numberString) {
		super(numberString);
	}

	@Override
	public boolean accept(File pathname) {
		return (pathname.length() < size) ^ negative;
	}

}
