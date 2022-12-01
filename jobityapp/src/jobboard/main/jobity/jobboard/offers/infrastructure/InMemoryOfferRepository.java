package jobity.jobboard.offers.infrastructure;

import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class InMemoryOfferRepository implements OfferRepository {
    private HashMap<String, Offer> offers = new HashMap<>();

    @Override
    public void save(Offer offer) {
        this.offers.put(offer.id().value(), offer);
    }

    @Override
    public Optional<Offer> search(OfferId id) {
        return Optional.ofNullable(offers.get(id.value()));
    }
}
