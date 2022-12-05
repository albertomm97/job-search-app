package jobity.jobboard.offers.application.create;

import jobity.jobboard.shared.application.validation.ValidatedObject;

import javax.validation.constraints.*;
import java.util.Objects;

public class CreateOfferCommand extends ValidatedObject<CreateOfferCommand> {

    @NotBlank
    @Size(min = 36, max = 36)
    private String id;

    @NotBlank
    @Size(min = 36, max = 36)
    private String companyId;

    @NotBlank
    @Size(min = 10, max = 50)
    private String title;

    @NotBlank
    @Size(min = 3, max = 80)
    private String companyName;

    @NotBlank
    @Size(min = 3, max = 40)
    private String offerCategory;

    @NotBlank
    @Size(min = 3, max = 40)
    private String offerType;

    @NotBlank
    @Size(min = 3, max = 40)
    private String offerPlace;

    @Positive
    @Max(value = 100000000)
    private Integer salary;

    @Positive
    @Max(value = 50)
    private Integer minimumExperience;

    @NotBlank
    @Size(min = 10, max = 40)
    private String minimumStudyLevel;

    @NotBlank
    @Size(min = 10, max = 2500)
    private String description;

    public CreateOfferCommand(String id,
                              String companyId,
                              String title,
                              String companyName,
                              String offerCategory,
                              String offerType,
                              String offerPlace,
                              Integer salary,
                              Integer minimumExperience,
                              String minimumStudyLevel,
                              String description) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.companyName = companyName;
        this.offerCategory = offerCategory;
        this.offerType = offerType;
        this.offerPlace = offerPlace;
        this.salary = salary;
        this.minimumExperience = minimumExperience;
        this.minimumStudyLevel = minimumStudyLevel;
        this.description = description;

        this.validateSelf();
    }

    public CreateOfferCommand(String id, OfferRequest request) {
        this.id = id;
        this.companyId = request.companyId();
        this.title = request.title();
        this.companyName = request.companyName();
        this.offerCategory = request.offerCategory();
        this.offerType = request.offerType();
        this.offerPlace = request.offerPlace();
        this.salary = request.salary();
        this.minimumExperience = request.minimumExperience();
        this.minimumStudyLevel = request.minimumStudyLevel();
        this.description = request.description();

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

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOfferCommand that = (CreateOfferCommand) o;
        return id.equals(that.id) && companyId.equals(that.companyId) && title.equals(that.title) && companyName.equals(that.companyName) && offerCategory.equals(that.offerCategory) && offerType.equals(that.offerType) && offerPlace.equals(that.offerPlace) && salary.equals(that.salary) && minimumExperience.equals(that.minimumExperience) && minimumStudyLevel.equals(that.minimumStudyLevel) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, title, companyName, offerCategory, offerType, offerPlace, salary, minimumExperience, minimumStudyLevel, description);
    }
}
