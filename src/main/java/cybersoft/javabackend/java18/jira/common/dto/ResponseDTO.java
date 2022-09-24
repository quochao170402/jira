package cybersoft.javabackend.java18.jira.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Object content;
    private boolean hasErrors;
    private List<String> errors;
    private String timestamp;
    private int status;
}
