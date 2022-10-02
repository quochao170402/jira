package cybersoft.javabackend.java18.jira.role.service;

import cybersoft.javabackend.java18.jira.common.service.GenericService;
import cybersoft.javabackend.java18.jira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.jira.role.model.Operation;

import java.util.UUID;

public interface OperationService extends GenericService<Operation, OperationDTO, UUID> {
}
