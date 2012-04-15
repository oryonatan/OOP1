package order;

import java.io.File;
import java.util.Comparator;

import exceptions.BadParamException;



public enum OrdersEnum {
	abs(absComparator.class), 
	file(fileComparator.class), 
	mod(modComparator.class), 
	size(sizeComparator.class);

	public Class<? extends Comparator<File>> classType;

	OrdersEnum(Class<? extends Comparator<File>> classType) {
		this.classType = classType;
	}

	public static OrdersEnum fromValue(String value) throws BadParamException {
		if (value != null) {
			for (OrdersEnum order : values()) {
				if (order.name().equals(value.toUpperCase())) {
					return order;
				}
			}
		}
		throw new BadParamException();
	}
	
	

}
