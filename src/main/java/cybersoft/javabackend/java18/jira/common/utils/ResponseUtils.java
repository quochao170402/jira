package cybersoft.javabackend.java18.jira.common.utils;

import cybersoft.javabackend.java18.jira.common.dto.ResponseDTO;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class ResponseUtils {
    public static ResponseEntity<ResponseDTO> get(Object result, HttpStatus status){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(result)
                        .hasErrors(false)
                        .errors(Collections.emptyList())
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build(),
                status);
    }

    public static ResponseEntity<ResponseDTO> errors(List<String> errors, HttpStatus status){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(errors)
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build(),
                status);
    }

    public static ResponseEntity<ResponseDTO> errors(ConstraintViolationException exception, HttpStatus status){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(ExceptionUtils.getErrors(exception))
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build(),
                status);
    }

    public static ResponseEntity<ResponseDTO> getErrors(MethodArgumentNotValidException exception, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(ExceptionUtils.getErrors(exception))
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build(),
                status);
    }
}
