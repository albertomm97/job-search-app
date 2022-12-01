package jobity.jobboard.offers.domain;

import java.util.Objects;

public class Offer {
    private String id;
    private String title;
    private String salary;

    public Offer(String id, String title, String salary) {
        this.id = id;
        this.title = title;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(id, offer.id) && Objects.equals(title, offer.title) && Objects.equals(salary, offer.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, salary);
    }
}
