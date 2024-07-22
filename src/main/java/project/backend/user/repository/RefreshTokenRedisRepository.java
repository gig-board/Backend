package project.backend.user.repository;

import org.springframework.data.repository.CrudRepository;
import project.backend.user.infra.security.jwt.token.RefreshToken;

public interface RefreshTokenRedisRepository extends CrudRepository<RefreshToken, Long> {

    RefreshToken findByRefreshToken(String refreshToken);

}
