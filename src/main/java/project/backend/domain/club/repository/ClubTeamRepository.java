package project.backend.domain.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.club.ClubTeam;

@Repository
public interface ClubTeamRepository extends JpaRepository<ClubTeam, Long>{
}
