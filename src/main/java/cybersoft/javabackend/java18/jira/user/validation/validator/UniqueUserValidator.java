package cybersoft.javabackend.java18.jira.user.validation.validator;

import cybersoft.javabackend.java18.jira.user.dto.UserDTO;
import cybersoft.javabackend.java18.jira.user.repository.UserRepository;
import cybersoft.javabackend.java18.jira.user.validation.annotation.UniqueUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserValidator implements ConstraintValidator<UniqueUser, UserDTO> {
    private String message;
    private final UserRepository repository;

    public UniqueUserValidator(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueUser constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        if (repository.findTop1ByUsernameOrEmail(userDTO.getUsername(), userDTO.getEmail()) == null) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
