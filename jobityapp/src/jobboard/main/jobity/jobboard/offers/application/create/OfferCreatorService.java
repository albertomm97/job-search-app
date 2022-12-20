package jobity.jobboard.offers.application.create;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.*;

import jobity.shared.domain.ResourceAlreadyExistsException;
import jobity.shared.domain.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OfferCreatorService implements OfferCreator {
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
                new OfferSalary(command.salary()),
                new OfferExperience(command.minimumExperience()),
                new OfferDescription(command.description()),
                LocalDateTime.now(),
                command.categories()
        );

        offerRepository.save(offer);
    }
}
