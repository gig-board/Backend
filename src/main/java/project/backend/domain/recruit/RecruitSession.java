package project.backend.domain.recruit;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecruitSession extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_session_id")
    private Long id;

    @Column(name = "recruit_session_name")
    private String name;

    @Column(name = "recruit_session_status")
    private RecruitStatus status;

    @Column(name = "recruit_session_total")
    private int total;

    @Column(name = "recruit_session_completed")
    private int completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_id")
    private Recruit recruit;

    @Builder
    private RecruitSession(String name,
                           RecruitStatus status,
                           int total,
                           int completed,
                           Recruit recruit) {
        this.name = name;
        this.status = status;
        this.total = total;
        this.completed = completed;
        this.recruit = recruit;
    }

    public static RecruitSession createRecruitSession(String name,
                                                      RecruitStatus status,
                                                      int total,
                                                      int completed,
                                                      Recruit recruit) {
        return RecruitSession.builder()
                .name(name)
                .status(status)
                .total(total)
                .completed(completed)
                .recruit(recruit)
                .build();
    }

}
