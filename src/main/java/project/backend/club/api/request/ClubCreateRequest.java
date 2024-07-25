package project.backend.club.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubCreateServiceRequest;

@Getter
@NoArgsConstructor
public class ClubCreateRequest {

    @NotBlank(message = "동아리명은 필수입니다.")
    private String clubName;

    @NotBlank(message = "동아리 세션은 필수입니다.")
    private List<String> sessions;

    @NotBlank(message = "동아리 level은 필수입니다.")
    private List<String> levels;

    @NotNull(message = "작성자는 필수입니다.")
    private Long userId;

    @Builder
    public ClubCreateRequest(
            String clubName,
            List<String> sessions,
            List<String> levels,
            Long userId) {

        this.clubName = clubName;
        this.sessions = sessions;
        this.levels = levels;
        this.userId = userId;

    }

    public ClubCreateServiceRequest toServiceRequest() {

        return ClubCreateServiceRequest.builder()
                .clubName(clubName)
                .sessions(sessions)
                .levels(levels)
                .userId(userId)
                .build();

    }

}
