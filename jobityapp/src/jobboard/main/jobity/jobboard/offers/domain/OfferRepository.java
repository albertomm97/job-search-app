package jobity.jobboard.offers.domain;

import jobity.jobboard.companies.domain.CompanyId;

import java.util.List;

public interface OfferRepository {
    void save(Offer offer);
    Offer findById(OfferId id);
    List<Offer> findByCompanyId(CompanyId companyId);
    List<Offer> findByFilter();

}
