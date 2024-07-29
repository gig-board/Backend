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
public class ClubCreateTeamServiceRequest {

    private String name;
    private Long clubMemberId;

    @Builder
    public ClubCreateTeamServiceRequest(
            String name,
            @Nullable Long clubMemberId) {

        this.name = name;
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
