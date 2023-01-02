package lifestyle.bookmark.domain.auth.domain.repository;

import lifestyle.bookmark.domain.auth.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken , String> {
}
