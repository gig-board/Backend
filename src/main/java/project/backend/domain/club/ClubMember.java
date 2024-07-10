package project.backend.domain.club;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;
import project.backend.domain.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubMember extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_member_id")
    private Long id;

    @Column(name = "club_member_name")
    private String name;

    @Column(name = "club_member_level")
    private String level;

    @Column(name = "club_member_session")
    private String session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @Builder
    private ClubMember(String name, String level, String session, Club club) {
        this.name = name;
        this.level = level;
        this.session = session;
        this.club = club;
    }

    public static ClubMember createClubMember(String name, String level, String session, Club club) {
        return ClubMember.builder()
                .name(name)
                .level(level)
                .session(session)
                .club(club)
                .build();
    }

}
