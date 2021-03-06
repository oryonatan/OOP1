package oop.ex1.filters;

import java.io.File;
import java.io.FileFilter;

import oop.ex1.exceptions.BadParamException;


/**
 * filters writable files
 * 
 * @author yonatan,yuli
 * 
 */
public class WriteableFilter extends YesNoFilter implements FileFilter {

	/**
	 * Constructor for the filter.
	 * 
	 * @param yesNoString
	 *            YES for writable files, NO for unwritable files
	 * @throws BadParamException
	 */
	public WriteableFilter(String yesNoString) throws BadParamException {
		super(yesNoString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return pathname.canWrite() ^ negative;
	}

}
