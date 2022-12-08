package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.domain.OfferId;
import jobity.jobboard.offers.domain.OfferRepository;
import jobity.jobboard.offers.domain.OfferTitle;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DbOfferRepository implements OfferRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DbOfferRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void save(Offer offer) {
        var offerParams = new MapSqlParameterSource()
                .addValue("id", offer.id().value())
                .addValue("company_id", offer.companyId().value())
                .addValue("title", offer.title().value())
                .addValue("salary", offer.salary().value())
                .addValue("experience", offer.offerExperience().value())
                .addValue("category", offer.category().value())
                .addValue("description", offer.description().value())
                .getValues();

        var categoryParams = new MapSqlParameterSource()
                .addValue("offer_id", offer.id().value())
                .addValue("category", offer.category().value())
                .addValue("type", offer.offerType().value())
                .addValue("place", offer.offerPlace().value())
                .addValue("study_level", offer.offerStudyLevel().value())
                .addValue("work_time", offer.offerWorkTime().value())
                .getValues();

        String offerInsert =
                "INSERT INTO offers " +
                "(id, company_id, title, salary, experience, description, created_at) " +
                "VALUES (:id, :company_id, :title, :salary, :experience, :description, CURRENT_TIMESTAMP())";
        jdbcTemplate.update(offerInsert, offerParams);

        String categoryInsert =
                "INSERT INTO offers_categories " +
                "SELECT :offer_id as offer_id, c.id as category_id " +
                "FROM offers o, categories c " +
                "WHERE c.value IN (:category, :type, :place, :study_level, :work_time)";
        jdbcTemplate.update(categoryInsert, categoryParams);
    }

    @Override
    public Offer search(OfferId id) {

        var params = new MapSqlParameterSource()
                .addValue("id", id.value())
                .getValues();

        String sql =
                "SELECT * FROM offers o WHERE o.id = :id";

        Offer offer = jdbcTemplate.queryForObject(sql, params, (resultSet, i) -> {
            return null;
        });

        return null;
    }
}
