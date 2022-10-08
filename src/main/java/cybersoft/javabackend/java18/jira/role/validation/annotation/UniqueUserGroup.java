package cybersoft.javabackend.java18.jira.role.validation.annotation;

import cybersoft.javabackend.java18.jira.role.validation.validator.UniqueUserGroupValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUserGroupValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUserGroup {
    String message() default "{usergroup.existed}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
