package om.metamorph.offerprovider.beanvalidations;

import om.metamorph.storagemanager.IStorageManager;
import om.metamorph.storagemanager.s3manager.S3Manager;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {LogoKeyModification.LogoKeyModificationValidator.class})
public @interface LogoKeyModification {
    String message() default "Logo must be uploaded";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class LogoKeyModificationValidator implements ConstraintValidator<LogoKeyModification, String> {

        IStorageManager storageManager;

        public LogoKeyModificationValidator() {
            this.storageManager = new S3Manager();
        }

        @Override
        public void initialize(LogoKeyModification logoKeyModification) {

        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            if(s == null) {
                return true;
            }
            return storageManager.keyExistsInUploadStorage(s);
        }
    }
}
