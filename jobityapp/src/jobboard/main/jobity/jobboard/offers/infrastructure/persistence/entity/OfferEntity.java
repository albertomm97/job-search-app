package jobity.jobboard.offers.infrastructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Offers")
public class OfferEntity {
    @Id
    private String id;
    private String title;
    private String salary;
}
