package project.backend.club.applicaion;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.club.applicaion.request.ClubMemberServiceRequest;
import project.backend.club.applicaion.request.ClubServiceRequest;
import project.backend.club.applicaion.request.ClubSessionServiceRequest;
import project.backend.club.applicaion.request.ClubTeamServiceRequest;
import project.backend.club.domain.Club;
import project.backend.club.domain.ClubMember;
import project.backend.club.domain.ClubSession;
import project.backend.club.domain.ClubTeam;
import project.backend.club.repository.ClubMemberRepository;
import project.backend.club.repository.ClubRepository;
import project.backend.club.repository.ClubSessionRepository;
import project.backend.club.repository.ClubTeamRepository;
import project.backend.user.domain.User;
import project.backend.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubService {

    private final UserRepository userRepository;
    private final ClubRepository clubRepository;
    private final ClubMemberRepository clubMemberRepository;
    private final ClubTeamRepository clubTeamRepository;
    private final ClubSessionRepository clubSessionRepository;


    @Transactional
    public void createClub(ClubServiceRequest clubRequest, ClubSessionServiceRequest sessionRequest) {
        User user = userRepository.findById(clubRequest.getUserId())
                .orElseThrow(RuntimeException::new);

        Club club = clubRequest.toEntity(user);

        List<ClubSession> clubSessions = sessionRequest.toEntity(club);
        clubRepository.save(club);
        clubSessionRepository.saveAll(clubSessions);
    }

    @Transactional
    public void createClubMember(ClubMemberServiceRequest request, Long clubId) {

        Club club = clubRepository.findById(clubId)
                .orElseThrow(RuntimeException::new);

        clubMemberRepository.save(request.toEntity(club, null));
    }

    @Transactional
    public void editClubMember(ClubMemberServiceRequest request, Long clubId, Long memberId) {
        // clubId로 클럽을 찾고, 해당 클럽의 멤버인지 확인하는 과정 필요
        ClubMember clubMember = clubMemberRepository.findByIdAndClubId(memberId, clubId)
                .orElseThrow(() -> new EntityNotFoundException("Club member not found"));

        // 클럽 멤버 정보를 수정
        clubMember.editClubMember(request);
    }

    @Transactional
    public void deleteClubMember(Long clubId, Long memberId) {

        ClubMember clubMember = clubMemberRepository.findByIdAndClubId(memberId, clubId)
                .orElseThrow(() -> new EntityNotFoundException("Club member not found"));

        clubMemberRepository.delete(clubMember);
    }

    @Transactional
    public void changeClubMemberTeam(
            Long newTeamId,
            Long clubId,
            Long memberId,
            Long TeamId) {

        // 클럽 멤버 로드 및 존재 여부 확인
        ClubMember clubMember = clubMemberRepository.findByIdAndClubId(memberId, clubId)
                .orElseThrow(() -> new EntityNotFoundException("Club member not found"));

        if (Objects.equals(newTeamId, TeamId)) {
            throw new IllegalArgumentException("Same club team is not allowed.");
        }

        // 클럽 팀 로드 및 존재 여부 확인
        ClubTeam clubTeam = clubTeamRepository.findById(newTeamId)
                .orElseThrow(() -> new EntityNotFoundException("Old club team not found"));

        // 클럽 멤버의 팀을 변경
        clubMember.changeClubTeam(clubTeam);
    }


    @Transactional
    public void createClubTeam(ClubTeamServiceRequest request, Long clubId) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new EntityNotFoundException("Club is not found"));

        clubTeamRepository.save(request.toEntity(club, null));
    }

    @Transactional
    public void editClubTeamName(String newTeamName, Long clubId, Long teamId) {
        ClubTeam clubTeam = clubTeamRepository.findByIdAndClubId(teamId, clubId)
                .orElseThrow(() -> new EntityNotFoundException("Club team not found"));

        clubTeam.editClubTeamName(newTeamName);
    }

}
