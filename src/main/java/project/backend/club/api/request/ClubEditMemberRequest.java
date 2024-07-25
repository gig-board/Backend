package project.backend.club.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubEditMemberServiceRequest;

@Getter
@NoArgsConstructor
public class ClubEditMemberRequest {

    @NotBlank(message = "동아리 부원의 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "동아리 부원의 세션은 필수입니다.")
    private String session;

    @NotBlank(message = "동아리 부원의 수준은 필수입니다.")
    private String level;

    @Builder
    public ClubEditMemberRequest(
            String name,
            String session,
            String level) {

        this.name = name;
        this.session = session;
        this.level = level;

    }

    public ClubEditMemberServiceRequest toServiceRequest() {

        return ClubEditMemberServiceRequest.builder()
                .name(name)
                .session(session)
                .level(level)
                .build();

    }

}
