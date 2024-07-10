package project.backend.domain.club;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;

@Entity
@Getter
@NoArgsConstructor
public class ClubSession extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "club_session_id")
    private Long id;

    @Column(name = "club_session")
    private String session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @Builder
    private ClubSession(String session, Club club) {
        this.session = session;
        this.club = club;
    }

    public static ClubSession createClubSession(String session, Club club) {
        return ClubSession.builder()
                .session(session)
                .club(club)
                .build();
    }

}
