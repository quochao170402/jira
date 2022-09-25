package cybersoft.javabackend.java18.jira.role.repository;

import cybersoft.javabackend.java18.jira.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByCode(String code);

    void deleteByCode(String code);

    Optional<Role> findByName(String name);

    Role findTop1ByNameOrCode(String name, String code);

//    @Query("select r from Role r where r.name = :name or r.code = :code limit 1")
//    Role findByNameOrCode(@Param("name") String name,@Param("code") String code);
}
