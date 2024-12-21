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


}
