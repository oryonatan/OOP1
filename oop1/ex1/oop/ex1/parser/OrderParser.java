package oop.ex1.parser;

import java.io.File;
import java.util.Comparator;

import oop.ex1.exceptions.BadParamException;
import oop.ex1.exceptions.ParserExceptions.IllegalOrderException;
import oop.ex1.orders.OrdersEnum;

/**
 * Parser for orders
 * 
 * @author Yuli
 *
 */
public class OrderParser {
	
	/**
	 * creates an order ( which is a comparator )
	 * 
	 * @param order - order name
	 * @return
	 * @throws BadParamException
	 */
	public static Comparator<File> parseLines(String order)
			throws BadParamException {
		order = Parser.validateString(order);
		return OrderFactory(order);
	}

	/**
	 * @param order - order name
	 * @return
	 * @throws BadParamException
	 */
	private static Comparator<File> OrderFactory(String order)
			throws BadParamException {
		
		Comparator<File> comp = null;
		try {
			// Create constructor for the given filter , and instantiate it .
			comp = (Comparator<File>) OrdersEnum.valueOf(order).classType.newInstance();
		} catch (java.lang.Exception e) {
			throw new IllegalOrderException();
		}
		return comp;
	}
}