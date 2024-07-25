package project.backend.club.api.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubCreateMemberServiceRequest;

@Getter
@NoArgsConstructor
public class ClubCreateMemberRequest {

    @NotBlank(message = "부원 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "부원의 세션은 필수입니다.")
    private String session;

    @NotBlank(message = "부원 수준은 필수입니다.")
    private String level;

    @Nullable
    private Long clubTeamId;

    @Builder
    public ClubCreateMemberRequest(
            String name,
            String session,
            String level,
            @Nullable Long clubTeamId) {

        this.name = name;
        this.session = session;
        this.level = level;
        this.clubTeamId = clubTeamId;

    }

    public ClubCreateMemberServiceRequest toServiceRequest() {

        return ClubCreateMemberServiceRequest.builder()
                .name(name)
                .session(session)
                .level(level)
                .clubTeamId(clubTeamId)
                .build();

    }

}
