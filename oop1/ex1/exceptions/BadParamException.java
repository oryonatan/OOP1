package exceptions;

public class BadParamException extends Exception{

		private static final long serialVersionUID = 1L;
		
		public BadParamException() {
			super();
		}
		
		BadParamException(String s)
		{
			super(s);
		}

		
}
