package oop.ex1.parser;

import java.io.File;
import java.util.Comparator;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.ParserExceptions.IllegalOrderException;
import oop.ex1.orders.OrdersEnum;

public class OrderParser {
	private static final String DEFAULT = "ABS";

	public static Comparator<File> parseLines(String order)	throws BadParamException {
		return OrderFactory(order);
	}

	private static Comparator<File> OrderFactory(String line)
			throws BadParamException {
		line = Parser.validateString(line);
		Comparator<File> comp = null;
		try {
			if (line == null)
				//Return ABS
				comp = (Comparator<File>) OrdersEnum.valueOf(DEFAULT).classType.newInstance();
			else {
				comp = (Comparator<File>) OrdersEnum.valueOf(line).classType.newInstance();
			}
		} catch (java.lang.Exception e) {
			throw new IllegalOrderException();
		}
		return comp;
	}
}