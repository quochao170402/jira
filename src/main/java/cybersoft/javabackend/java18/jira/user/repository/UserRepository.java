package cybersoft.javabackend.java18.jira.user.repository;

import cybersoft.javabackend.java18.jira.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
