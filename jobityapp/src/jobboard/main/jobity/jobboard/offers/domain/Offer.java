package jobity.jobboard.offers.domain;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.shared.domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Offer {
    private final OfferId id;
    private final CompanyId companyId;
    private final OfferTitle title;
    private final OfferSalary salary;
    private final OfferExperience offerExperience;
    private final OfferDescription description;

    private List<Category> categories;

    public Offer(OfferId id,
                 CompanyId companyId,
                 OfferTitle title,
                 OfferSalary salary,
                 OfferExperience offerExperience,
                 OfferDescription description) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.salary = salary;
        this.offerExperience = offerExperience;
        this.description = description;
        this.categories = new ArrayList<>();
    }

    public Offer(OfferId id,
                 CompanyId companyId,
                 OfferTitle title,
                 OfferSalary salary,
                 OfferExperience offerExperience,
                 OfferDescription description,
                 List<Category> categories) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.salary = salary;
        this.offerExperience = offerExperience;
        this.description = description;
        this.categories = categories;
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

    public OfferSalary salary() {
        return salary;
    }

    public OfferExperience offerExperience() {
        return offerExperience;
    }

    public OfferDescription description() {
        return description;
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
        Offer offer = (Offer) o;
        return id.equals(offer.id) && companyId.equals(offer.companyId) && title.equals(offer.title) && salary.equals(offer.salary) && offerExperience.equals(offer.offerExperience) && description.equals(offer.description) && Objects.equals(categories, offer.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, title, salary, offerExperience, description, categories);
    }
}
