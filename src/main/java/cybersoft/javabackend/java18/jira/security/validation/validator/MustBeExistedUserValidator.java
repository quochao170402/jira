package cybersoft.javabackend.java18.jira.security.validation.validator;

import cybersoft.javabackend.java18.jira.security.validation.annotation.MustBeExistedUser;
import cybersoft.javabackend.java18.jira.user.model.User;
import cybersoft.javabackend.java18.jira.user.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MustBeExistedUserValidator implements ConstraintValidator<MustBeExistedUser, String> {
    private String message;
    private final UserRepository repository;

    public MustBeExistedUserValidator(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public void initialize(MustBeExistedUser constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        User user = repository.findByUsername(username).orElse(null);
        if (user != null) return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
