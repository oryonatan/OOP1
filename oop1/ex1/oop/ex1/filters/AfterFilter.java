package oop.ex1.filters;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.orders.modComparator;


/**
 * Filter files modified after a given date
 * 
 * @author yonatan,yuli
 */
public class AfterFilter extends DateFilter implements FileFilter {

	/**
	 * Constructor for the filter calls DateFilter ctor.
	 * 
	 * @param dateString
	 *            date given in the string format specified in DateFilter
	 * @throws BadParamException
	 */
	public AfterFilter(String dateString) throws BadParamException {
		super(dateString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		if (modComparator.isSameDay(date.getTime(), pathname.lastModified())){
			return true ^ negative;
		}
		return date.before(new Date(pathname.lastModified())) ^ negative;
	}
}
