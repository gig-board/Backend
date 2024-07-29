package project.backend.club.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.BaseEntity;
import project.backend.club.applicaion.request.ClubEditMemberServiceRequest;

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

    @Column(name = "club_member_session")
    private String session;

    @Column(name = "club_member_level")
    private String level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_team_id")
    private ClubTeam clubTeam;

    @Builder
    private ClubMember(
            String name,
            String level,
            String session,
            Club club,
            ClubTeam clubTeam) {

        this.name = name;
        this.level = level;
        this.session = session;
        this.club = club;
        this.clubTeam = clubTeam;

    }

    public void editClubMember(ClubEditMemberServiceRequest request) {

        this.name = request.getName();
        this.level = request.getLevel();
        this.session = request.getSession();

    }

    public void changeClubTeam(ClubTeam newClubTeam) {
        this.clubTeam = newClubTeam;
    }

}
