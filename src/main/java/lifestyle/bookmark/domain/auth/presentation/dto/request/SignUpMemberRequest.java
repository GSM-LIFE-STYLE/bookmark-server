package lifestyle.bookmark.domain.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpMemberRequest {


    @NotBlank
    private  String loginId;

    @NotBlank
    @Pattern(regexp="(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 특수문자 1개 이상 글자 수는 8 ~ 16자 사이여야 합니다.")
    private  String password;

    @NotBlank
    private  String name;

    @NotBlank
    private  String email;

}
