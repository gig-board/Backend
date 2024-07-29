package project.backend.club.api.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubCreateTeamServiceRequest;

@Getter
@NoArgsConstructor
public class ClubCreateTeamRequest {

    @NotBlank(message = "팀 이름은 필수입니다.")
    private String name;
    @Nullable
    private Long clubMemberId;

    @Builder
    public ClubCreateTeamRequest(String name, @Nullable Long clubMemberId) {
        this.name = name;
        this.clubMemberId = clubMemberId;
    }

    public ClubCreateTeamServiceRequest toServiceRequest() {
        return ClubCreateTeamServiceRequest.builder()
                .name(name)
                .clubMemberId(clubMemberId)
                .build();
    }
}
