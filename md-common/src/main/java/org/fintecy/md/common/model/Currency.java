package org.fintecy.md.common.model;

public class Currency extends MicroType<String> implements Comparable<Currency> {

    public Currency(String code) {
        super(code);
    }

    public static Currency currency(String code) {
        return new Currency(code);
    }

    public static Currency fromJavaCurrency(java.util.Currency currency) {
        return currency(currency.getCurrencyCode());
    }

    public java.util.Currency toJavaCurrency() {
        return java.util.Currency.getInstance(value);
    }

    public String getCode() {
        return value;
    }

    @Override
    public int compareTo(Currency o) {
        return value.compareTo(o.value);
    }
}
