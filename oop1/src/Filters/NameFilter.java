package Filters;

import java.io.File;
import java.io.FileFilter;

/**
 * A filter that looks for a file with a given name
 * 
 * @author yonatan
 * 
 */
public class NameFilter extends NegatableFilter implements FileFilter {
	private String name;

	/**
	 * Constructor for the filter.
	 * 
	 * @param name
	 *            the file name.
	 */
	public NameFilter(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().equals(name) ^ negative;
	}

}
