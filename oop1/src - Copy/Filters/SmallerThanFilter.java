package Filters;
import java.io.File;
import java.io.FileFilter;


public class SmallerThanFilter extends YesNoFilter implements FileFilter {
	private double size;
	
	public SmallerThanFilter(double size) {
		this.size = size;
	}

	@Override
	public boolean accept(File pathname) {
		return (pathname.length() < size) ^ negative;
	}

}
