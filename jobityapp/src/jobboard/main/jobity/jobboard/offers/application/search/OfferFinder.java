package jobity.jobboard.offers.application.search;

import jobity.jobboard.offers.domain.Offer;

import java.util.List;

public interface OfferFinder {
    Offer findById(String offerId);
    List<Offer> findByCompanyId(String companyId);
    List<Offer> findByFilter();
}
