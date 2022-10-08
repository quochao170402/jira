package cybersoft.javabackend.java18.jira.user.service;

import cybersoft.javabackend.java18.jira.common.service.GenericService;
import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import cybersoft.javabackend.java18.jira.user.dto.UserDTO;
import cybersoft.javabackend.java18.jira.user.model.User;
import cybersoft.javabackend.java18.jira.user.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

public interface UserService extends GenericService<User, UserDTO, UUID> {
    UserDTO createUser(UserDTO userDTO);
}

@Service
@Transactional
class UserServiceImpl implements UserService{
    private final JiraMapper mapper;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(JiraMapper mapper, UserRepository repository, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.map(
                repository.save(user),
                UserDTO.class
        );
    }

    @Override
    public JpaRepository<User, UUID> getRepository() {
        return repository;
    }

    @Override
    public JiraMapper getMapper() {
        return mapper;
    }
}
