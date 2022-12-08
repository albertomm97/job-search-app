package jobity.jobboard.shared.infrastructure.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@JsonTypeInfo(
        include = JsonTypeInfo.As.WRAPPER_OBJECT,
        use = JsonTypeInfo.Id.NAME,
        property = "error",
        visible = true
)
public class AppError {

    @JsonInclude()
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    @JsonInclude()
    private String message;

    @JsonIgnore
    private String debugMessage;

    @JsonSerialize()
    private List<String> errors;

    private AppError() {
        this.timestamp = LocalDateTime.now();
        errors = new ArrayList<>();
    }

    public AppError(HttpStatus status) {
        this();
        this.status = status;
    }

    public AppError(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public AppError(HttpStatus status, Throwable exception) {
        this(status);
        this.message = "Unexpected Error";
        this.debugMessage = exception.getLocalizedMessage();
    }

    public AppError(HttpStatus status, String message, Throwable exception) {
        this(status, message);
        this.debugMessage = exception.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
        constraintViolations.forEach(this::addValidationError);
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    private void addValidationError(ConstraintViolation<?> cv) {
        this.addValidationError(
                ((PathImpl) cv.getPropertyPath()).getLeafNode().asString(),
                cv.getMessage());
    }

    private void addValidationError(FieldError fieldError) {
        this.addValidationError(
                fieldError.getField(),
                fieldError.getDefaultMessage());
    }

    private void addValidationError(String field, String message) {
        addSubError(String.format("%s:%s",field, message));
    }

    private void addSubError(String subError) {
        errors.add(subError);
    }
}
