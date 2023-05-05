package jobity.jobboard.offers.application.create;

import jobity.jobboard.shared.domain.Category;

import java.util.List;
import java.util.Objects;

public final class OfferRequest {

    private String companyId;
    private String title;
    private String companyName;
    private Integer salary;
    private Integer minimumExperience;
    private String description;
    private List<Category> categories;

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

    public String companyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
        OfferRequest that = (OfferRequest) o;
        return companyId.equals(that.companyId) && title.equals(that.title) && companyName.equals(that.companyName) && salary.equals(that.salary) && minimumExperience.equals(that.minimumExperience) && description.equals(that.description) && categories.equals(that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, title, companyName, salary, minimumExperience, description, categories);
    }
}
