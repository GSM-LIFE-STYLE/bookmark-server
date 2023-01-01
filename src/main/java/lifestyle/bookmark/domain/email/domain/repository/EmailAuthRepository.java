package lifestyle.bookmark.domain.email.domain.repository;

import lifestyle.bookmark.domain.email.domain.EmailAuth;
import org.springframework.data.repository.CrudRepository;

public interface EmailAuthRepository extends CrudRepository<EmailAuth, String> {
}
