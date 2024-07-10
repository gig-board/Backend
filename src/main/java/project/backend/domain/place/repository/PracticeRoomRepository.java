package project.backend.domain.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.domain.place.PracticeRoom;

@Repository
public interface PracticeRoomRepository extends JpaRepository<PracticeRoom, Long> {
}
