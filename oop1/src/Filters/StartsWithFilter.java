package Filters;

import java.io.File;
import java.io.FileFilter;

public class StartsWithFilter extends NegatableFilter implements FileFilter {
	private String arg = new String();

	public StartsWithFilter(String arg) {
		this.arg = arg;
	}

	@Override
	public boolean accept(File pathname) {
		return pathname.getName().startsWith(arg) ^ negative;
	}
}