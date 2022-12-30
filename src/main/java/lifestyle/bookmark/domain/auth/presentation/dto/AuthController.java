package lifestyle.bookmark.domain.auth.presentation.dto;

import lifestyle.bookmark.domain.auth.presentation.dto.request.LoginMemberRequest;
import lifestyle.bookmark.domain.auth.presentation.dto.request.SignUpMemberRequest;
import lifestyle.bookmark.domain.auth.presentation.dto.response.TokenResponse;
import lifestyle.bookmark.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpMemberRequest request) {
        authService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginMemberRequest request) {
        TokenResponse response = authService.login(request);
        return ResponseEntity.ok().body(response);
    }
}
