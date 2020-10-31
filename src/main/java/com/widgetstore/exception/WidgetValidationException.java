package com.widgetstore.exception;

public class WidgetValidationException extends Exception {

	private static final long serialVersionUID = -1230811354721164754L;

	public WidgetValidationException(String s) {
		super(s);
	}
	
	public WidgetValidationException(String s, Throwable cause) {
		super(s,cause);
	}

}
