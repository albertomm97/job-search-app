package jobity.apps.jobboard.controller.offers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jobity.jobboard.offers.application.create.OfferCreator;
import jobity.jobboard.offers.application.create.CreateOfferRequest;

@RestController
public class OfferPutController {

    private final OfferCreator offerCreator;

    public OfferPutController(OfferCreator offerCreator) {
        this.offerCreator = offerCreator;
    }

    @PutMapping("/jobity/jobboard/offers/{id}")
    public ResponseEntity<Object> create(@PathVariable String id,
                                         @RequestBody CreateOfferRequest request) {

        offerCreator.create(request.getId(), request.getTitle(), request.getSalary());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
