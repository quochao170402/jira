package cybersoft.javabackend.java18.jira.role.repository;

import cybersoft.javabackend.java18.jira.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findTop1ByNameOrCode(String name, String code);

    @Query("select r from Role as r left join fetch r.operations")
    List<Role> findAllIncludeOperation();
}
