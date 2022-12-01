package jobity.jobboard.offers.domain;

import java.util.Optional;

public interface OfferRepository {

    void save(Offer offer);
    Optional<Offer> search(String id);
}
