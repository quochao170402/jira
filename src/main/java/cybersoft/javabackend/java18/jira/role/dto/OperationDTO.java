package cybersoft.javabackend.java18.jira.role.dto;

import cybersoft.javabackend.java18.jira.role.model.Operation;
import cybersoft.javabackend.java18.jira.role.validation.annotation.UniqueOperation;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UniqueOperation
public class OperationDTO {
    private UUID id;
    @Length(min = 5, max = 100, message = "{service.name.size}")
    @NotBlank
    private String name;
    @Length(min = 3, max = 20, message = "{role.code.size}")
    @NotBlank
    private String code;
    @NotBlank(message = "Service description can not be blank")
    private String description;

    private Operation.Type type;
}
