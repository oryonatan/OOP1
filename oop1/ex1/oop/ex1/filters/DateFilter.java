package oop.ex1.filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import oop.ex1.exceptions.BadParamException;


/**
 * Abstract class for filters that uses dates.
 * 
 * @author yonatan,yuli
 * 
 */
public class DateFilter extends NegatableFilter {
	private static final String FORMAT = "dd/MM/yyyy";
	protected Date date;

	/**
	 * Constructor , uses SimpleDateFormat to parse the string given.
	 * 
	 * @param dateString
	 *            the date as a string.
	 * @throws BadParamException
	 */
	public DateFilter(String dateString) throws BadParamException {
		try {
			date = new SimpleDateFormat(FORMAT).parse(dateString);
		} catch (ParseException e) {
			throw new BadParamException();
		}
	}
}
