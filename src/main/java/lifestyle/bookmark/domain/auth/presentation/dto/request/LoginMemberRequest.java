package lifestyle.bookmark.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@RequiredArgsConstructor
public class LoginMemberRequest {

    @NotEmpty
    private final String loginId;

    @NotEmpty
    private final String password;
}
