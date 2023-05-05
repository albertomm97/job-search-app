package jobity.apps.jobboard.error.offers;

import com.fasterxml.jackson.databind.JsonMappingException;
import jobity.jobboard.shared.infrastructure.error.AppError;
import jobity.shared.domain.ResourceNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class OfferExceptionHandler {

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppError> genericExceptionHandler(Exception exception) {

        return resolveError(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

     */

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AppError> resourceNotFoundHandler(ResourceNotFoundException exception) {
        return resolveError(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<AppError> handleConstraintValidation(ConstraintViolationException exception) {

        AppError error = new AppError(HttpStatus.BAD_REQUEST, "Validation Error", exception);
        error.addValidationErrors(exception.getConstraintViolations());

        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<AppError> handleConstraintValidations(JsonMappingException exception) {

        AppError error = new AppError(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);

        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<AppError> handleConstraintValidation(DataAccessException exception) {

        AppError error = new AppError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);

        return ResponseEntity.status(error.getStatus()).body(error);
    }

    private ResponseEntity<AppError> resolveError(HttpStatus status, Exception exception) {
        AppError error = new AppError(status, exception.getMessage(), exception);
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
