package project.backend.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.club.domain.ClubTeam;

@Repository
public interface ClubTeamRepository extends JpaRepository<ClubTeam, Long>{
}
