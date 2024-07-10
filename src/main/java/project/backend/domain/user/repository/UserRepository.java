package project.backend.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
