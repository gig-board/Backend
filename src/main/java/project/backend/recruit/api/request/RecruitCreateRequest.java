package project.backend.recruit.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.recruit.application.request.RecruitCreateServiceRequest;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class RecruitCreateRequest {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    @NotBlank(message = "모집글 이미지은 필수입니다.")
    private String image;

    @NotBlank(message = "모집글 상태는 필수입니다.")
    private String status;

    @NotBlank(message = "모집글 상태는 필수입니다.")
    private String region;

    @NotNull(message = "모집글 시작 날짜는 필수입니다.")
    private LocalDate startDate;

    @NotNull(message = "모집글 시작 날짜는 필수입니다.")
    private LocalDate endDate;

    @NotBlank(message = "모집 수준은 필수입니다.")
    private String level;

    @NotBlank(message = "공지사항은 필수입니다.")
    private String notice;

    @NotNull(message = "작성자는 필수입니다.")
    private Long userId;

    @Builder
    public RecruitCreateRequest(
            String title,
            String content,
            String image,
            String status,
            String region,
            LocalDate startDate,
            LocalDate endDate,
            String level,
            String notice,
            Long userId) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.status = status;
        this.region = region;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.notice = notice;
        this.userId = userId;
    }

    public RecruitCreateServiceRequest toServiceRequest() {
        return RecruitCreateServiceRequest.builder()
                .title(title)
                .content(content)
                .image(image)
                .status(status)
                .region(region)
                .startDate(startDate)
                .endDate(endDate)
                .level(level)
                .notice(notice)
                .userId(userId)
                .build();
    }

}
