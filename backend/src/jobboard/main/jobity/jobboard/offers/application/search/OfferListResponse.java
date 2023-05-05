package jobity.jobboard.offers.application.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OfferListResponse {
    private List<OfferResponse> offers;

    public void OfferListResponse() {}

    public OfferListResponse(List<OfferResponse> offers) {
        this.offers = offers;
    }

    public void setOffers(List<OfferResponse> offers) {
        this.offers = offers;
    }

    public List<OfferResponse> getOffers() {
        return offers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferListResponse that = (OfferListResponse) o;
        return offers.equals(that.offers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offers);
    }
}
