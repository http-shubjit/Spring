package net.engineeringdigest.journalApp.scheduler;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.enums.Sentiment;
import net.engineeringdigest.journalApp.repository.UserRepositoryImpl;
import net.engineeringdigest.journalApp.service.EmailService;


@Component
public class UserScheduler {
  
    
    @Autowired 
    private EmailService emailService;
    @Autowired
    private UserRepositoryImpl userRepositoryImpl;
  

    @Autowired
    private AppCache appCache;

    // @Scheduled(cron = "* * * ? * *")
    public void fetchUserForSA() {
        List<User> users = userRepositoryImpl.getUserForSA();
        for (User user : users) {
            List<Sentiment>  sentiments= user.getJournalEntries().stream()
                    .filter(entry -> entry.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS)))
                    .map(x -> x.getSentiment())
                    .collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap();
            for (Sentiment sentiment : sentiments) {
                if(sentiment != null)
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
            }
            Sentiment mostFrequencySentiment = null;
            int maxCount = 0;

            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
                if (entry.getValue() > maxCount)
                    maxCount = entry.getValue();
                mostFrequencySentiment = entry.getKey();
            }
            if (mostFrequencySentiment != null) {
                emailService.sendSimpleMessage(user.getEmail(), "Sentiment For 7 Days", mostFrequencySentiment.toString());            }
            
        }
    }
    
    // @Scheduled(cron = "* * * ? * *")
    public void appCache() {
        appCache.init();
    }
}
