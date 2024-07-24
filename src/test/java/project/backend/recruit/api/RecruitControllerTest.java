package project.backend.recruit.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.backend.recruit.api.request.RecruitCreateRequest;
import project.backend.user.infra.security.jwt.token.TokenProvider;
import project.backend.user.infra.security.jwt.token.TokenResponse;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RecruitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

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

    @DisplayName("모집글을 생성한다.")
    @Test
    void createRecruit() throws Exception {
        // given
        RecruitCreateRequest request = RecruitCreateRequest.builder()
                .title("제목")
                .content("내용")
                .image("이미지")
                .status("expected")
                .region("서울")
                .startDate(LocalDate.of(2024, 1, 1))
                .endDate(LocalDate.of(2024, 1, 2))
                .level("수준")
                .notice("공지")
                .build();

        // when // then
        mockMvc.perform(post("/v1/recruits")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(name, validToken))
                .andExpect(status().isOk())
                .andDo(print());
    }

}