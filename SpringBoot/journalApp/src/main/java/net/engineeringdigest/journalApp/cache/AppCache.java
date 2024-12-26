package net.engineeringdigest.journalApp.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journalApp.entity.ConfigJournalAppEntity;
import net.engineeringdigest.journalApp.repository.ConfigJournalAppRepository;

@Component
public class AppCache {
   
  @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> API_CACHE;


     @PostConstruct
    public void init(){
        API_CACHE = new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        for (ConfigJournalAppEntity configJournalAppEntity : all) {
            API_CACHE.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
    }
    
}
