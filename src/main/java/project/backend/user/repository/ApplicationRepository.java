package project.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.user.domain.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
