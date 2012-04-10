package Filters;
import java.io.File;
import java.io.FileFilter;


public class GreaterThanFilter extends YesNoFilter implements FileFilter {
	private double size;
	
	public GreaterThanFilter(double size) {
		this.size = size;
	}

	@Override
	public boolean accept(File pathname) {
		return (pathname.length() > size) ^ negative;
	}

}
