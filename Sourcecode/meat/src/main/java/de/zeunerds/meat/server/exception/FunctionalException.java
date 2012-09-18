package de.zeunerds.meat.server.exception;

public class FunctionalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6247187540463693424L;
	
	private FunctionalText mExceptionText;
	
	public FunctionalException(FunctionalText exceptionText) {
		setExceptionText(exceptionText);
	}

	public FunctionalText getExceptionText() {
		return mExceptionText;
	}

	public void setExceptionText(FunctionalText mExceptionText) {
		this.mExceptionText = mExceptionText;
	}
	
	public String toString() {
		return mExceptionText.toString();
	}
}
