package jobity.jobboard.offers.application.create;

import jobity.jobboard.shared.application.validation.ValidatedObject;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Objects;

public class CreateOfferCommand extends ValidatedObject<CreateOfferCommand> {

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 36, max = 36)
    private String id;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 10, max = 50)
    private String title;

    @Positive
    @Max(value = 1000000000)
    private Integer salary;

    public CreateOfferCommand(String id, String title, Integer salary) {
        this.id = id;
        this.title = title;
        this.salary = salary;

        this.validateSelf();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOfferCommand that = (CreateOfferCommand) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, salary);
    }
}
