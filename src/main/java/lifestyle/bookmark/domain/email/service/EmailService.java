package lifestyle.bookmark.domain.email.service;


import lifestyle.bookmark.domain.email.presentation.dto.SendEmailRequest;

public interface EmailService {
    void sendEmail(SendEmailRequest request);
}
