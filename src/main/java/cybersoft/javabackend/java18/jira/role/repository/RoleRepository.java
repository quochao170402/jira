package cybersoft.javabackend.java18.jira.role.repository;

import cybersoft.javabackend.java18.jira.role.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
    RoleModel findByCode(String code);

    void deleteByCode(String code);
}
