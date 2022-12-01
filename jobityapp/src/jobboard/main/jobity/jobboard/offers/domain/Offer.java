package jobity.jobboard.offers.domain;

import java.util.Objects;

public class Offer {
    private final OfferId id;
    private final OfferTitle title;
    private final OfferSalary salary;

    public Offer(OfferId id, OfferTitle title, OfferSalary salary) {

        this.id = id;
        this.title = title;
        this.salary = salary;
    }

    public OfferId id() {
        return id;
    }

    public OfferTitle title() {
        return title;
    }

    public OfferSalary salary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id.equals(offer.id) && title.equals(offer.title) && salary.equals(offer.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, salary);
    }
}
