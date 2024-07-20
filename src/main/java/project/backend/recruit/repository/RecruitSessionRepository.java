package project.backend.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.recruit.domain.RecruitSession;

@Repository
public interface RecruitSessionRepository extends JpaRepository<RecruitSession, Long>{
}
