package jobity.apps.jobboard.controller.offers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jobity.jobboard.offers.application.create.OfferCreator;
import jobity.jobboard.offers.application.create.CreateOfferCommand;

@RestController
public class OfferPutController {

    private final OfferCreator offerCreator;

    public OfferPutController(OfferCreator offerCreator) {
        this.offerCreator = offerCreator;
    }

    @Operation(summary = "Creates a new offer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Offer created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PutMapping("/offers/{id}")
    public ResponseEntity<String> create(@PathVariable String id,
                                         @RequestBody Request request) {


        offerCreator.create(new CreateOfferCommand(id, request.getTitle(), request.getSalary()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

final class Request {
    private String title;
    private Integer salary;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public Integer getSalary() {
        return salary;
    }
}
