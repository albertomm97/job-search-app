package jobity.jobboard.offers.application.search;

import java.util.Map;
import java.util.Objects;

public class OfferResponse {
    private String id;
    private String companyId;
    private String title;
    private Integer salary;
    private Integer offerExperience;
    private String description;
    private String createdAt;
    private Map<String,String> categories;

    public OfferResponse(String id,
                         String companyId,
                         String title,
                         Integer salary,
                         Integer offerExperience,
                         String description,
                         String createdAt,
                         Map<String, String> categories) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.salary = salary;
        this.offerExperience = offerExperience;
        this.description = description;
        this.createdAt = createdAt;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getOfferExperience() {
        return offerExperience;
    }

    public void setOfferExperience(Integer offerExperience) {
        this.offerExperience = offerExperience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferResponse that = (OfferResponse) o;
        return id.equals(that.id) && companyId.equals(that.companyId) && title.equals(that.title) && salary.equals(that.salary) && offerExperience.equals(that.offerExperience) && description.equals(that.description) && createdAt.equals(that.createdAt) && categories.equals(that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, title, salary, offerExperience, description, createdAt, categories);
    }
}
