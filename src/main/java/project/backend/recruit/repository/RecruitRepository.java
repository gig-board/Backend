package project.backend.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.recruit.domain.Recruit;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Long>{
}
