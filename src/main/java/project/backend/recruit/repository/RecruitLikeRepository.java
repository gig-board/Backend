package project.backend.recruit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.recruit.domain.RecruitLike;

@Repository
public interface RecruitLikeRepository extends JpaRepository<RecruitLike, Long>{
}
