package project.backend.club.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubMemberLevelServiceRequest;

@Getter
@NoArgsConstructor
public class ClubMemberLevelRequest {

    @NotBlank(message = "동아리 수준은 필수입니다.")
    private String level;
    @NotNull(message = "동아리는 필수입니다.")
    private Long clubId;

    @Builder
    public ClubMemberLevelRequest(
            String level,
            Long clubId
    ) {
        this.level = level;
        this.clubId = clubId;
    }

    public ClubMemberLevelServiceRequest toServiceRequest() {
        return ClubMemberLevelServiceRequest.builder()
                .level(level)
                .clubId(clubId)
                .build();
    }

}
