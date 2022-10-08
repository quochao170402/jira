package cybersoft.javabackend.java18.jira.user.service;

import cybersoft.javabackend.java18.jira.common.service.GenericService;
import cybersoft.javabackend.java18.jira.user.dto.UserDTO;
import cybersoft.javabackend.java18.jira.user.model.User;

import java.util.UUID;

public interface UserService extends GenericService<User, UserDTO, UUID> {
    UserDTO createUser(UserDTO userDTO);
}
