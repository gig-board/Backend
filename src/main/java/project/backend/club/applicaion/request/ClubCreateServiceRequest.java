package project.backend.club.applicaion.request;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.club.domain.Club;
import project.backend.club.domain.ClubMemberLevel;
import project.backend.club.domain.ClubSession;
import project.backend.user.domain.User;

@Getter
@NoArgsConstructor
public class ClubCreateServiceRequest {

    private String clubName;
    private List<String> sessions;
    private List<String> levels;
    private Long userId;

    @Builder
    public ClubCreateServiceRequest(
            String clubName,
            List<String> sessions,
            List<String> levels,
            Long userId) {

        this.clubName = clubName;
        this.sessions = sessions;
        this.levels = levels;
        this.userId = userId;

    }

    public Club toClubEntity(User user) {

        return Club.builder()
                .name(clubName)
                .user(user)
                .build();

    }

    public ClubSession toSessionEntity(Club club, String session) {

        return ClubSession.builder()
                .session(session)
                .club(club)
                .build();

    }

    public ClubMemberLevel toLevelEntity(Club club, String level) {

        return ClubMemberLevel.builder()
                .level(level)
                .club(club)
                .build();

    }

}
