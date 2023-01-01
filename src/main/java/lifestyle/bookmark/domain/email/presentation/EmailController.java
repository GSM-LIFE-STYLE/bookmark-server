package lifestyle.bookmark.domain.email.presentation;

import lifestyle.bookmark.domain.email.presentation.dto.SendEmailRequest;
import lifestyle.bookmark.domain.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody SendEmailRequest request) {
        emailService.sendEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Void> checkEmail(@Email @RequestParam String email, @RequestParam String authKey) {
        emailService.checkEmail(email, authKey);
        return ResponseEntity.ok().build();
    }
}
