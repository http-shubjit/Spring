package net.engineeringdigest.journalApp.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import net.engineeringdigest.journalApp.entity.User;

public class UserRepositoryImpl {
 
@Autowired
private MongoTemplate mongoTemplate;


public List<User> getUserForSA() {
    Query query = new Query();
    query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", "i"));

    query.addCriteria(Criteria.where("sentimentalAnalysis").is(true));
    System.out.println(query);
    List<User> user = mongoTemplate.find(query, User.class);
    return user;
}

}