package jobity.jobboard.offers.application.create;

import jobity.jobboard.offers.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class OfferCreatorTest {

    private OfferRepository repository;
    private OfferCreator creator;

    @BeforeEach
    protected void setUp() {
        repository = mock(OfferRepository.class);
        creator = new OfferCreatorService(repository);
    }

    @Test
    void should_save_a_valid_offer() throws Exception {
        // create request
        OfferRequest request = new OfferRequest();
        request.setTitle("offertittle");
        request.setSalary(5000);

        CreateOfferCommand command = new CreateOfferCommand("decf33ca-81a7-419f-a07a-74f214e928e5", request);

        // create the offer
        Offer offer = new Offer(
                new OfferId(command.id()),
                new OfferTitle(command.title()),
                new OfferSalary(command.salary())
        );

        // use the offer creator use case (wich uses the repository)
        creator.create(command);

        // verify that save method is executed at least once
        verify(repository, atLeastOnce()).save(offer);
    }
}
