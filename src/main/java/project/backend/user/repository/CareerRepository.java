package project.backend.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.user.domain.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
}
