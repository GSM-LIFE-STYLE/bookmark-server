package lifestyle.bookmark.domain.email.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "emailAuth" , timeToLive = 60 * 15)
public class EmailAuth {
}
