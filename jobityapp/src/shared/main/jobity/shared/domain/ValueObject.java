package jobity.shared.domain;

import java.util.Objects;

public abstract class ValueObject<Type> {
    protected final Type value;

    public ValueObject(Type value) {
        this.value = value;
    }

    public Type value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject<?> that = (ValueObject<?>) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
