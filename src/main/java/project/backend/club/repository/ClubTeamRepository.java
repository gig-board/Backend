package project.backend.club.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.club.domain.ClubTeam;

@Repository
public interface ClubTeamRepository extends JpaRepository<ClubTeam, Long> {
    Optional<ClubTeam> findByIdAndClubId(Long teamId, Long clubId);

}
