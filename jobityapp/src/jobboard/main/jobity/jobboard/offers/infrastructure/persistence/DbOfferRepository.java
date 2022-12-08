package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

        String offerSql =
                "SELECT o.id, o.company_id, o.title, o.salary, o.experience, o.description " +
                "FROM offers o " +
                "WHERE o.id = :id";

        Offer offer = jdbcTemplate.queryForObject(offerSql, params, (resultSet, i) -> {
            return new Offer(
                    id,
                    new CompanyId(resultSet.getString("company_id")),
                    new OfferTitle(resultSet.getString("title")),
                    new OfferSalary(resultSet.getInt("salary")),
                    new OfferExperience(resultSet.getInt("experience")),
                    new OfferDescription(resultSet.getString("description"))
            );
        });

        if (offer == null) {
            throw new RuntimeException();
        }

        String categoriesSql =
                "SELECT c.type, c.value " +
                "FROM offers o " +
                "LEFT JOIN offers_categories oc ON o.id = oc.offer_id " +
                "LEFT JOIN categories c ON c.id = oc.category_id " +
                "WHERE o.id = :id";

        List<Category> categories = jdbcTemplate.query(offerSql, params, (resultSet, i) -> {
            return new Category(
                    resultSet.getString("value"),
                    resultSet.getString("type")
            );
        });

        offer.setCategories(categories);

        return offer;
    }
}
