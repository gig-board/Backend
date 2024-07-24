package project.backend.club.api.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubTeamServiceRequest;

@Getter
@NoArgsConstructor
public class ClubTeamRequest {

    @NotBlank(message = "팀 이름은 필수입니다.")
    private String name;
    @NotNull(message = "소속 클럽은 필수입니다.")
    private Long clubId;
    @Nullable
    private Long clubMemberId;

    @Builder
    public ClubTeamRequest(String name, Long clubId, @Nullable Long clubMemberId) {
        this.name = name;
        this.clubId = clubId;
        this.clubMemberId = clubMemberId;
    }

    public ClubTeamServiceRequest toServiceRequest() {
        return ClubTeamServiceRequest.builder()
                .name(name)
                .clubId(clubId)
                .clubMemberId(clubMemberId)
                .build();
    }
}
