package org.codelogger.tutorial.junit.model;

import java.math.BigDecimal;

public class AmountImpl implements Amount {

    private BigDecimal value;

    private Currency currency;

    public AmountImpl(BigDecimal value, Currency currency) {
        super();
        this.value = value;
        this.currency = currency;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

}
