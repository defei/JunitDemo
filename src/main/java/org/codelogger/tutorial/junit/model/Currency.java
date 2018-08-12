package org.codelogger.tutorial.junit.model;

public enum Currency {

	CNY("CNY"), UNITED_STATES_DOLLAR("USD"), EUR("EUR");

	private final String textValue;

	Currency(final String textValue) {
		this.textValue = textValue;
	}

	@Override
	public String toString() {
		return textValue;
	}
}
