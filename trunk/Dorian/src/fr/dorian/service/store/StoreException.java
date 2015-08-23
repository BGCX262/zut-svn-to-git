package fr.dorian.service.store;

public class StoreException extends Exception {

	private static final long serialVersionUID = 7135365961346383879L;
	
	public static final StoreException ILLEGAL_ARGUMENT_ERROR = new StoreException("IllegalArgument.error");
	
	public static final StoreException IOEXCEPTION = new StoreException("IOEXCEPTION");
	
	public StoreException(final String message) {
		super(message);
	}

	public StoreException(final StoreException businessException, final Throwable cause) {
		super(businessException.getMessage(), cause);
	}

	public StoreException(Exception e) {
		super("StoreException", e);
	}

	public StoreException(String string, Throwable e) {
		super(string, e);
	}
}
