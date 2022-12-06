package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class DbOfferRepository implements OfferRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public DbOfferRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void save(Offer offer) {
        var params = new MapSqlParameterSource()
                .addValue("id", offer.id().value())
                .addValue("company_id", offer.companyId().value())
                .addValue("title", offer.title().value())
                .addValue("category", offer.category().value())
                .addValue("type", offer.offerType().value())
                .addValue("place", offer.offerPlace().value())
                .addValue("salary", offer.salary().value())
                .addValue("experience", offer.offerExperience().value())
                .addValue("category", offer.category().value())
                .addValue("study_level",offer.offerStudyLevel().value())
                .addValue("description", offer.description().value())
                .getValues();

        String sql = "INSERT INTO offers (id, company_id, title) VALUES (:id, :company_id, :title)";

        jdbcTemplate.update(sql, params);
    }

    @Override
    public Offer search(OfferId id) {
        return null;
    }
}
