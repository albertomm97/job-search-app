package jobity.jobboard.offers.application.create;

import jobity.jobboard.offers.domain.*;

import org.springframework.stereotype.Service;

@Service
public final class OfferCreator {
    private OfferRepository offerRepository;

    public OfferCreator(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void create(CreateOfferRequest request) {
        Offer offer = new Offer(
            new OfferId(request.getId()),
            new OfferTitle(request.getTitle()),
            new OfferSalary(request.getSalary())
        );

        offerRepository.save(offer);
    }
}
