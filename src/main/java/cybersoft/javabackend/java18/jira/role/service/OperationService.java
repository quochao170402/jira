package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.common.service.GenericService;
import cybersoft.javabackend.java18.jira.common.utils.JiraMapper;
import cybersoft.javabackend.java18.jira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.jira.role.model.Operation;
import cybersoft.javabackend.java18.jira.role.repository.OperationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

public interface OperationService extends GenericService<Operation, OperationDTO, UUID> {
}


@Service
@Transactional
class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;
    private final JiraMapper jiraMapper;

    public OperationServiceImpl(OperationRepository operationRepository, JiraMapper jiraMapper) {
        this.operationRepository = operationRepository;
        this.jiraMapper = jiraMapper;
    }

    @Override
    public JpaRepository<Operation, UUID> getRepository() {
        return operationRepository;
    }

    @Override
    public JiraMapper getMapper() {
        return jiraMapper;
    }
}
