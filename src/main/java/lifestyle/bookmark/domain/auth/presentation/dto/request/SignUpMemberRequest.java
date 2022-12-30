package lifestyle.bookmark.domain.auth.presentation.dto.request;

import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.global.role.Role;
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

    public Member toEntity() {
        return Member
                .builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .email(email)
                .role(Role.MEMBER)
                .build();
    }
}
