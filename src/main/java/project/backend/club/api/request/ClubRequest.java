package project.backend.club.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.applicaion.request.ClubServiceRequest;

@Getter
@NoArgsConstructor
public class ClubRequest {

    @NotBlank(message = "동아리명은 필수입니다.")
    private String name;

    @NotNull(message = "작성자는 필수입니다.")
    private Long userId;

    @Builder
    public ClubRequest(
            String name,
            Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public ClubServiceRequest toServiceRequest() {
        return ClubServiceRequest.builder()
                .name(name)
                .userId(userId)
                .build();
    }

}
