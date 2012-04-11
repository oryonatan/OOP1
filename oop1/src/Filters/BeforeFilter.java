package Filters;
import java.io.File;
import java.io.FileFilter;
import java.util.Date;

import Exceptions.BadParamException;


public class BeforeFilter extends DateFilter implements FileFilter{

	
	public BeforeFilter(String dateString) throws BadParamException {
		super(dateString);
	}

	@Override
	public boolean accept(File pathname) {
		return date.after(new Date(pathname.lastModified())) ^ negative;
	}

}
