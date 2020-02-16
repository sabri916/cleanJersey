package om.metamorph.offerprovider.beanvalidations;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {OfferProviderName.OfferProviderNameValidator.class})
public @interface OfferProviderName {
    String message() default "Offer Provider name must be 3 - 255 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class OfferProviderNameValidator implements ConstraintValidator<OfferProviderName, String> {
        @Override
        public void initialize(OfferProviderName offerProviderName) {

        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            return (s.length() >= 3 && s.length() <= 255);
        }
    }
}
