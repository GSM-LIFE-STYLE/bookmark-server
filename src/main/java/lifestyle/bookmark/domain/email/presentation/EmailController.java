package lifestyle.bookmark.domain.email.presentation;

import lifestyle.bookmark.domain.email.presentation.dto.SendEmailRequest;
import lifestyle.bookmark.domain.email.service.EmailService;
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
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody SendEmailRequest request) {
        emailService.sendEmail(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
