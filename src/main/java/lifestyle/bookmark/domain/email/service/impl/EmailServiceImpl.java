package lifestyle.bookmark.domain.email.service.impl;

import lifestyle.bookmark.domain.email.presentation.dto.SendEmailRequest;
import lifestyle.bookmark.domain.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {



    @Override
    public void sendEmail(SendEmailRequest request) {

    }
}
