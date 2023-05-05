package jobity.shared.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier {
    private final String value;

    public Identifier(String value) {
        ensureValidUUID(value);

        this.value = value;
    }

    public String value() {
        return this.value;
    }

    private void ensureValidUUID(String value) {
        UUID.fromString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
