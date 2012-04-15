package filters;

import java.io.File;
import java.io.FileFilter;

import exceptions.BadParamException;

/**
 * Filter that finds files with execution premission
 * 
 * @author yonatan,yuli
 * 
 */
public class ExecFilter extends YesNoFilter implements FileFilter {

	/**
	 * Constructor for the filter.
	 * 
	 * @param yesNoString
	 *            YES for executable files , NO for non exectutables.
	 * @throws BadParamException
	 */
	public ExecFilter(String yesNoString) throws BadParamException {
		super(yesNoString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		return pathname.canExecute() ^ negative;
	}

}
