package org.fintecy.md.common.model;

import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.valueOf;

public class ExchangeRate {
    private final BigDecimal ask;
    private final BigDecimal bid;
    private final BigDecimal mid;

    public ExchangeRate(BigDecimal ask,
                        BigDecimal mid,
                        BigDecimal bid) {
        this.ask = ask;
        this.mid = mid;
        this.bid = bid;
    }

    public static ExchangeRate exchangeRate(long mid) {
        return exchangeRate(valueOf(mid));
    }

    public static ExchangeRate exchangeRate(double mid) {
        return exchangeRate(valueOf(mid));
    }

    public static ExchangeRate exchangeRate(BigDecimal mid) {
        return new ExchangeRate(mid, mid, mid);
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public BigDecimal getBid() {
        return bid;
    }

    @Override
    public String toString() {
        if (bid.equals(ask) && bid.equals(mid))
            return "ExchangeRate(" + mid + ')';
        return "ExchangeRate{" +
                "bid=" + bid +
                ", mid=" + mid +
                ", ask=" + ask +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return Objects.equals(bid, that.bid)
                && Objects.equals(mid, that.mid)
                && Objects.equals(ask, that.ask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, mid, ask);
    }
}
