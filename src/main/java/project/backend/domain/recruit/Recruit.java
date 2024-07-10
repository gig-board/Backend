package project.backend.domain.recruit;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;
import project.backend.domain.user.User;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recruit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_id")
    private Long id;

    @Column(name = "recruit_title")
    private String title;

    @Column(name = "recruit_content")
    private String content;

    @Column(name = "recruit_image")
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(name = "recruit_status")
    private RecruitStatus status;

    @Column(name = "recruit_region")
    private String region;

    @Column(name = "recruit_start_date")
    private LocalDate startDate;

    @Column(name = "recruit_end_date")
    private LocalDate endDate;

    @Column(name = "recruit_level")
    private String level;

    @Column(name = "recruit_notice")
    private String notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Recruit(String title,
                    String content,
                    String image,
                    RecruitStatus status,
                    String region,
                    LocalDate startDate,
                    LocalDate endDate,
                    String level,
                    String notice,
                    User user) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.status = status;
        this.region = region;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.notice = notice;
        this.user = user;
    }

    public static Recruit createRecruit(String title,
                                        String content,
                                        String image,
                                        RecruitStatus status,
                                        String region,
                                        LocalDate startDate,
                                        LocalDate endDate,
                                        String level,
                                        String notice,
                                        User user) {
        return Recruit.builder()
                .title(title)
                .content(content)
                .image(image)
                .status(status)
                .region(region)
                .startDate(startDate)
                .endDate(endDate)
                .level(level)
                .notice(notice)
                .user(user)
                .build();
    }


}
