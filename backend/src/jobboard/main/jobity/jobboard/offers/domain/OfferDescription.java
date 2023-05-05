package jobity.jobboard.offers.domain;

import jobity.shared.domain.ValueObject;

public final class OfferDescription extends ValueObject<String> {
    public OfferDescription(String value) {
        super(value);
    }
}
