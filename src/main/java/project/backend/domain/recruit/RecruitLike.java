package project.backend.domain.recruit;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;
import project.backend.domain.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecruitLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_id")
    private Recruit recruit;

    @Builder
    private RecruitLike(User user, Recruit recruit) {
        this.user = user;
        this.recruit = recruit;
    }

    public static RecruitLike createRecruitLike(User user, Recruit recruit) {
        return RecruitLike.builder()
                .user(user)
                .recruit(recruit)
                .build();
    }

}
