package oop.ex1.filters;

import java.io.File;
import java.io.FileFilter;

/**
 * A filter that looks for files bigger then a given size.
 * 
 * @author yonatan,yuli
 * 
 */
public class GreaterThanFilter extends FileSizeFilter implements FileFilter {

	/**
	 * Constructor for the filter.
	 * 
	 * @param numberString
	 *            the size as string.
	 */
	public GreaterThanFilter(String numberString) {
		super(numberString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return ((double)pathname.length()> size) ^ negative;
	}

}
