package jobity.jobboard.offers.application.create;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.companies.domain.CompanyName;
import jobity.jobboard.offers.domain.*;

import org.springframework.stereotype.Service;

@Service
public final class OfferCreator {
    private OfferRepository offerRepository;

    public OfferCreator(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void create(CreateOfferCommand request) {
        Offer offer = new Offer(
                new OfferId(request.id()),
                new CompanyId(request.companyId()),
                new OfferTitle(request.title()),
                new CompanyName(request.companyName()),
                new OfferCategory(request.offerCategory()),
                new OfferType(request.offerType()),
                new OfferPlace(request.offerPlace()),
                new OfferSalary(request.salary()),
                new OfferExperience(request.minimumExperience()),
                new OfferStudyLevel(request.minimumStudyLevel()),
                new OfferDescription(request.description())
        );


        offerRepository.save(offer);
    }
}
