package Filters;
import java.io.File;
import java.io.FileFilter;

import Exceptions.BadParamException;


public class ExecFilter extends YesNoFilter implements FileFilter {

	public ExecFilter(String yesNoString) throws BadParamException {
		super(yesNoString);
	}

	@Override
	public boolean accept(File pathname) {
		return pathname.canExecute() ^ negative;
	}

}
