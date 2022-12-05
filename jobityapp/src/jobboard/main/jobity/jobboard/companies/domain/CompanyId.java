package jobity.jobboard.companies.domain;

import jobity.shared.domain.ValueObject;

public class CompanyId extends ValueObject<String> {
    public CompanyId(String value) {
        super(value);
    }
}
