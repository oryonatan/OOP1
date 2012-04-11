package Parser;

import java.util.Comparator;

import Exceptions.BadParamException;
import Order.OrdersEnum;

public class OrderParser {
	public Comparator<?> parseLines(String line) throws BadParamException {
		return OrderFactory(line);
	}

	public Comparator<?> OrderFactory(String line) throws BadParamException {

		Comparator<?> comp = null;
		try {
			comp = (Comparator<?>) OrdersEnum.fromValue(line).classType
					.newInstance();
		} catch (java.lang.Exception e) {
			throw new BadParamException();
		}
		return comp;

	}
}