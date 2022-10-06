package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import cybersoft.javabackend.java18.jira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.jira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.jira.role.dto.RoleWIthOperationDTO;
import cybersoft.javabackend.java18.jira.role.model.Operation;
import cybersoft.javabackend.java18.jira.role.model.Role;
import cybersoft.javabackend.java18.jira.role.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final JiraMapper mapper;

    private final OperationService operationService;

    public RoleServiceImpl(RoleRepository repository, JiraMapper mapper, OperationService operationService) {
        this.repository = repository;
        this.mapper = mapper;
        this.operationService = operationService;
    }

    @Override
    public Role update(Role role, String code) {
        Role curRole = repository.findByCode(code);
        curRole.setName(role.getName());
        curRole.setDescription(role.getDescription());
        return repository.save(curRole);
    }

    @Override
    public void deleteByCode(String code) {
        repository.deleteByCode(code);
    }

    @Override
    public RoleDTO save(RoleDTO dto) {
        Role model = mapper.map(dto, Role.class);
        Role savedModel = repository.save(model);
        return mapper.map(savedModel, RoleDTO.class);
    }

    @Override
    public RoleWIthOperationDTO addOperations(List<UUID> ids, UUID roleId) {
        Role currentRole = repository.findById(roleId)
                .orElseThrow(() ->
                        new ValidationException("Role is not existed")
                );
        List<Operation> operations = operationService.findAllByIds(ids);
        operations.forEach(currentRole::addOperation);
        repository.save(currentRole);
        RoleWIthOperationDTO dto = mapper.map(currentRole, RoleWIthOperationDTO.class);
        operations.forEach(operation -> dto.getOperationDTOs().add(mapper.map(operation, OperationDTO.class)));
        return dto;
    }

    @Override
    public JpaRepository<Role, UUID> getRepository() {
        return this.repository;
    }

    @Override
    public JiraMapper getMapper() {
        return this.mapper;
    }
}
