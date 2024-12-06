package net.engineeringdigest.journalApp.controller;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAllJournalEntries();

    }
    @GetMapping("{username}")
    public List<JournalEntry> getAllJournalEntriesOfUser(@PathVariable String username) {
        User user = userService.getUser(username);
        return user.getJournalEntries();

    }

   
    @PostMapping("{username}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String username) {
        try {
            journalEntryService.saveJournalEntry(myEntry, username);
            return new ResponseEntity<>(HttpStatus.CREATED); // 201 Created
        }  catch (Exception e) {
            // Handle any other exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
        }
    }

    // // Update an existing journal entry by ID
    // @PutMapping("/{id}")
    // public ResponseEntity<JournalEntry> updateEntry(@PathVariable ObjectId id, @RequestBody JournalEntry updatedEntry) {
    //     Optional<JournalEntry> existingEntry = journalEntryService.getJournalEntryById(id);

    //     if (existingEntry.isPresent()) {
    //         updatedEntry.setId(id); // Ensure the ID is set for the updated entry
    //         JournalEntry savedEntry = journalEntryService.saveJournalEntry(updatedEntry);
    //         return ResponseEntity.ok(savedEntry); // Return the updated entry with HTTP 200 OK
    //     } else {
    //         return ResponseEntity.notFound().build(); // Return HTTP 404 Not Found if the entry does not exist
    //     }
    // }

    // // Delete a journal entry by ID
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteEntry(@PathVariable ObjectId id) {
    //     Optional<JournalEntry> existingEntry = journalEntryService.getJournalEntryById(id);

    //     if (existingEntry.isPresent()) {
    //         journalEntryService.deleteJournalEntry(id);
    //         return ResponseEntity.noContent().build(); // Return HTTP 204 No Content after deletion
    //     } else {
    //         return ResponseEntity.notFound().build(); // Return HTTP 404 Not Found if the entry does not exist
    //     }
    // }
}
