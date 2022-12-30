package lifestyle.bookmark.domain.auth.presentation.dto;

import lifestyle.bookmark.domain.auth.presentation.dto.request.SignUpMemberRequest;
import lifestyle.bookmark.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(SignUpMemberRequest signUpMemberRequest) {
        authService.signUp(signUpMemberRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
