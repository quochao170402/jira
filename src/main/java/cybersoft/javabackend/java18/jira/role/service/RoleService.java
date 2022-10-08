package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.common.service.GenericService;
import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import cybersoft.javabackend.java18.jira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.jira.role.dto.RoleWithOperationDTO;
import cybersoft.javabackend.java18.jira.role.model.Operation;
import cybersoft.javabackend.java18.jira.role.model.Role;
import cybersoft.javabackend.java18.jira.role.repository.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

public interface RoleService extends GenericService<Role, RoleDTO, UUID> {
    RoleDTO save(RoleDTO dto);

    RoleWithOperationDTO addOperations(List<UUID> ids, UUID roleId);

    List<RoleWithOperationDTO> findAllIncludeOperation();
}

@Service
@Transactional
class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final JiraMapper mapper;

    private final OperationService operationService;

    public RoleServiceImpl(RoleRepository repository, JiraMapper mapper, OperationService operationService) {
        this.repository = repository;
        this.mapper = mapper;
        this.operationService = operationService;
    }

    @Override
    public RoleDTO save(RoleDTO dto) {
        Role model = mapper.map(dto, Role.class);
        Role savedModel = repository.save(model);
        return mapper.map(savedModel, RoleDTO.class);
    }

    @Override
    public RoleWithOperationDTO addOperations(List<UUID> ids, UUID roleId) {
        Role currentRole = repository.findById(roleId)
                .orElseThrow(() ->
                        new ValidationException("Role is not existed")
                );
        List<Operation> operations = operationService.findAllByIds(ids);
        operations.forEach(currentRole::addOperation);
        return mapper.map(repository.save(currentRole), RoleWithOperationDTO.class);
    }

    @Override
    public List<RoleWithOperationDTO> findAllIncludeOperation() {
        return repository.findAllIncludeOperation()
                .stream()
                .map(role -> mapper.map(role, RoleWithOperationDTO.class))
                .toList();
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
