package jobity.jobboard.offers.application.create;

import org.springframework.stereotype.Service;

import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferRepository;

@Service
public final class OfferCreator {

    private OfferRepository offerRepository;

    public OfferCreator(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void create(String id, String title, String salary) {
        Offer offer = new Offer(id, title, salary);

        offerRepository.save(offer);
    }
}
