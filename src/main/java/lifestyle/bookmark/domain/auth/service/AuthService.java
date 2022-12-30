package lifestyle.bookmark.domain.auth.service;

import lifestyle.bookmark.domain.auth.presentation.dto.request.SignUpMemberRequest;

public interface AuthService {
    void signUp(SignUpMemberRequest request);
}
