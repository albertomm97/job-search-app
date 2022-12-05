package jobity.jobboard.offers.infrastructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class OfferEntity {
    @Id
    private String id;
    private String title;
    private Integer salary;

    public OfferEntity() {}
    public OfferEntity(String id, String title, Integer salary) {
        this.id = id;
        this.title = title;
        this.salary = salary;
    }

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer salary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
