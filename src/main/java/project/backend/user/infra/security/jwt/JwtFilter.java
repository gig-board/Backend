package project.backend.user.infra.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import project.backend.user.infra.security.jwt.token.TokenProvider;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private static final String ACCESS_HEADER = "AccessToken";
    private final TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.info("URI = {}", request.getRequestURI());
        if (isRequestPassURI(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = getTokenFromHeader(request, ACCESS_HEADER);

        if (!tokenProvider.validateExpire(accessToken) && tokenProvider.validate(accessToken)) {
            String redirectUrl =
                    "https://" + request.getServerName() + "/api/exception/access-token-expired";
            response.sendRedirect(redirectUrl);
            return;
        }

        if (tokenProvider.validateExpire(accessToken) && tokenProvider.validate(accessToken)) {
            SecurityContextHolder.getContext().setAuthentication(tokenProvider.getAuthentication(accessToken));
        }

        filterChain.doFilter(request, response);
    }

    private static boolean isRequestPassURI(HttpServletRequest request) {
        if (request.getRequestURI().equals("/")) {
            return true;
        }

        if (request.getRequestURI().startsWith("/v1/auth")) {
            return true;
        }

        if (request.getRequestURI().startsWith("/v1/exception")) {
            return true;
        }

        return false;
    }

    private String getTokenFromHeader(HttpServletRequest request, String headerName) {
        String token = request.getHeader(headerName);
        if (StringUtils.hasText(token)) {
            return token;
        }
        return null;
    }

}
