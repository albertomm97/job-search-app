package jobity.jobboard.offers.infrastructure.mapper;

import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferSalary;
import jobity.jobboard.offers.domain.OfferTitle;
import jobity.jobboard.offers.infrastructure.persistence.entity.OfferEntity;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {

    public OfferEntity offerToOfferEntity(Offer offer) {
        return new OfferEntity(offer.id().value(), offer.title().value(), offer.salary().value());
    }

    public Offer offerEntityToOffer(OfferEntity offer) {
        return new Offer(new OfferId(offer.id()), new OfferTitle(offer.title()), new OfferSalary(offer.salary()));
    }
}
