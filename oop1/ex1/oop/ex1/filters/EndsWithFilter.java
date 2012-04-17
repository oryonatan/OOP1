package oop.ex1.filters;

import java.io.File;
import java.io.FileFilter;

/**
 * Filter that tries to find files that has a name that ends with a given suffix
 * 
 * @author yonatan,yuli
 * 
 */
public class EndsWithFilter extends NegatableFilter implements FileFilter {
	private String sufix;

	/**
	 * Constructor for the filter.
	 * 
	 * @param sufix
	 *            the suffix to look for.
	 */
	public EndsWithFilter(String sufix) {
		this.sufix = sufix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith(sufix) ^ negative;
	}
}