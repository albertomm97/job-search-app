package jobity.jobboard.offers.application.search;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class OfferFinderService implements OfferFinder {

    public final OfferRepository offerRepository;

    public OfferFinderService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer findById(String offerId) {
        return offerRepository.findById(new OfferId(offerId));
    }

    @Override
    public List<Offer> findByCompanyId(String companyId) {
        return offerRepository.findByCompanyId(new CompanyId(companyId));
    }

    @Override
    public List<Offer> findByFilter() {
        return null;
    }
}
