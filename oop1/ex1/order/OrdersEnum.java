package Order;

import Exceptions.BadParamException;



public enum OrdersEnum {
	abs(absComparator.class), 
	file(fileComparator.class), 
	mod(modComparator.class), 
	size(sizeComparator.class);

	public Class<?> classType;

	OrdersEnum(Class<?> classType) {
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
