package lifestyle.bookmark.domain.auth.presentation;

import lifestyle.bookmark.domain.auth.presentation.dto.request.LoginMemberRequest;
import lifestyle.bookmark.domain.auth.presentation.dto.request.SignUpMemberRequest;
import lifestyle.bookmark.domain.auth.presentation.dto.response.TokenResponse;
import lifestyle.bookmark.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping
    public ResponseEntity<TokenResponse> reissue(@RequestHeader("RefreshToken") String token) {
        TokenResponse reIssueToken = authService.reissue(token);
        return new ResponseEntity<>(reIssueToken, HttpStatus.OK);
    }
}
