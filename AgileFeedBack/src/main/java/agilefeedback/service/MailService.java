package agilefeedback.service;

public interface MailService {
    void sendEmail(String to, String subject, String body);
    void sendHtml(String to, String subject, String htmlBody);
}
