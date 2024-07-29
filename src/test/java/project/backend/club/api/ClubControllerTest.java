/*
package project.backend.club.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.backend.club.api.request.ClubCreateMemberRequest;
import project.backend.club.api.request.ClubCreateRequest;
import project.backend.club.api.request.ClubCreateTeamRequest;
import project.backend.club.api.request.ClubEditMemberRequest;
import project.backend.user.infra.security.jwt.token.TokenProvider;
import project.backend.user.infra.security.jwt.token.TokenResponse;

//@WebMvcTest(controllers = ClubController.class) // 특정 컨트롤러 지정
@SpringBootTest
@AutoConfigureMockMvc
class ClubControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TokenProvider tokenProvider;

    @Value("${jwt.access_header}")
    private String name;
    private String validToken;

    @BeforeEach
    void setUp() {
        TokenResponse tokenResponse = tokenProvider.createToken("1", "test@gmail.com", "USER");
        validToken = "Bearer " + tokenResponse.getAccessToken();
    }

    @DisplayName("클럽을 생성한다.")
    @Test
    void createClub() throws Exception {

        ClubCreateRequest request = ClubCreateRequest.builder()
                .clubName("ssu band")
                .sessions(Arrays.asList("session1", "session2"))
                .levels(Arrays.asList("level1", "level2"))
                .userId(1L)
                .build();

        mockMvc.perform(
                        post("/v1/club")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                                .header(name, validToken))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @DisplayName("클럽 멤버를 생성한다.")
    @Test
    void createClubMember() throws Exception {

        ClubCreateMemberRequest request = ClubCreateMemberRequest.builder()
                .name("test member")
                .level("middle")
                .session("drum")
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

        ClubEditMemberRequest request = ClubEditMemberRequest.builder()
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

        ClubCreateTeamRequest request = ClubCreateTeamRequest.builder()
                .name("test")
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

}*/
