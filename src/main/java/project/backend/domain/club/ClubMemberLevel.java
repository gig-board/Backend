package project.backend.domain.club;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.domain.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubMemberLevel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_member_level_id")
    private Long id;

    @Column(name = "club_member_level_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @Builder
    private ClubMemberLevel(String name, Club club) {
        this.name = name;
        this.club = club;
    }

    public static ClubMemberLevel createClubMemberLevel(String name, Club club) {
        return ClubMemberLevel.builder()
                .name(name)
                .club(club)
                .build();
    }

}
