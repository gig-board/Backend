package project.backend.recruit.application.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.recruit.domain.Recruit;
import project.backend.recruit.domain.RecruitStatus;
import project.backend.user.domain.User;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class RecruitCreateServiceRequest {

    private String title;
    private String content;
    private String image;
    private String status;
    private String region;
    private LocalDate startDate;
    private LocalDate endDate;
    private String level;
    private String notice;

    @Builder
    public RecruitCreateServiceRequest(
            String title,
            String content,
            String image,
            String status,
            String region,
            LocalDate startDate,
            LocalDate endDate,
            String level,
            String notice) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.status = status;
        this.region = region;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.notice = notice;
    }

    public Recruit toEntity(User user) {
        return Recruit.builder()
                .title(title)
                .content(content)
                .image(image)
                .status(RecruitStatus.fromName(status))
                .region(region)
                .startDate(startDate)
                .endDate(endDate)
                .level(level)
                .notice(notice)
                .user(user)
                .build();
    }

}
