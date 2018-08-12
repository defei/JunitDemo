package org.codelogger.tutorial.junit.model;

/**
 * Available types of customers
 */
public enum ProductType {

    BANK_GUARANTEE("BG");

	private final String textValue;

	ProductType(final String textValue) {
		this.textValue = textValue;
	}

	@Override
	public String toString() {
		return textValue;
	}
}