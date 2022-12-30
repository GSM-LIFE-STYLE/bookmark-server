package lifestyle.bookmark.domain.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginMemberRequest {

    @NotEmpty
    private  String loginId;

    @NotEmpty
    private  String password;
}
