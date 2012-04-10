package Order;



public enum OrdersEnum {
	abs(absComparator.class), 
	file(fileComparator.class), 
	mod(modComparator.class), 
	size(sizeComparator.class);

	public Class classType;

	OrdersEnum(Class classType) {
		this.classType = classType;
	}

}
