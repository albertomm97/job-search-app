package jobity.jobboard.shared.application.validation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public abstract class ValidatedObject<T> {
    private Validator validator;
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public ValidatedObject() {
        validator = factory.getValidator();
    }

    /**
     * Evaluates all Bean Validations on the attributes of this
     * instance.
     */
    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
