package project.backend.club.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.backend.club.api.request.ClubCreateMemberRequest;
import project.backend.club.api.request.ClubCreateRequest;
import project.backend.club.api.request.ClubCreateTeamRequest;
import project.backend.club.api.request.ClubEditMemberRequest;
import project.backend.club.applicaion.ClubService;

@RestController
@RequestMapping("/v1/club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @PostMapping
    public ResponseEntity<String> createClub(
            @RequestBody @Valid ClubCreateRequest request) {

        clubService.createClub(request.toServiceRequest());

        return ResponseEntity.ok("동아리 등록 성공");

    }

    @PostMapping("/{clubId}/member")
    public ResponseEntity<String> createClubMember(
            @RequestBody @Valid ClubCreateMemberRequest request,
            @PathVariable("clubId") Long clubId) {

        clubService.createClubMember(request.toServiceRequest(), clubId);

        return ResponseEntity.ok("동아리 부원 등록 성공");

    }

    @PatchMapping("/{clubId}/member/{memberId}")
    public ResponseEntity<String> editClubMember(
            @RequestBody @Valid ClubEditMemberRequest request,
            @PathVariable("clubId") Long clubId,
            @PathVariable("memberId") Long memberId) {

        clubService.editClubMember(request.toServiceRequest(), clubId, memberId);
        return ResponseEntity.ok("동아리 부원 정보 수정 성공");

    }

    @DeleteMapping("/{clubId}/member/{memberId}")
    public ResponseEntity<String> deleteClubMember(
            @PathVariable("clubId") Long clubId,
            @PathVariable("memberId") Long memberId) {

        //여기는 request 필요 없을지도
        clubService.deleteClubMember(clubId, memberId);

        return ResponseEntity.ok("동아리 부원 삭제 완료");

    }

    @PatchMapping("/{clubId}/member/{memberId}/{teamId}")
    public ResponseEntity<String> changeClubMemberTeam(
            @RequestParam("newTeamId") Long newTeamId,
            @PathVariable("clubId") Long clubId,
            @PathVariable("memberId") Long memberId,
            @PathVariable("teamId") Long teamId) {

        clubService.changeClubMemberTeam(newTeamId, clubId, memberId, teamId);
        return ResponseEntity.ok("동아리 부원 팀 변경 성공");

    }

    @PostMapping("/{clubId}/team")
    public ResponseEntity<String> createClubTeam(
            @RequestBody @Valid ClubCreateTeamRequest request,
            @PathVariable("clubId") Long clubId) {

        clubService.createClubTeam(request.toServiceRequest(), clubId);
        return ResponseEntity.ok("동아리 팀 생성 성공");

    }

    @PatchMapping("/{clubId}/team/{teamId}")
    public ResponseEntity<String> editClubTeamName(
            @RequestParam("newTeamName") String newTeamName,
            @PathVariable("clubId") Long clubId,
            @PathVariable("teamId") Long teamId) {

        clubService.editClubTeamName(newTeamName, clubId, teamId);
        return ResponseEntity.ok("팀명 변경 성공");

    }

}
