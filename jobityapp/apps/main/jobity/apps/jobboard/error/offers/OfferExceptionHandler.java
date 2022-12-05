package jobity.apps.jobboard.error.offers;


import jobity.jobboard.shared.infrastructure.error.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class OfferExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppError> genericExceptionHandler(Exception exception) {

        return resolveError(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<AppError> handleConstraintValidation(ConstraintViolationException exception) {

        AppError error = new AppError(HttpStatus.BAD_REQUEST, exception);
        error.setMessage("Validation Error");
        error.addValidationErrors(exception.getConstraintViolations());

        return ResponseEntity.status(error.getStatus()).body(error);
    }

    private ResponseEntity<AppError> resolveError(HttpStatus status, Exception exception) {
        AppError error = new AppError(status, exception, exception.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
