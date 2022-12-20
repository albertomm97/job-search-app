package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferRepository;
import jobity.shared.domain.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryOfferRepository implements OfferRepository {
    private HashMap<String, Offer> offers = new HashMap<>();

    @Override
    public void save(Offer offer) {
        this.offers.put(offer.id().value(), offer);
    }

    @Override
    public Offer findById(OfferId id) {
        Optional<Offer> offer = Optional.ofNullable(offers.get(id.value()));
        return offer.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Override
    public List<Offer> findByCompanyId(CompanyId companyId) {
        return null;
    }

    @Override
    public List<Offer> findByFilter() {
        return null;
    }
}
