package project.backend.club.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.backend.club.api.request.ClubMemberRequest;
import project.backend.club.api.request.ClubRequest;
import project.backend.club.api.request.ClubTeamRequest;
import project.backend.club.applicaion.ClubService;

@WebMvcTest(controllers = ClubController.class) // 특정 컨트롤러 지정
class ClubControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClubController clubController;

    @MockBean
    private ClubService clubService;

    @DisplayName("클럽을 생성한다.")
    @Test
    void createClub() throws Exception {

        ClubRequest request = ClubRequest.builder()
                .name("test")
                .userId(1L)
                .build();

        mockMvc.perform(
                        post("/v1/club")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("클럽 멤버를 생성한다.")
    @Test
    void createClubMember() throws Exception {
        ClubMemberRequest request = ClubMemberRequest.builder()
                .name("test member")
                .level("middle")
                .session("drum")
                .clubId(1L)
                .clubTeamId(1L)
                .build();

        mockMvc.perform(
                        post("/v1/club/1/member")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("동아리 부원 정보 수정한다.")
    @Test
    void editClubMember() throws Exception {
        ClubMemberRequest request = ClubMemberRequest.builder()
                .name("edit member")
                .level("high")
                .session("piano")
                .build();

        mockMvc.perform(
                        patch("/v1/club/1/member/1")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("동아리 부원 정보 삭제한다.")
    @Test
    void deleteClubMember() throws Exception {

        mockMvc.perform(
                        delete("/v1/club/1/member/1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("동아리 부원 팀 변경한다.")
    @Test
    void changeClubMemberTeam() throws Exception {

        mockMvc.perform(
                        patch("/v1/club/1/member/1/1?newTeamId=2")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("동아리 팀 생성한다.")
    @Test
    void createClubTeam() throws Exception {
        ClubTeamRequest request = ClubTeamRequest.builder()
                .name("test")
                .clubId(1L)
                .build();
        mockMvc.perform(
                        post("/v1/club/1/team")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("동아리 팀명 변경한다.")
    @Test
    void editClubTeamName() throws Exception {

        mockMvc.perform(
                        patch("/v1/club/1/team/1?newTeamName=newTeam")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

}