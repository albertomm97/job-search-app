package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.offers.infrastructure.persistence.entity.OfferEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface OfferJpaRepository extends JpaRepository<OfferEntity, String> {

}
