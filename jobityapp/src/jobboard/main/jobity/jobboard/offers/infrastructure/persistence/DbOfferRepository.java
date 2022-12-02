package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferRepository;
import jobity.jobboard.offers.infrastructure.mapper.OfferMapper;
import jobity.jobboard.offers.infrastructure.persistence.entity.OfferEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DbOfferRepository implements OfferRepository {
    private final OfferJpaRepository offerRepository;
    private final OfferMapper offerMapper;

    public DbOfferRepository(OfferJpaRepository offerRepository,
                             OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
    }

    @Override
    @Transactional
    public void save(Offer offer) {
        offerRepository.save(offerMapper.offerToOfferEntity(offer));
    }

    @Override
    public Offer search(OfferId id) {
        OfferEntity offer = offerRepository.findById(id.value())
                .orElseThrow( () -> new RuntimeException("Hola"));

        return offerMapper.offerEntityToOffer(offer);
    }
}
