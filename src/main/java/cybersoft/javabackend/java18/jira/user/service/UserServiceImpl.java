package cybersoft.javabackend.java18.jira.user.service;

import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import cybersoft.javabackend.java18.jira.user.model.User;
import cybersoft.javabackend.java18.jira.user.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final JiraMapper mapper;
    private final UserRepository repository;

    public UserServiceImpl(JiraMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
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
