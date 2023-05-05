package jobity.jobboard.shared.domain;

import java.util.Objects;

public final class Category {
    private String value;
    private String type;

    public Category() {
    }

    public Category(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String value() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String type() {
        return type;
    }

    public void setType(String group) {
        this.type = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return value.equals(category.value) && type.equals(category.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
