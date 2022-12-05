package jobity.jobboard.offers.application.create;

import java.util.Objects;

public final class OfferRequest {

    private String companyId;
    private String title;
    private String companyName;
    private String offerCategory;
    private String offerType;
    private String offerPlace;
    private Integer salary;
    private Integer minimumExperience;
    private String minimumStudyLevel;
    private String description;

    public String companyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String offerCategory() {
        return offerCategory;
    }

    public void setOfferCategory(String offerCategory) {
        this.offerCategory = offerCategory;
    }

    public String offerType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String offerPlace() {
        return offerPlace;
    }

    public void setOfferPlace(String offerPlace) {
        this.offerPlace = offerPlace;
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

    public String minimumStudyLevel() {
        return minimumStudyLevel;
    }

    public void setMinimumStudyLevel(String minimumStudyLevel) {
        this.minimumStudyLevel = minimumStudyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferRequest that = (OfferRequest) o;
        return companyId.equals(that.companyId) && title.equals(that.title) && companyName.equals(that.companyName) && offerCategory.equals(that.offerCategory) && offerType.equals(that.offerType) && offerPlace.equals(that.offerPlace) && salary.equals(that.salary) && minimumExperience.equals(that.minimumExperience) && minimumStudyLevel.equals(that.minimumStudyLevel) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, title, companyName, offerCategory, offerType, offerPlace, salary, minimumExperience, minimumStudyLevel, description);
    }
}
