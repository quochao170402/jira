package cybersoft.javabackend.java18.jira.role.repository;

import cybersoft.javabackend.java18.jira.role.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, UUID> {

    UserGroup findTop1ByNameOrCode(String name, String code);

    /*
        Solutions for n+1 problem:
        Solution 1: Adding left join to query statement.
        Solution 2: Adding fetch to query statement.
     */
    @Query("select distinct ug from UserGroup as ug left join fetch ug.users")
    List<UserGroup> findAllIncludeUsers();
}
