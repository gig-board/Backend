package project.backend.club.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.club.domain.ClubMemberLevel;

@Repository
public interface ClubMemberLevelRepository extends JpaRepository<ClubMemberLevel, Long> {
    Optional<ClubMemberLevel> findByClubId(Long clubId);

}
