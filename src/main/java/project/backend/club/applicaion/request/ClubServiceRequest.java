package project.backend.club.applicaion.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.domain.Club;
import project.backend.user.domain.User;

@Getter
@NoArgsConstructor
public class ClubServiceRequest {

    private String name;
    private Long userId;

    @Builder
    public ClubServiceRequest(
            String name,
            Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public Club toEntity(User user) {
        return Club.builder()
                .name(name)
                .user(user)
                .build();
    }

}
