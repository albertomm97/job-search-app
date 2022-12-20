package jobity.jobboard.offers.infrastructure.persistence;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OfferRowMapper implements RowMapper<Offer> {

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var categories = getCategories(
                resultSet.getString("category_value"),
                resultSet.getString("category_type"));

        return new Offer(
                new OfferId(resultSet.getString("id")),
                new CompanyId(resultSet.getString("company_id")),
                new OfferTitle(resultSet.getString("title")),
                new OfferSalary(resultSet.getInt("salary")),
                new OfferExperience(resultSet.getInt("experience")),
                new OfferDescription(resultSet.getString("description")),
                LocalDateTime.parse(resultSet.getString("created_at"), DateTimeFormatter.ofPattern(dateFormat)),
                categories
        );
    }

    private List<Category> getCategories(String valuesStr, String typesStr) {
        var types = typesStr.split(",");
        var values = valuesStr.split(",");

        List<Category> categories = IntStream.range(0, types.length).boxed().map(index -> {
            return new Category(values[index], types[index]);
        }).collect(Collectors.toList());

        return categories;
    }
}
