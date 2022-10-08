package cybersoft.javabackend.java18.jira.common.exception;

import cybersoft.javabackend.java18.jira.common.dto.ResponseDTO;
import cybersoft.javabackend.java18.jira.common.utils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*
        1. Annotation @ExceptionHandler with exception class
        2. response status @ResponseStatus
        3. Handle exception
     */

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleConstraintViolationException(
            ConstraintViolationException exception
    ) {
        return ResponseUtils.errors(exception,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleGlobalException(
            MethodArgumentNotValidException exception
    ) {
        return ResponseUtils.getErrors(exception,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JiraBusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleGlobalException(
            JiraBusinessException exception
    ) {
        return ResponseUtils.getErrors(exception,HttpStatus.BAD_REQUEST);
    }

}
