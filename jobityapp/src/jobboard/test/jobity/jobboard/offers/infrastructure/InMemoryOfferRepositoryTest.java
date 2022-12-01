package jobity.jobboard.offers.infrastructure;

import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.infrastructure.InMemoryOfferRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryOfferRepositoryTest {

    @Test
    void should_save_a_valid_offer() {
        InMemoryOfferRepository repository = new InMemoryOfferRepository();

        repository.save(new Offer("2123", "title", "324324"));
    }

    @Test
    void should_find_an_existing_offer() {
        InMemoryOfferRepository repository = new InMemoryOfferRepository();

        Offer offer = new Offer("2123", "title", "324324");

        repository.save(new Offer("2123", "title", "324324"));

        assertEquals(Optional.of(offer), repository.search(offer.getId()));
    }

    @Test
    void should_not_find_a_non_existing_offer() {
        InMemoryOfferRepository repository = new InMemoryOfferRepository();

        assertFalse(repository.search("12").isPresent());
    }
}
