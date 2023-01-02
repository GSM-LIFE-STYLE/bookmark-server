package lifestyle.bookmark.domain.auth.service;

import lifestyle.bookmark.domain.auth.presentation.dto.request.LoginMemberRequest;
import lifestyle.bookmark.domain.auth.presentation.dto.request.SignUpMemberRequest;
import lifestyle.bookmark.domain.auth.presentation.dto.response.TokenResponse;

public interface AuthService {
    void signUp(SignUpMemberRequest request);
    TokenResponse login(LoginMemberRequest request);
    TokenResponse reissue(String requestToken);

}
