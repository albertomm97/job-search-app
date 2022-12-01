package jobity.jobboard.offers.application.create;

import jobity.jobboard.offers.application.create.OfferCreator;
import jobity.jobboard.offers.domain.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class OfferCreatorTest {
    @Test
    void should_save_a_valid_offer() throws Exception {
        // mock repository and create use case injecting the repository
        OfferRepository repository = mock(OfferRepository.class);
        OfferCreator creator = new OfferCreator(repository);

        // create request
        CreateOfferRequest request = new CreateOfferRequest("decf33ca-81a7-419f-a07a-74f214e928e5", "title", "543");

        // create the offer
        Offer offer = new Offer(
                new OfferId(request.getId()),
                new OfferTitle(request.getTitle()),
                new OfferSalary(request.getSalary())
        );

        // use the offer creator use case (wich uses the repository)
        creator.create(request);

        // verify that save method is executed at least once
        verify(repository, atLeastOnce()).save(offer);
    }
}
