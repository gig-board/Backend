package project.backend.domain.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.recruit.Recruit;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Long>{
}
