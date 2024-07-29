package project.backend.club.applicaion.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.domain.Club;
import project.backend.club.domain.ClubMember;
import project.backend.club.domain.ClubTeam;

@Getter
@NoArgsConstructor
public class ClubEditMemberServiceRequest {

    private String name;
    private String session;
    private String level;

    @Builder
    public ClubEditMemberServiceRequest(
            String name,
            String session,
            String level) {

        this.name = name;
        this.session = session;
        this.level = level;

    }

    public ClubMember toEntity(Club club, ClubTeam team) {

        return ClubMember.builder()
                .name(name)
                .session(session)
                .level(level)
                .club(club)
                .clubTeam(team)
                .build();

    }

}
