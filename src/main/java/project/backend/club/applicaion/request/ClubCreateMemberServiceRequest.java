package project.backend.club.applicaion.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.domain.Club;
import project.backend.club.domain.ClubMember;
import project.backend.club.domain.ClubTeam;

@Getter
@NoArgsConstructor
public class ClubCreateMemberServiceRequest {

    private String name;
    private String session;
    private String level;
    private Long clubTeamId;

    @Builder
    public ClubCreateMemberServiceRequest(
            String name,
            String session,
            String level,
            Long clubTeamId) {

        this.name = name;
        this.session = session;
        this.level = level;
        this.clubTeamId = clubTeamId;

    }

    public ClubMember toEntity(Club club, ClubTeam clubTeam) {

        return ClubMember.builder()
                .name(name)
                .session(session)
                .level(level)
                .club(club)
                .clubTeam(clubTeam)
                .build();

    }

}
