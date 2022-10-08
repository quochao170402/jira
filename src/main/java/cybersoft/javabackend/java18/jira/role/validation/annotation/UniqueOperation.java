package cybersoft.javabackend.java18.jira.role.validation.annotation;

import cybersoft.javabackend.java18.jira.role.validation.validator.UniqueOperationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueOperationValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueOperation {
    String message() default "{operation.existed}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
