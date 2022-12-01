package jobity.jobboard.offers.application.create;

import jobity.jobboard.offers.application.create.OfferCreator;
import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class OfferCreatorTest {
    @Test
    void should_save_a_valid_offer() throws Exception {
        // mock repository and create use case injecting the repository
        OfferRepository repository = mock(OfferRepository.class);
        OfferCreator creator = new OfferCreator(repository);

        // create the offer
        Offer offer = new Offer("1234", "title", "543");

        // use the offer creator use case (wich uses the repository)
        creator.create(offer.getId(), offer.getTitle(), offer.getSalary());

        // verify that save method is executed at least once
        verify(repository, atLeastOnce()).save(offer);
    }
}
