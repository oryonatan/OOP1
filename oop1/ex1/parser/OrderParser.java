package parser;

import java.io.File;
import java.util.Comparator;

import exceptions.BadParamException;
import order.OrdersEnum;

public class OrderParser {
	public static Comparator<File> parseLines(String[] lines) throws BadParamException {
		if (lines.length > 1)
		{
			//!!! throw blabla
		}
		return OrderFactory(lines[0]);
	}

	private static Comparator<File> OrderFactory(String line) throws BadParamException {

		Comparator<File> comp = null;
		try {
			comp = (Comparator<File>) OrdersEnum.fromValue(line).classType
					.newInstance();
		} catch (java.lang.Exception e) {
			throw new BadParamException();
		}
		return  comp;

	}
}