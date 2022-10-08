package cybersoft.javabackend.java18.jira.role.validation.validator;

import cybersoft.javabackend.java18.jira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.jira.role.model.Role;
import cybersoft.javabackend.java18.jira.role.repository.RoleRepository;
import cybersoft.javabackend.java18.jira.role.validation.annotation.UniqueRole;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRoleValidator implements ConstraintValidator<UniqueRole, RoleDTO> {
    private String message;
    private final RoleRepository roleRepository;

    public UniqueRoleValidator(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initialize(UniqueRole constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(RoleDTO roleDTO, ConstraintValidatorContext context) {
        Role existedRole = roleRepository.findTop1ByNameOrCode(roleDTO.getName(), roleDTO.getCode());
        if (existedRole==null) return true;

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }


}
