package Exceptions;

public class PermissionsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PermissionsException() {
		super();
	}
	
	PermissionsException(String s)
	{
		super(s);
	}

}
