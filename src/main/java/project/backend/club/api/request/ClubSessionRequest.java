package project.backend.club.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubSessionServiceRequest;

@Getter
@NoArgsConstructor
public class ClubSessionRequest {

    @NotBlank(message = "세션은 필수입니다.")
    private List<String> sessions;
    @NotNull(message = "동아리는 필수입니다.")
    private Long clubId;

    @Builder
    public ClubSessionRequest(
            List<String> sessions,
            Long clubId) {

        this.sessions = sessions;
        this.clubId = clubId;
    }

    public ClubSessionServiceRequest toServiceRequest() {
        return ClubSessionServiceRequest.builder()
                .sessions(sessions)
                .clubId(clubId)
                .build();
    }

}
