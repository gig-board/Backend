package project.backend.club.applicaion.request;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.domain.Club;
import project.backend.club.domain.ClubMember;
import project.backend.club.domain.ClubTeam;

@Getter
@NoArgsConstructor
public class ClubTeamServiceRequest {

    private String name;
    private Long clubId;
    private Long clubMemberId;

    @Builder
    public ClubTeamServiceRequest(
            String name,
            Long clubId,
            @Nullable Long clubMemberId) {
        this.name = name;
        this.clubId = clubId;
        this.clubMemberId = clubMemberId;
    }

    public ClubTeam toEntity(Club club, ClubMember clubMember) {
        return ClubTeam.builder()
                .name(name)
                .club(club)
                .clubMember(clubMember)
                .build();
    }

}
