package jobity.jobboard.offers.infrastructure.persistence;

import jobity.apps.Starter;
import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferSalary;
import jobity.jobboard.offers.domain.OfferTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = Starter.class)
@SpringBootTest
class DbOfferRepositoryTest {

    @Autowired
    private DbOfferRepository repository;

    private final Offer savedOffer = new Offer(
            new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5"),
            new OfferTitle("title"),
            new OfferSalary("324324")
    );

    @Test
    void should_save_a_valid_offer() {
        repository.save(savedOffer);
    }

    @Test
    void should_find_an_existing_offer() {
        assertEquals(Optional.of(savedOffer), repository.search(new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5")));
    }

    @Test
    void should_not_find_a_non_existing_offer() {
        assertNull(repository.search(new OfferId("decf33ca-81a7-419f-a07a-74f214e333e5")));
    }

}
