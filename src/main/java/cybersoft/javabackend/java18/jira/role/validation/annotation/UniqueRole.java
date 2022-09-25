package cybersoft.javabackend.java18.jira.role.validation.annotation;

import cybersoft.javabackend.java18.jira.role.validation.validator.UniqueRoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueRoleValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueRole {
    String message() default "Role name or code is existed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
