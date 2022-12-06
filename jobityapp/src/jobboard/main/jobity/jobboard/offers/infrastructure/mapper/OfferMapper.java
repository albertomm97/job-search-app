package jobity.jobboard.offers.infrastructure.mapper;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.companies.domain.CompanyName;
import jobity.jobboard.offers.domain.*;
import org.springframework.stereotype.Component;

@Component
public final class OfferMapper {

    /*
    public OfferEntity offerToOfferEntity(Offer offer) {
        return new OfferEntity(
                offer.id().value(),
                offer.companyId().value(),
                offer.title().value(),
                offer.companyName().value(),
                offer.category().value(),
                offer.offerType().value(),
                offer.offerPlace().value(),
                offer.salary().value(),
                offer.offerExperience().value(),
                offer.offerStudyLevel().value(),
                offer.description().value()
        );
    }

    public Offer offerEntityToOffer(OfferEntity offer) {
        return new Offer(
                new OfferId(offer.id()),
                new CompanyId(offer.companyId()),
                new OfferTitle(offer.title()),
                new CompanyName(offer.companyName()),
                new OfferCategory(offer.offerCategory()),
                new OfferType(offer.offerType()),
                new OfferPlace(offer.offerPlace()),
                new OfferSalary(offer.salary()),
                new OfferExperience(offer.minimumExperience()),
                new OfferStudyLevel(offer.minimumStudyLevel()),
                new OfferDescription(offer.description())
        );
    }

     */
}
