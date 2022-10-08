package cybersoft.javabackend.java18.jira.common.exception;

public class JiraBusinessException extends RuntimeException {
    public JiraBusinessException(String message){
        super(message);
    }
}
