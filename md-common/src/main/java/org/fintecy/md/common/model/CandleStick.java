package org.fintecy.md.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class CandleStick {
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal average;

    @JsonCreator
    public CandleStick(@JsonProperty("open") BigDecimal open,
                       @JsonProperty("high") BigDecimal high,
                       @JsonProperty("low") BigDecimal low,
                       @JsonProperty("close") BigDecimal close,
                       @JsonProperty("average") BigDecimal average) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.average = average;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "CandleStick{" +
                "open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", average=" + average +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandleStick that = (CandleStick) o;
        return Objects.equals(open, that.open)
                && Objects.equals(high, that.high)
                && Objects.equals(low, that.low)
                && Objects.equals(close, that.close)
                && Objects.equals(average, that.average);
    }

    @Override
    public int hashCode() {
        return Objects.hash(open, high, low, close, average);
    }
}
