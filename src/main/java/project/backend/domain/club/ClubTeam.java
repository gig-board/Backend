package project.backend.domain.club;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubTeam extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_team_id")
    private Long id;

    @Column(name = "club_team_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_member_id")
    private ClubMember clubMember;

    @Builder
    public ClubTeam(String name, Club club, ClubMember clubMember) {
        this.name = name;
        this.club = club;
        this.clubMember = clubMember;
    }

    public static ClubTeam createClubTeam(String name, Club club, ClubMember clubMember) {
        return ClubTeam.builder()
                .name(name)
                .club(club)
                .clubMember(clubMember)
                .build();
    }

}
