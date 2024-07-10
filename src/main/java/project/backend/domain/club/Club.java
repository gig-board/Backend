package project.backend.domain.club;

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
public class Club extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "club_id")
    private Long id;

    @Column(name = "club_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Club(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public static Club createClub(String name, User user) {
        return Club.builder()
                .name(name)
                .user(user)
                .build();
    }

}
