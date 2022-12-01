package jobity.jobboard.offers.infrastructure;

import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferSalary;
import jobity.jobboard.offers.domain.OfferTitle;
import jobity.jobboard.offers.infrastructure.InMemoryOfferRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryOfferRepositoryTest {

    @Test
    void should_save_a_valid_offer() {
        InMemoryOfferRepository repository = new InMemoryOfferRepository();

        Offer offer = new Offer(
                new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5"),
                new OfferTitle("title"),
                new OfferSalary("324324")
        );

        repository.save(offer);
    }

    @Test
    void should_find_an_existing_offer() {
        InMemoryOfferRepository repository = new InMemoryOfferRepository();

        Offer offer = new Offer(
                new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5"),
                new OfferTitle("title"),
                new OfferSalary("324324")
        );

        repository.save(offer);

        assertEquals(Optional.of(offer), repository.search(offer.id()));
    }

    @Test
    void should_not_find_a_non_existing_offer() {
        InMemoryOfferRepository repository = new InMemoryOfferRepository();

        assertFalse(repository.search(new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5")).isPresent());
    }
}
