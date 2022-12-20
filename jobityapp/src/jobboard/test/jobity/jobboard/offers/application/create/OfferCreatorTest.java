package jobity.jobboard.offers.application.create;

import jobity.apps.Starter;
import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

class OfferCreatorTest {

    private OfferRepository repository;
    private OfferCreator creator;

    private final Offer savedOffer = new Offer(
            new OfferId("decf33ca-81a7-419f-a07a-74f214eEEEEE"),
            new CompanyId("decf33ca-81a7-419f-a07a-74f214e928e5"),
            new OfferTitle("title"),
            new OfferSalary(1223),
            new OfferExperience(22),
            new OfferDescription("kdjafksdjfksadjf"),
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

    private final CreateOfferCommand command = new CreateOfferCommand(
            "decf33ca-81a7-419f-a07a-74f214eEEEEE",
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

    @BeforeEach
    protected void setUp() {
        repository = mock(OfferRepository.class);
        creator = new OfferCreatorService(repository);
    }

    @Test
    void should_create_an_offer_given_createOfferCommand() {

        creator.create(command);

        ArgumentCaptor<Offer> offerCaptor = ArgumentCaptor.forClass(Offer.class);

        verify(repository, times(1)).save(offerCaptor.capture());

        assertThat(offerCaptor.getValue())
                .usingRecursiveComparison()
                .ignoringFields("createdAt")
                .isEqualTo(savedOffer);
    }
}
