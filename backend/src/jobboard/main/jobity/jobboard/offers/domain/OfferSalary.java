package jobity.jobboard.offers.domain;

import jobity.shared.domain.ValueObject;

public final class OfferSalary extends ValueObject<Integer> {
    public OfferSalary(Integer value) {
        super(value);
    }
}
