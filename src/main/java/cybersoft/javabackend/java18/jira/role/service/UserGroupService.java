package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.common.service.GenericService;
import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import cybersoft.javabackend.java18.jira.role.dto.UserGroupDTO;
import cybersoft.javabackend.java18.jira.role.dto.UserGroupWithUsersDTO;
import cybersoft.javabackend.java18.jira.role.model.UserGroup;
import cybersoft.javabackend.java18.jira.role.repository.UserGroupRepository;
import cybersoft.javabackend.java18.jira.user.model.User;
import cybersoft.javabackend.java18.jira.user.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

public interface UserGroupService extends GenericService<UserGroup, UserGroupDTO, UUID> {
    UserGroupWithUsersDTO addUserToGroup(UUID groupId, List<UUID> ids);

    List<UserGroupWithUsersDTO> findAllUserGroupIncludeUser();
}

@Service
@Transactional
class UserGroupServiceImpl implements UserGroupService {
    private final UserService userService;
    private final UserGroupRepository repository;
    private final JiraMapper mapper;

    public UserGroupServiceImpl(UserService userService, UserGroupRepository repository, JiraMapper mapper) {
        this.userService = userService;
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public JpaRepository<UserGroup, UUID> getRepository() {
        return repository;
    }

    @Override
    public JiraMapper getMapper() {
        return mapper;
    }

    @Override
    public UserGroupWithUsersDTO addUserToGroup(UUID groupId, List<UUID> ids) {
        UserGroup currentGroup = repository.findById(groupId)
                .orElseThrow(() ->
                        new ValidationException("Group is not existed")
                );
        List<User> users = userService.findAllByIds(ids);

        users.forEach(currentGroup::addUserToGroup);

        return mapper.map(currentGroup, UserGroupWithUsersDTO.class);
    }

    @Override
    public List<UserGroupWithUsersDTO> findAllUserGroupIncludeUser() {
        return repository.findAllIncludeUsers()
                .stream()
                .map(userGroup -> mapper.map(userGroup, UserGroupWithUsersDTO.class))
                .toList();
    }
}
