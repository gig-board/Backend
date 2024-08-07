package project.backend.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.place.domain.PracticeRoom;

@Repository
public interface PracticeRoomRepository extends JpaRepository<PracticeRoom, Long> {
}
