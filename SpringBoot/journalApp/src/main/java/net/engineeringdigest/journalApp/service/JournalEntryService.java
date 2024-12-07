package net.engineeringdigest.journalApp.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntityRepo;

import java.util.List;
import java.util.Optional;

@Service // Indicates that this class is a service component
public class JournalEntryService {

    @Autowired // Field-based dependency injection
    private JournalEntityRepo journalEntityRepo;

    @Autowired
    private UserService userService;

    // Create or update a journal entry
    @Transactional
    public void saveJournalEntry(JournalEntry entry, String username) {
        User user = userService.getUser(username);
        JournalEntry savEntry = journalEntityRepo.save(entry);
        user.getJournalEntries().add(savEntry);
        userService.save(user);  
    }

    // Retrieve all journal entries
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntityRepo.findAll();
    }

  
}