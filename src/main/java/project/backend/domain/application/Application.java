package project.backend.domain.application;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;
import project.backend.domain.recruit.RecruitSession;
import project.backend.domain.user.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Application extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    @Column(name = "application_content")
    private String content;

    @Column(name = "application_career")
    private String career;

    @Column(name = "application_session")
    private String session;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status")
    private ApplicationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_session_id")
    private RecruitSession recruitSession;

    @Builder
    private Application(String content,
                        String career,
                        String session,
                        ApplicationStatus status,
                        User user,
                        RecruitSession recruitSession) {
        this.content = content;
        this.career = career;
        this.session = session;
        this.status = status;
        this.user = user;
        this.recruitSession = recruitSession;
    }

    public static Application createApplication(String content,
                                                String career,
                                                String session,
                                                ApplicationStatus status,
                                                User user,
                                                RecruitSession recruitSession) {
        return Application.builder()
                .content(content)
                .career(career)
                .session(session)
                .status(status)
                .user(user)
                .recruitSession(recruitSession)
                .build();
    }

}
