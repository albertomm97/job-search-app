package jobity.jobboard.companies.domain;

import jobity.shared.domain.ValueObject;

public final class CompanyId extends ValueObject<String> {
    public CompanyId(String value) {
        super(value);
    }
}
