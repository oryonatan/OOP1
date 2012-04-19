package oop.ex1.filters;

import java.io.File;
import java.io.FileFilter;

import oop.ex1.exceptions.BadParamException;

/**
 * A filter that looks for files smaller then a given value.
 * 
 * @author yonatan,yuli
 * 
 */
public class SmallerThanFilter extends FileSizeFilter implements FileFilter {

	/**
	 * Constructor for the filter.
	 * 
	 * @param numberString
	 *            the size.
	 * @throws BadParamException 
	 */
	public SmallerThanFilter(String numberString) throws BadParamException {
		super(numberString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return (pathname.length() < size) ^ negative;
	}

}
