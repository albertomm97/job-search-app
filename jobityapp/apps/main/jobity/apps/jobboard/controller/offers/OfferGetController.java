package jobity.apps.jobboard.controller.offers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jobity.jobboard.offers.application.search.OfferFinder;
import jobity.jobboard.offers.application.search.OfferListResponse;
import jobity.jobboard.offers.application.search.OfferResponse;
import jobity.jobboard.offers.domain.Offer;
import jobity.jobboard.offers.infrastructure.mapper.OfferMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferGetController {
    private final OfferFinder offerFinder;
    private final OfferMapper offerMapper;

    public OfferGetController(OfferFinder offerFinder, OfferMapper offerMapper) {
        this.offerFinder = offerFinder;
        this.offerMapper = offerMapper;
    }

    @Operation(summary = "Returns an offer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Offer returned"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping("/offers/{id}")
    public ResponseEntity<OfferResponse> handleById(@PathVariable String id) {

        Offer offer = offerFinder.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(offerMapper.offerToOfferResponse(offer));
    }

    @Operation(summary = "Returns a list of offers based on company id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Offer list returned"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping("/offers/company/{id}")
    public ResponseEntity<OfferListResponse> handleByCompanyId(@PathVariable String id) {

        List<Offer> offers = offerFinder.findByCompanyId(id);

        return ResponseEntity.status(HttpStatus.OK).body(offerMapper.offerListToOfferResponseList(offers));
    }

    @Operation(summary = "Returns a list of offers based on filters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Offer list returned"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping("/offers/filtered")
    public ResponseEntity<OfferListResponse> handleByFilter() {

        List<Offer> offers = offerFinder.findByFilter();

        return ResponseEntity.status(HttpStatus.OK).body(offerMapper.offerListToOfferResponseList(offers));
    }
}
