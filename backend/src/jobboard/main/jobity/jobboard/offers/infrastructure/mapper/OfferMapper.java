package jobity.jobboard.offers.infrastructure.mapper;

import jobity.jobboard.offers.application.search.OfferListResponse;
import jobity.jobboard.offers.application.search.OfferResponse;
import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public final class OfferMapper {

    public OfferResponse offerToOfferResponse(Offer offer) {

        var categories = offer.categories().stream().collect(Collectors.toMap(Category::type, Category::value));

        return new OfferResponse(
                offer.id().value(),
                offer.companyId().value(),
                offer.title().value(),
                offer.salary().value(),
                offer.offerExperience().value(),
                offer.description().value(),
                offer.createdAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                categories
        );
    }

    public OfferListResponse offerListToOfferResponseList(List<Offer> offers) {
        return new OfferListResponse(offers.stream().map(this::offerToOfferResponse).collect(Collectors.toList()));
    }
}
