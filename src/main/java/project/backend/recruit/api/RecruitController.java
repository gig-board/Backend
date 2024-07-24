package project.backend.recruit.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.backend.global.auth.aop.AssignCurrentUserInfo;
import project.backend.global.auth.aop.CurrentUserInfo;
import project.backend.recruit.api.request.RecruitCreateRequest;
import project.backend.recruit.application.RecruitService;

@Slf4j
@RestController
@RequestMapping("/v1/recruits")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    @PostMapping
    @AssignCurrentUserInfo
    public ResponseEntity<String> createRecruit(
            CurrentUserInfo userInfo,
            @RequestBody @Valid RecruitCreateRequest request) {
        recruitService.createRecruit(request.toServiceRequest(), userInfo.getUserId());
        return ResponseEntity.ok("모집글 등록 성공");
    }

}
