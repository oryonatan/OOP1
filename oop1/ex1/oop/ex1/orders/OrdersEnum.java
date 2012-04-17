package oop.ex1.orders;

import java.io.File;
import java.util.Comparator;

import oop.ex1.exceptions.BadParamException;




public enum OrdersEnum {
	ABS(absComparator.class), 
	FILE(fileComparator.class), 
	MOD(modComparator.class), 
	SIZE(sizeComparator.class);

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
