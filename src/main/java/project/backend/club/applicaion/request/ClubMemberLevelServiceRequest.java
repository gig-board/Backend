package project.backend.club.applicaion.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.domain.Club;
import project.backend.club.domain.ClubMemberLevel;

@Getter
@NoArgsConstructor
public class ClubMemberLevelServiceRequest {

    private String level;
    private Long clubId;

    @Builder
    public ClubMemberLevelServiceRequest(String level, Long clubId) {
        this.level = level;
        this.clubId = clubId;
    }

    public ClubMemberLevel toEntity(Club club) {
        return ClubMemberLevel.builder()
                .level(level)
                .club(club)
                .build();
    }

}
