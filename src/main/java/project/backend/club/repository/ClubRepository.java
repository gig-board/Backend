package project.backend.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.club.domain.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}
