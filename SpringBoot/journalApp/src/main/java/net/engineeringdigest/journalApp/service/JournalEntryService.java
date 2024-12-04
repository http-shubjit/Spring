package net.engineeringdigest.journalApp.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntityRepo;

import java.util.List;
import java.util.Optional;

@Service // Indicates that this class is a service component
public class JournalEntryService {

    @Autowired // Field-based dependency injection
    private JournalEntityRepo journalEntityRepo;

    // Create or update a journal entry
    public JournalEntry saveJournalEntry(JournalEntry entry) {
        return journalEntityRepo.save(entry);
    }

    // Retrieve all journal entries
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntityRepo.findAll();
    }

    // Retrieve a journal entry by ID
    public Optional<JournalEntry> getJournalEntryById(ObjectId id) {
        return journalEntityRepo.findById(id);
    }

    // Delete a journal entry by ID
    public void deleteJournalEntry(ObjectId id) {
        journalEntityRepo.deleteById(id);
    }
}