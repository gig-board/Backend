package project.backend.domain.place;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;
import project.backend.domain.user.User;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PracticeRoom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practice_room_id")
    private Long id;

    @Column(name = "practice_room_name")
    private String name;

    @Column(name = "practice_room_addr")
    private String addr;

    @Column(name = "practice_room_tel")
    private String tel;

    @Column(name = "practice_room_url")
    private String url;

    @Column(name = "practice_room_start_time")
    private LocalTime startTime;

    @Column(name = "practice_room_end_time")
    private LocalTime endTime;

    @Column(name = "practice_room_location_x")
    private Double locationX;

    @Column(name = "practice_room_location_y")
    private Double locationY;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private PracticeRoom(String name,
                         String addr,
                         String tel,
                         String url,
                         LocalTime startTime,
                         LocalTime endTime,
                         Double locationX,
                         Double locationY,
                         User user) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
        this.url = url;
        this.startTime = startTime;
        this.endTime = endTime;
        this.locationX = locationX;
        this.locationY = locationY;
        this.user = user;
    }

    public static PracticeRoom createPracticeRoom(String name,
                                                  String addr,
                                                  String tel,
                                                  String url,
                                                  LocalTime startTime,
                                                  LocalTime endTime,
                                                  Double locationX,
                                                  Double locationY,
                                                  User user) {
        return PracticeRoom.builder()
                .name(name)
                .addr(addr)
                .tel(tel)
                .url(url)
                .startTime(startTime)
                .endTime(endTime)
                .locationX(locationX)
                .locationY(locationY)
                .user(user)
                .build();
    }

}
