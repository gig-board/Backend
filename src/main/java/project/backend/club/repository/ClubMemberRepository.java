package project.backend.club.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.club.domain.ClubMember;

@Repository
public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {
    Optional<ClubMember> findByIdAndClubId(Long memberId, Long clubId);

}
