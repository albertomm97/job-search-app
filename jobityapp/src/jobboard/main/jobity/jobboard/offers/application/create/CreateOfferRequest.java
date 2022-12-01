package jobity.jobboard.offers.application.create;

import java.util.Objects;

public class CreateOfferRequest {
    private String id;
    private String title;
    private String salary;

    public CreateOfferRequest(String id, String title, String salary) {
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
        CreateOfferRequest that = (CreateOfferRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, salary);
    }
}
