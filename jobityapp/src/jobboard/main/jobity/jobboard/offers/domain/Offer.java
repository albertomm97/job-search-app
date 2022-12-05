package jobity.jobboard.offers.domain;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.companies.domain.CompanyName;

import java.util.Objects;

public class Offer {
    private final OfferId id;
    private final CompanyId companyId;
    private final OfferTitle title;
    private final CompanyName companyName;
    private final OfferCategory category;
    private final OfferType offerType;
    private final OfferPlace offerPlace;
    private final OfferSalary salary;
    private final OfferExperience offerExperience;
    private final OfferStudyLevel offerStudyLevel;
    private final OfferDescription description;

    public Offer(OfferId id,
                 CompanyId companyId,
                 OfferTitle title,
                 CompanyName companyName,
                 OfferCategory category,
                 OfferType offerType,
                 OfferPlace offerPlace,
                 OfferSalary salary,
                 OfferExperience offerExperience,
                 OfferStudyLevel offerStudyLevel,
                 OfferDescription description) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.companyName = companyName;
        this.category = category;
        this.offerType = offerType;
        this.offerPlace = offerPlace;
        this.salary = salary;
        this.offerExperience = offerExperience;
        this.offerStudyLevel = offerStudyLevel;
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

    public CompanyName companyName() {
        return companyName;
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

    public OfferSalary salary() {
        return salary;
    }

    public OfferExperience offerExperience() {
        return offerExperience;
    }

    public OfferStudyLevel offerStudyLevel() {
        return offerStudyLevel;
    }

    public OfferDescription description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id.equals(offer.id) && title.equals(offer.title) && companyName.equals(offer.companyName) && category.equals(offer.category) && offerType.equals(offer.offerType) && offerPlace.equals(offer.offerPlace) && salary.equals(offer.salary) && offerExperience.equals(offer.offerExperience) && offerStudyLevel.equals(offer.offerStudyLevel) && description.equals(offer.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, companyName, category, offerType, offerPlace, salary, offerExperience, offerStudyLevel, description);
    }
}
