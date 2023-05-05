package jobity.jobboard.offers.infrastructure.persistence;

import jobity.apps.Starter;
import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import jobity.shared.domain.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = Starter.class)
@SpringBootTest
class InMemoryOfferRepositoryTest {
    @Autowired
    private InMemoryOfferRepository repository;

    private final Offer savedOffer = new Offer(
            new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5"),
            new CompanyId("decf33ca-81a7-419f-a07a-74f214e928e5"),
            new OfferTitle("title"),
            new OfferSalary(32332),
            new OfferExperience(2),
            new OfferDescription("fkjsdakfjsdfkjaflskdjf"),
            LocalDateTime.now(),
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

    @Test
    void should_save_a_valid_offer() {
        repository.save(savedOffer);
    }

    @Test
    void should_find_an_existing_offer() {
        assertEquals(savedOffer.id(), repository.findById(new OfferId("decf33ca-81a7-419f-a07a-74f214e928e5")).id());
    }

    @Test
    void should_not_find_a_non_existing_offer() {

        Exception ex = assertThrows(ResourceNotFoundException.class, () ->
                repository.findById(new OfferId("decf33ca-81a7-419f-a07a-74f214e333e5")));

        assertEquals(ex.getMessage(), "Resource not found");
    }
}
