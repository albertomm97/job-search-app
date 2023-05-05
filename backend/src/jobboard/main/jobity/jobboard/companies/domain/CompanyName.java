package jobity.jobboard.companies.domain;

import jobity.shared.domain.ValueObject;

public final class CompanyName extends ValueObject<String> {
    public CompanyName(String value) {
        super(value);
    }
}
