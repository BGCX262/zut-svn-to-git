package fr.dorian.service.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8164521752345567250L;
	
	public static final ServiceException INVALID_REQUEST = new ServiceException("invalid.request");
	public static final ServiceException INTERNAL_ERROR = new ServiceException("internal.error");
	// Optional: for mailling
	public static final ServiceException MAILER_ERROR = new ServiceException("mailer.error");
	public static final ServiceException AUTHENTICATION_ERROR = new ServiceException("authentication.error");
	
	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final ServiceException businessException, final Throwable cause) {
		super(businessException.getMessage(), cause);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

}
