package jobity.jobboard.offers.application.create;

import jobity.jobboard.shared.application.validation.ValidatedObject;
import jobity.jobboard.shared.domain.Category;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

public final class CreateOfferCommand extends ValidatedObject<CreateOfferCommand> {

    @NotBlank
    @Size(min = 36, max = 36)
    private String id;

    @NotBlank
    @Size(min = 36, max = 36)
    private String companyId;

    @NotBlank
    @Size(min = 10, max = 50)
    private String title;

    @Positive
    @Max(value = 100000000)
    private Integer salary;

    @Positive
    @Max(value = 50)
    private Integer minimumExperience;

    @NotBlank
    @Size(min = 10, max = 2500)
    private String description;

    private List<Category> categories;

    public CreateOfferCommand() {}

    public CreateOfferCommand(String id,
                              String companyId,
                              String title,
                              Integer salary,
                              Integer minimumExperience,
                              String description,
                              List<Category> categories) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.salary = salary;
        this.minimumExperience = minimumExperience;
        this.description = description;
        this.categories = categories;
    }

    public CreateOfferCommand(String id,
                              OfferRequest request) {
        this.id = id;
        this.companyId = request.companyId();
        this.title = request.title();
        this.salary = request.salary();
        this.minimumExperience = request.minimumExperience();
        this.description = request.description();
        this.categories = request.categories();

        this.validateSelf();
    }

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String companyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer salary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer minimumExperience() {
        return minimumExperience;
    }

    public void setMinimumExperience(Integer minimumExperience) {
        this.minimumExperience = minimumExperience;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> categories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOfferCommand that = (CreateOfferCommand) o;
        return id.equals(that.id) && companyId.equals(that.companyId) && title.equals(that.title) && salary.equals(that.salary) && minimumExperience.equals(that.minimumExperience) && description.equals(that.description) && categories.equals(that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, title, salary, minimumExperience, description, categories);
    }
}
