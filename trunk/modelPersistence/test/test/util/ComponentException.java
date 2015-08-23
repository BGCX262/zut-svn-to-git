package test.util;

public class ComponentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8164521752345567250L;
	
	public static final ComponentException ILLEGAL_ARGUMENT_ERROR = new ComponentException("IllegalArgument.error");
	
	public ComponentException(final String message) {
		super(message);
	}

	public ComponentException(final ComponentException businessException, final Throwable cause) {
		super(businessException.getMessage(), cause);
	}

	public ComponentException(Exception e) {
		super(e);
	}
}
