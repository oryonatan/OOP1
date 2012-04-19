package oop.ex1.orders;

import java.io.File;
import java.util.Comparator;

/**
 * Enum containing all the orders
 * 
 * @author yonatan,yuli
 * 
 */
public enum OrdersEnum {
	ABS(AbsComparator.class),
	FILE(FileComparator.class),
	MOD(ModComparator.class),
	SIZE(SizeComparator.class);

	public Class<? extends Comparator<File>> classType;

	/**
	 * Sets the class type
	 * 
	 * @param classType
	 *            the class type to get
	 */
	OrdersEnum(Class<? extends Comparator<File>> classType) {
		this.classType = classType;
	}

}
