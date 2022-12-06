package jobity.jobboard.offers.application.create;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public final class OfferCreatorService implements OfferCreator {
    private final OfferRepository offerRepository;

    public OfferCreatorService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Transactional
    public void create(CreateOfferCommand command) {
        Offer offer = new Offer(
                new OfferId(command.id()),
                new CompanyId(command.companyId()),
                new OfferTitle(command.title()),
                new OfferCategory(command.offerCategory()),
                new OfferType(command.offerType()),
                new OfferPlace(command.offerPlace()),
                new OfferSalary(command.salary()),
                new OfferExperience(command.minimumExperience()),
                new OfferStudyLevel(command.minimumStudyLevel()),
                new OfferDescription(command.description())
        );

        offerRepository.save(offer);
    }
}
