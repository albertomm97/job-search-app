package jobity.jobboard.offers.domain;

import jobity.shared.domain.ValueObject;

public final class OfferType extends ValueObject<String> {
    public OfferType(String value) {
        super(value);
    }
}
