package jobity.jobboard.offers.application.create;

import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class OfferCreatorTest {
    private OfferRepository repository;

    @Autowired
    private OfferCreator creator;

    @BeforeEach
    protected void setUp() {
        repository = mock(OfferRepository.class);
        creator = new OfferCreatorService(repository);
    }

    @Test
    void should_create_an_offer_given_createOfferCommand() {

        CreateOfferCommand command = new CreateOfferCommand(
                "decf33ca-81a7-419f-a07a-74f214e928e5",
                "decf33ca-81a7-419f-a07a-74f214e928e5",
                "title",
                1223,
                22,
                "kdjafksdjfksadjf",
                new ArrayList<Category>(
                        Arrays.asList(
                                new Category("Backend", "category"),
                                new Category("Alicante", "place"),
                                new Category("Remote", "type"),
                                new Category("Degree", "study_level"),
                                new Category("Full Time", "work_time")
                        )
                )
        );

        creator.create(command);

        Offer offer = repository.findById(new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5"));

        // verify that save method is executed at least once
        verify(repository, atLeastOnce()).save(offer);
    }
}
