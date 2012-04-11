package Filters;
import java.io.File;
import java.io.FileFilter;
import java.util.Date;

import Exceptions.BadParamException;


public class AfterFilter extends DateFilter implements FileFilter {

	public AfterFilter(String dateString) throws BadParamException {
		super(dateString);
	}

	@Override
	public boolean accept(File pathname) {
		return date.before(new Date(pathname.lastModified())) ^ negative;
	}
}
