package project.backend.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.BaseEntity;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_age")
    private int age;

    @Column(name = "user_session")
    private String session;

    @Column(name = "user_session_level")
    @Enumerated(EnumType.STRING)
    private UserLevel level;

    @Column(name = "user_profile_image")
    private String profileImage;

    @Builder
    private User(String name,
                 String email,
                 int age,
                 String session,
                 UserLevel level,
                 String profileImage) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.session = session;
        this.level = level;
        this.profileImage = profileImage;
    }

    public static User createUser(String email, String name) {
        return User.builder()
                .email(email)
                .name(name)
                .build();
    }

}
