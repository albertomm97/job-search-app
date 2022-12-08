package jobity.jobboard.offers.application.create;

import jobity.jobboard.offers.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

class OfferCreatorTest {

    @Autowired
    private OfferRepository repository;

    @Autowired
    private OfferCreator creator;

    @BeforeEach
    protected void setUp() {
        repository = mock(OfferRepository.class);
        creator = new OfferCreatorService(repository);
    }

    @Test
    void should_save_a_valid_offer() {

        // verify that save method is executed at least once
        verify(repository, atLeastOnce()).save(null);
    }
}
