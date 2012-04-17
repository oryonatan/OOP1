package oop.ex1.parser;

import java.io.File;
import java.util.Comparator;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.orders.OrdersEnum;


public class OrderParser {
	private static final String DEFAULT = "abs";

	public static Comparator<File> parseLines(String order)
			throws BadParamException {
		
		return OrderFactory(order);

	}

	private static Comparator<File> OrderFactory(String line)
			throws BadParamException {

		Comparator<File> comp = null;
		try {
			if (line == null)
				comp = (Comparator<File>) OrdersEnum.fromValue(DEFAULT).classType
						.newInstance();
			else {
				comp = (Comparator<File>) OrdersEnum.fromValue(line).classType
						.newInstance();
			}
		} catch (java.lang.Exception e) {
			throw new BadParamException();
		}
		return comp;
	}
}