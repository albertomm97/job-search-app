package jobity.jobboard.offers.infrastructure.persistence;

import jobity.apps.Starter;
import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Starter.class)
@ActiveProfiles("test")
@DataJdbcTest
@Sql({"/test-data.sql"})
class DbOfferRepositoryTest {

    @Autowired
    private DbOfferRepository repository;

    private final Offer savedOffer = new Offer(
            new OfferId("decf33ca-81a7-419f-a07a-74f214e12345"),
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
    @Order(1)
    void should_save_a_valid_offer() {
        repository.save(savedOffer);
    }

    @Test
    void should_find_a_valid_offer_using_id() {
        repository.save(savedOffer);

        assertNotNull(repository.findById(savedOffer.id()));
    }

    @Test
    void should_not_find_a_valid_offer_using_id() {
        assertNull(repository.findById(new OfferId("decf33ca-81a7-419f-a07a-74f214e333e5")));
    }

    @Test
    void should_find_a_valid_offers_using_company_id() {
        repository.save(savedOffer);

        List<Offer> offers = repository.findByCompanyId(savedOffer.companyId());

        assertNotNull(offers);
        assertFalse(offers.isEmpty());
    }

    @Test
    void should_not_find_a_valid_offers_using_company_id() {
        assertNull(repository.findByCompanyId(new CompanyId("decf33ca-81a7-419f-a07a-7442143333e5")));
    }
}
