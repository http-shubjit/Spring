package net.engineeringdigest.journalApp.controller;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    // Retrieve all journal entries
    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAllJournalEntries();
    }

    // Create a new journal entry
    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
        JournalEntry createdEntry = journalEntryService.saveJournalEntry(myEntry);
        return ResponseEntity.ok(createdEntry); // Return the created entry with HTTP 200 OK
    }

    // Update an existing journal entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry> updateEntry(@PathVariable ObjectId id, @RequestBody JournalEntry updatedEntry) {
        Optional<JournalEntry> existingEntry = journalEntryService.getJournalEntryById(id);

        if (existingEntry.isPresent()) {
            updatedEntry.setId(id); // Ensure the ID is set for the updated entry
            JournalEntry savedEntry = journalEntryService.saveJournalEntry(updatedEntry);
            return ResponseEntity.ok(savedEntry); // Return the updated entry with HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Return HTTP 404 Not Found if the entry does not exist
        }
    }

    // Delete a journal entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable ObjectId id) {
        Optional<JournalEntry> existingEntry = journalEntryService.getJournalEntryById(id);

        if (existingEntry.isPresent()) {
            journalEntryService.deleteJournalEntry(id);
            return ResponseEntity.noContent().build(); // Return HTTP 204 No Content after deletion
        } else {
            return ResponseEntity.notFound().build(); // Return HTTP 404 Not Found if the entry does not exist
        }
    }
}
