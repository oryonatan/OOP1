package Filters;

import java.io.File;
import java.io.FileFilter;

import Exceptions.BadParamException;

/**
 * Filters hidden files
 * 
 * @author yonatan,yuli
 * 
 */
public class HiddenFilter extends YesNoFilter implements FileFilter {
	/**
	 * Constructor for the filter.
	 * 
	 * @param yesNoString
	 *            YES for hidden files, NO for viewable files
	 * @throws BadParamException
	 */
	public HiddenFilter(String yesNoString) throws BadParamException {
		super(yesNoString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return pathname.isHidden() ^ negative;
	}

}
