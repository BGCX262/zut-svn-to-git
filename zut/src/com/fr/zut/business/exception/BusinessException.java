package com.fr.zut.business.exception;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8164521752345567250L;
	
	public static final BusinessException INVALID_REQUEST = new BusinessException("invalid.request");
	public static final BusinessException INTERNAL_ERROR = new BusinessException("invalid.request");
	public static final BusinessException MAILER_ERROR = new BusinessException("mailer.error");
	
	private BusinessException(final String message) {
		super(message);
	}

	public BusinessException(final BusinessException businessException, final Throwable cause) {
		super(businessException.getMessage(), cause);
	}
}
