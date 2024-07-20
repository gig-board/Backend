package project.backend.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.club.domain.ClubSession;

@Repository
public interface ClubSessionRepository extends JpaRepository<ClubSession, Long> {
}
