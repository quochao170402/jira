package cybersoft.javabackend.java18.jira.security.validation.annotation;

import cybersoft.javabackend.java18.jira.security.validation.validator.MustBeExistedUserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MustBeExistedUserValidator.class)
public @interface MustBeExistedUser {
    String message() default "{user.not.existed}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
