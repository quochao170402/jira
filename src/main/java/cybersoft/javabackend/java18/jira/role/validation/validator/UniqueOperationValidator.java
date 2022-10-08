package cybersoft.javabackend.java18.jira.role.validation.validator;

import cybersoft.javabackend.java18.jira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.jira.role.repository.OperationRepository;
import cybersoft.javabackend.java18.jira.role.validation.annotation.UniqueOperation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueOperationValidator implements ConstraintValidator<UniqueOperation, OperationDTO> {
    private String message;
    private final OperationRepository repository;

    public UniqueOperationValidator(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueOperation constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(OperationDTO operationDTO, ConstraintValidatorContext context) {
        if (repository.findTop1ByNameOrCode(operationDTO.getName(), operationDTO.getCode()) == null){
            return true;
        }

        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
