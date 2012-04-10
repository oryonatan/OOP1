package Parser;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;


import java.util.Comparator;
import Order.OrdersEnum;
import Exceptions.BadParamException;

public class OrderParser {
	private static final int FILTER_TYPE = 0;
    private static final int ARGUMENTS  = 1;


	public Comparator parseLines(String[] lines) throws BadParamException {

		if (Array.getLength(lines) > 1)
		{
			//!!! exception
		}
		for (String line : lines) {
			if (line.startsWith("$"))
				continue;
		}


		return OrderFactory(lines);
		
	}

	public Comparator OrderFactory(String[] params) throws BadParamException {
		
		Comparator comp = null;
		try
		{
			comp = (Comparator)OrdersEnum.valueOf(params[FILTER_TYPE]).classType.newInstance();
		}
        catch (java.lang.Exception e) {
            throw new BadParamException();
        }
		return comp;

	}
}