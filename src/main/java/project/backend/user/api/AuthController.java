package project.backend.user.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.backend.user.application.AuthService;
import project.backend.user.infra.security.jwt.token.TokenResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login/kakao")
    public ResponseEntity<TokenResponse> loginKakao(@RequestParam(name = "code") String code)
            throws JsonProcessingException {
        TokenResponse tokenResponse = authService.kakaoLogin(code);
        return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
    }

    @GetMapping("/reissue")
    public ResponseEntity<TokenResponse> reissueToken(HttpServletRequest request) {
        return new ResponseEntity<>(authService.reissueAccessToken(request), HttpStatus.OK);
    }

}
