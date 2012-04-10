package Filters;
import java.io.File;
import java.io.FileFilter;

class EndsWithFilter extends YesNoFilter implements FileFilter {
	private String arg = new String();

	public EndsWithFilter(String arg) {
		this.arg = arg;
	}

	@Override
	public boolean accept(File pathname) {
		return  pathname.getName().endsWith(arg) ^ negative;
	}
}