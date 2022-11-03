package org.fintecy.md.common.model;

import java.util.Objects;

public class MicroType<T> {
    protected final T value;

    public MicroType(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '(' + value + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicroType<?> microType = (MicroType<?>) o;
        return Objects.equals(value, microType.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
