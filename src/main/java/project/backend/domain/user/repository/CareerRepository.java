package project.backend.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.user.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
}
