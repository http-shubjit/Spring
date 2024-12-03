package net.engineeringdigest.journalApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntry {
    
    @Id
    private String id;
    private String title;
    private String content;

  


}
