package net.engineeringdigest.journalApp.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.engineeringdigest.journalApp.entity.JournalEntry;

@Repository
public interface JournalEntityRepo extends MongoRepository<JournalEntry,ObjectId> {


    
} 