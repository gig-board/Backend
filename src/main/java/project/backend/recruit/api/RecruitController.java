package project.backend.recruit.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.backend.recruit.api.request.RecruitCreateRequest;
import project.backend.recruit.application.RecruitService;

@RestController
@RequestMapping("/v1/recruits")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    @PostMapping
    public ResponseEntity<String> createRecruit(@RequestBody @Valid RecruitCreateRequest request) {
        recruitService.createRecruit(request.toServiceRequest());
        return ResponseEntity.ok("모집글 등록 성공");
    }

}
