package eus.tartanga.psp.PMD_PSP.exceptions;

public class WrongHashException extends Exception {
	private static final long serialVersionUID = 1L;

	public WrongHashException() {
		super();
	}

	public WrongHashException(String message) {
		super(message);
	}
}
