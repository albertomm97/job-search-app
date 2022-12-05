package jobity.jobboard.offers.infrastructure.persistence;

import jobity.apps.Starter;
import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferSalary;
import jobity.jobboard.offers.domain.OfferTitle;
import jobity.jobboard.offers.infrastructure.mapper.OfferMapper;
import jobity.jobboard.offers.infrastructure.persistence.entity.OfferEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = Starter.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OfferJpaRepositoryTest {
    @Autowired
    private OfferJpaRepository repository;

    @Autowired
    private OfferMapper mapper;

    private final Offer savedOffer = new Offer(
            new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5"),
            new OfferTitle("title"),
            new OfferSalary("324324")
    );

    @Test
    void should_save_a_valid_offer() {
        repository.save(mapper.offerToOfferEntity(savedOffer));
    }

    @Test
    void should_find_an_existing_offer() {
        repository.save(mapper.offerToOfferEntity(savedOffer));
        OfferEntity offer = repository.findById("decf33ca-81a7-419f-a07a-74f214e928e5").get();

        assertEquals(offer.id(), savedOffer.id().value());
    }

    @Test
    void should_not_find_a_non_existing_offer() {
        assertTrue(repository.findById("decf33ca-81a7-419f-a07a-74f214e333e5").isEmpty());
    }
}
