package cybersoft.javabackend.java18.jira.role.validation.validator;

import cybersoft.javabackend.java18.jira.role.dto.UserGroupDTO;
import cybersoft.javabackend.java18.jira.role.repository.UserGroupRepository;
import cybersoft.javabackend.java18.jira.role.validation.annotation.UniqueUserGroup;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserGroupValidator implements ConstraintValidator<UniqueUserGroup, UserGroupDTO> {
    private String message;
    private final UserGroupRepository repository;

    public UniqueUserGroupValidator(UserGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueUserGroup constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserGroupDTO userGroupDTO, ConstraintValidatorContext context) {
        if (repository.findTop1ByNameOrCode(userGroupDTO.getName(), userGroupDTO.getCode()) == null) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
