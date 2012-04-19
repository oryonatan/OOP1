package oop.ex1.filters;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.orders.ModComparator;


/**
 * Filter files modified before a given date
 * 
 * @author yonatan,yuli
 */
public class BeforeFilter extends DateFilter implements FileFilter {

	/*
	 * Constructor for the filter calls DateFilter ctor.
	 * 
	 * @param dateString date given in the string format specified in DateFilter
	 * 
	 * @throws BadParamException
	 */
	public BeforeFilter(String dateString) throws BadParamException {
		super(dateString);
	}

	/* (non-Javadoc)
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
		
		if (ModComparator.isSameDay(date.getTime(), pathname.lastModified())){
			return true ^ negative;
		}
		return date.after(new Date(pathname.lastModified())) ^ negative;
	}

}
