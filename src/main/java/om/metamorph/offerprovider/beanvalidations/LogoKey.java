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
@Constraint(validatedBy = {LogoKey.LogoKeyValidator.class})
public @interface LogoKey {
    String message() default "Logo must be uploaded";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class LogoKeyValidator implements ConstraintValidator<LogoKey, String> {

        IStorageManager storageManager;

        public LogoKeyValidator() {
            this.storageManager = new S3Manager();
        }

        @Override
        public void initialize(LogoKey logoKey) {

        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            if(s == null) {
                return false;
            }
            return storageManager.keyExistsInUploadStorage(s);
        }
    }
}
