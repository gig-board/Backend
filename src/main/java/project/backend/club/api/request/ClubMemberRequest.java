package project.backend.club.api.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubMemberServiceRequest;

@Getter
@NoArgsConstructor
public class ClubMemberRequest {

    @NotBlank(message = "부원 이름은 필수입니다.")
    private String name;
    @NotBlank(message = "부원 수준은 필수입니다.")
    private String level;
    @NotBlank(message = "부원의 세션은 필수입니다.")
    private String session;
    @NotNull(message = "부원의 동아리는 필수입니다.")
    private Long clubId;
    @Nullable
    private Long clubTeamId;

    @Builder
    public ClubMemberRequest(
            String name,
            String level,
            String session,
            Long clubId,
            @Nullable Long clubTeamId) {

        this.name = name;
        this.level = level;
        this.session = session;
        this.clubId = clubId;
        this.clubTeamId = clubTeamId;
    }

    public ClubMemberServiceRequest toServiceRequest() {
        return ClubMemberServiceRequest.builder()
                .name(name)
                .level(level)
                .session(session)
                .clubId(clubId)
                .build();
    }


}
