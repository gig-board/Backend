package project.backend.club.applicaion.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.domain.Club;
import project.backend.club.domain.ClubMember;
import project.backend.club.domain.ClubTeam;

@Getter
@NoArgsConstructor
public class ClubMemberServiceRequest {

    private String name;
    private String level;
    private String session;
    private Long clubId;
    private Long clubTeamId;

    @Builder
    public ClubMemberServiceRequest(
            String name,
            String level,
            String session,
            Long clubId,
            Long clubTeamId) {
        this.name = name;
        this.level = level;
        this.session = session;
        this.clubId = clubId;
        this.clubTeamId = clubTeamId;
    }

    public ClubMember toEntity(Club club, ClubTeam clubTeam) {
        return ClubMember.builder()
                .name(name)
                .level(level)
                .session(session)
                .club(club)
                .clubTeam(clubTeam)
                .build();
    }

}
