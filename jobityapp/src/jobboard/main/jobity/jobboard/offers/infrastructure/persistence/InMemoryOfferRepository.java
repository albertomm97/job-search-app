package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferRepository;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryOfferRepository implements OfferRepository {
    private HashMap<String, Offer> offers = new HashMap<>();

    @Override
    public void save(Offer offer) {
        this.offers.put(offer.id().value(), offer);
    }

    @Override
    public Offer search(OfferId id) {
        Optional<Offer> offer = Optional.ofNullable(offers.get(id.value()));
        return offer.orElseThrow(() -> new RuntimeException("Hola"));
    }
}
