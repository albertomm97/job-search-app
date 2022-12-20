package jobity.jobboard.offers.domain;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.shared.domain.Category;

import java.time.LocalDateTime;
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
    private LocalDateTime createdAt;
    private List<Category> categories;

    public Offer(OfferId id,
                 CompanyId companyId,
                 OfferTitle title,
                 OfferSalary salary,
                 OfferExperience offerExperience,
                 OfferDescription description,
                 LocalDateTime createdAt) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.salary = salary;
        this.offerExperience = offerExperience;
        this.description = description;
        this.createdAt = createdAt;
        this.categories = new ArrayList<>();
    }

    public Offer(OfferId id,
                 CompanyId companyId,
                 OfferTitle title,
                 OfferSalary salary,
                 OfferExperience offerExperience,
                 OfferDescription description,
                 LocalDateTime createdAt,
                 List<Category> categories) {
        this.id = id;
        this.companyId = companyId;
        this.title = title;
        this.salary = salary;
        this.offerExperience = offerExperience;
        this.description = description;
        this.createdAt = createdAt;
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
    public LocalDateTime createdAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
        return id.equals(offer.id) && companyId.equals(offer.companyId) && title.equals(offer.title) && salary.equals(offer.salary) && offerExperience.equals(offer.offerExperience) && description.equals(offer.description) && createdAt.equals(offer.createdAt) && categories.equals(offer.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, title, salary, offerExperience, description, createdAt, categories);
    }
}
