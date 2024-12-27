package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
  
    @Autowired
    private EmailService emailService;

    @Test
    void testEmailService() {
        
        emailService.sendSimpleMessage("shubhajit02.dev@gmail.com", "Test", "Hello  There i'm shubhajit");
    }
    
}
