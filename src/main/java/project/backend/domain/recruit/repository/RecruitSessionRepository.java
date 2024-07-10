package project.backend.domain.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.recruit.RecruitSession;

@Repository
public interface RecruitSessionRepository extends JpaRepository<RecruitSession, Long>{
}
