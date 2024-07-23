package project.backend.club.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ClubError {
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다.");
    //그 외 등등의 에러 코드들


    private final int code;
    private final String message;

    ClubError(HttpStatus code, String message) {
        this.code = code.value();
        this.message = message;
    }

}
