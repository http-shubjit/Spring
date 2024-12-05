package net.engineeringdigest.journalApp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;







@Document(collection = "journalentry")
@Data
@NoArgsConstructor
public class JournalEntry {
    
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;



  


}
