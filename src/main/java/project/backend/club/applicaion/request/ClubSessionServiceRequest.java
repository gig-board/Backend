package project.backend.club.applicaion.request;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.backend.club.domain.Club;
import project.backend.club.domain.ClubSession;

@Getter
@RequiredArgsConstructor
public class ClubSessionServiceRequest {

    private List<String> sessions;
    private Long clubId;

    @Builder
    public ClubSessionServiceRequest(List<String> sessions, Long clubId) {
        this.sessions = sessions;
        this.clubId = clubId;
    }

    public List<ClubSession> toEntity(Club club) {
        return sessions.stream()
                .map(session -> ClubSession.builder()
                        .session(session)
                        .club(club)
                        .build())
                .collect(Collectors.toList());
    }

}
