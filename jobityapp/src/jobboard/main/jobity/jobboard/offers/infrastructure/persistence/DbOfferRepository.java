package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import jobity.shared.domain.ResourceNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Primary
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
                .addValue("description", offer.description().value())
                .addValue("created_at", offer.createdAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .getValues();

        var categoryValues = offer.categories().stream()
                .collect(Collectors.toMap(Category::type, Category::value));

        var categoryParams = new MapSqlParameterSource()
                .addValue("offer_id", offer.id().value())
                .addValues(categoryValues)
                .getValues();

        String offerInsert =
                "INSERT INTO offers " +
                "(id, company_id, title, salary, experience, description, created_at) " +
                "VALUES (:id, :company_id, :title, :salary, :experience, :description, :created_at)";
        jdbcTemplate.update(offerInsert, offerParams);

        String categoryInsert =
                "INSERT INTO offers_categories " +
                "SELECT :offer_id as offer_id, c.id as category_id " +
                "FROM offers o, categories c " +
                "WHERE c.category_value IN (:category, :type, :place, :study_level, :work_time)";
        jdbcTemplate.update(categoryInsert, categoryParams);
    }

    @Override
    public Offer findById(OfferId id) {
        var params = new MapSqlParameterSource()
                .addValue("id", id.value())
                .getValues();

        String offerSql =
                "SELECT o.*, GROUP_CONCAT(c.category_type) AS category_type, GROUP_CONCAT(c.category_value) AS category_value " +
                "FROM offers o " +
                "LEFT JOIN offers_categories oc ON o.id = oc.offer_id " +
                "LEFT JOIN categories c ON c.id = oc.category_id " +
                "WHERE o.id = :id " +
                "GROUP BY o.id ";

        List<Offer> offer = jdbcTemplate.query(offerSql, params, new OfferRowMapper());

        return offer.isEmpty() ? null : offer.get(0);
    }

    @Override
    public List<Offer> findByCompanyId(CompanyId id) {
        var params = new MapSqlParameterSource()
                .addValue("id", id.value())
                .getValues();

        String offerSql =
                "SELECT o.*, GROUP_CONCAT(c.category_type) AS category_type, GROUP_CONCAT(c.category_value) AS category_value " +
                "FROM offers o " +
                "LEFT JOIN offers_categories oc ON o.id = oc.offer_id " +
                "LEFT JOIN categories c ON c.id = oc.category_id " +
                "WHERE o.company_id = :id " +
                "GROUP BY o.id ";

        List<Offer> offers = jdbcTemplate.query(offerSql, params, new OfferRowMapper());

        return offers.isEmpty() ? null : offers;
    }

    @Override
    public List<Offer> findByFilter() {
        return null;
    }

}
