package project.backend.club.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClubCreateSessionAndLevel {
    private ClubSessionRequest sessionRequest;
    private ClubMemberLevelRequest levelRequest;
}
