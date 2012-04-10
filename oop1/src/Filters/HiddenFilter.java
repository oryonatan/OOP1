package Filters;
import java.io.File;
import java.io.FileFilter;

import Exceptions.BadParamException;


public class HiddenFilter extends YesNoFilter implements FileFilter {
	public HiddenFilter(String yesNoString) throws BadParamException {
		super(yesNoString);
	}

	@Override
	public boolean accept(File pathname) {
		return pathname.isHidden() ^ negative;
	}

}
