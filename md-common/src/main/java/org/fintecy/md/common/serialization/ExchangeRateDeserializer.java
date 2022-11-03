package org.fintecy.md.common.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.fintecy.md.common.model.ExchangeRate;

import java.io.IOException;
import java.math.BigDecimal;

import static org.fintecy.md.common.model.ExchangeRate.exchangeRate;

public class ExchangeRateDeserializer extends StdDeserializer<ExchangeRate> {
    public final static ExchangeRateDeserializer INSTANCE = new ExchangeRateDeserializer();

    public ExchangeRateDeserializer() {
        super(ExchangeRate.class);
    }

    public static ExchangeRate parse(JsonParser jp, JsonNode node) throws InvalidFormatException {
        final var isDecimal = node.isNumber();
        if (isDecimal) {
            final var mid = node.decimalValue();
            return exchangeRate(mid);
        } else {
            if (!node.has("mid"))
                throw new InvalidFormatException(jp, "mid rate not present", node, BigDecimal.class);
            final var mid = node.get("mid").decimalValue();
            if (!node.has("ask") && !node.has("bid"))
                return exchangeRate(mid);
            final var ask = node.has("ask") ? node.get("ask").decimalValue() : mid;
            final var bid = node.has("bid") ? node.get("bid").decimalValue() : mid;
            return new ExchangeRate(ask, mid, bid);
        }
    }

    @Override
    public ExchangeRate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final JsonNode node = jp.getCodec().readTree(jp);
        return parse(jp, node);
    }
}
