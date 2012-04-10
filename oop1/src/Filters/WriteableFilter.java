package Filters;
import java.io.File;
import java.io.FileFilter;

import Exceptions.BadParamException;


public class WriteableFilter extends YesNoFilter implements FileFilter {

	public WriteableFilter(String yesNoString) throws BadParamException {
		super(yesNoString);
	}

	@Override	
	public boolean accept(File pathname) {
		return pathname.canWrite() ^ negative;
	}

}
