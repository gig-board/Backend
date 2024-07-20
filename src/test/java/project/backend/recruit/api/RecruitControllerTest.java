package project.backend.recruit.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import project.backend.recruit.api.request.RecruitCreateRequest;
import project.backend.recruit.application.RecruitService;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RecruitController.class)
class RecruitControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RecruitController recruitController;

    @MockBean
    private RecruitService recruitService;

    @DisplayName("모집글을 생성한다.")
    @Test
    void createRecruit() throws Exception {
        //given
        RecruitCreateRequest request = RecruitCreateRequest.builder()
                .title("제목")
                .content("내용")
                .image("이미지")
                .status("excepted")
                .region("서울")
                .startDate(LocalDate.of(2024, 1, 1))
                .endDate(LocalDate.of(2024, 1, 2))
                .level("수준")
                .notice("공지")
                .userId(1L)
                .build();

        //when //then
        mockMvc.perform(
                        post("/v1/recruits")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

}