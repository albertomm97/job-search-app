package jobity.jobboard.offers.domain;

public interface OfferRepository {
    void save(Offer offer);
    Offer search(OfferId id);
}
