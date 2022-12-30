package lifestyle.bookmark.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class SignUpMemberRequest {


    @NotBlank
    private final String loginId;

    @NotBlank
    private final String password;

    @NotBlank
    private final String name;

    @NotBlank
    private final String email;

}
