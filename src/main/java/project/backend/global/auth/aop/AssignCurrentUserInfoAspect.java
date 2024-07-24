package project.backend.global.auth.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import project.backend.user.infra.security.oauth.KakaoUserDetails;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

@Aspect
@Component
public class AssignCurrentUserInfoAspect {

    // @AssignCurrentUserInfo가 있는 메서드 실행 전에 현재 유저의 ID를 CurrentUserInfo 객체에 할당
    @Before("@annotation(project.backend.global.auth.aop.AssignCurrentUserInfo)")
    public void assignUserId(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs())
                .forEach(arg -> getMethod(arg.getClass())
                        .ifPresent(
                                setUserId -> invokeMethod(arg, setUserId, getCurrentUserId())));
    }

    // arg 객체의 setUserId 메서드를 호출하여 현재 유저의 ID를 할당
    private void invokeMethod(Object arg, Method method, Long currentUserId) {
        try {
            method.invoke(arg, currentUserId);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    // arg 객체의 setUserId 메서드를 찾아 반환
    private Optional<Method> getMethod(Class<?> clazz) {
        try {
            return Optional.of(clazz.getMethod("setUserId", Long.class));
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        }
    }

    // 현재 유저의 ID를 반환
    private Long getCurrentUserId() {
        return getCurrentUserIdCheck()
                .orElseThrow(RuntimeException::new);
    }

    private Optional<Long> getCurrentUserIdCheck() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof KakaoUserDetails) {
            KakaoUserDetails kakaoUserDetails = (KakaoUserDetails) authentication.getPrincipal();
            return Optional.ofNullable(kakaoUserDetails.getId());
        }

        // 인증된 정보가 null이거나 UserDetails가 아니라면 예외가 발생
        throw new RuntimeException(); // todo. 예외 처리 수정
    }

}
