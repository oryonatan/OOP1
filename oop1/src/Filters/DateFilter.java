package Filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Exceptions.BadParamException;

public class DateFilter extends NegatableFilter {
	private static final String FORMAT = "DD/MM/YYYY";
	protected Date date;

	public DateFilter(String dateString) throws BadParamException {
		try {
			date = new SimpleDateFormat(FORMAT).parse(dateString);
		} catch (ParseException e) {
			throw new BadParamException();
		}
	}
}
