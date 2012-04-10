package Filters;
import java.io.File;
import java.io.FileFilter;


public class GreaterThanFilter extends DoubleFilter implements FileFilter {

	public GreaterThanFilter(String numberString) {
		super(numberString);
	}

	@Override
	public boolean accept(File pathname) {
		return (pathname.length() > size) ^ negative;
	}

}
