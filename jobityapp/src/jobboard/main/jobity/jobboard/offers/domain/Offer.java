package jobity.jobboard.offers.domain;

import jobity.jobboard.companies.domain.CompanyId;

import java.util.Objects;

public class Offer {
    private final OfferId id;
    private final CompanyId companyId;
    private final OfferTitle title;
    private final OfferCategory category;
    private final OfferType offerType;
    private final OfferPlace offerPlace;
    private final OfferStudyLevel offerStudyLevel;
    private final OfferWorkTime offerWorkTime;
    private final OfferSalary salary;
    private final OfferExperience offerExperience;
    private final OfferDescription description;

    public Offer(OfferId id,
                 CompanyId companyId,
                 OfferTitle title,
                 OfferCategory category,
                 OfferType offerType,
                 OfferPlace offerPlace,
                 OfferStudyLevel offerStudyLevel,
                 OfferWorkTime offerWorkTime,
                 OfferSalary salary,
                 OfferExperience offerExperience,
                 OfferDescription description) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.category = category;
        this.offerType = offerType;
        this.offerPlace = offerPlace;
        this.offerStudyLevel = offerStudyLevel;
        this.offerWorkTime = offerWorkTime;
        this.salary = salary;
        this.offerExperience = offerExperience;
        this.description = description;
    }

    public OfferId id() {
        return id;
    }

    public CompanyId companyId() {
        return companyId;
    }

    public OfferTitle title() {
        return title;
    }

    public OfferCategory category() {
        return category;
    }

    public OfferType offerType() {
        return offerType;
    }

    public OfferPlace offerPlace() {
        return offerPlace;
    }

    public OfferStudyLevel offerStudyLevel() {
        return offerStudyLevel;
    }

    public OfferWorkTime offerWorkTime() {
        return offerWorkTime;
    }

    public OfferSalary salary() {
        return salary;
    }

    public OfferExperience offerExperience() {
        return offerExperience;
    }

    public OfferDescription description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id.equals(offer.id) && companyId.equals(offer.companyId) && title.equals(offer.title) && category.equals(offer.category) && offerType.equals(offer.offerType) && offerPlace.equals(offer.offerPlace) && offerStudyLevel.equals(offer.offerStudyLevel) && offerWorkTime.equals(offer.offerWorkTime) && salary.equals(offer.salary) && offerExperience.equals(offer.offerExperience) && description.equals(offer.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, title, category, offerType, offerPlace, offerStudyLevel, offerWorkTime, salary, offerExperience, description);
    }
}
