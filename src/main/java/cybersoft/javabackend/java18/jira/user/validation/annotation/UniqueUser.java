package cybersoft.javabackend.java18.jira.user.validation.annotation;

import cybersoft.javabackend.java18.jira.user.validation.validator.UniqueUserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUserValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUser {

    String message() default "{user.existed}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
