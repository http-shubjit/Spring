package net.engineeringdigest.journalApp.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.engineeringdigest.journalApp.entity.JournalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/journal")
public class JournalEntryControler {

private Map<Long, JournalEntry> JournalEntries=new HashMap();


    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(JournalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myentry) {
        JournalEntries.put(myentry.getId(), myentry);
        return true;
      
    }
   
        
}
