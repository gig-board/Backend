package project.backend.domain.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.application.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
