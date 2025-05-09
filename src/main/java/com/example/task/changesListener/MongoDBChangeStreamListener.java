//package com.example.task.changesListener;
//
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.model.changestream.ChangeStreamDocument;
//import com.mongodb.client.model.changestream.OperationType;
//import lombok.extern.slf4j.Slf4j;
//import org.bson.Document;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MongoDBChangeStreamListener {
//    private static final Logger log = LoggerFactory.getLogger(MongoDBChangeStreamListener.class);
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//    public void watchChanges() {
//        MongoCollection<Document> collection = mongoTemplate.getCollection("TheUsers");
//
//        collection.watch().forEach((ChangeStreamDocument<Document> change) -> {
//            System.out.println("Change detected: " + change);
//            if (change.getOperationType() == OperationType.INSERT) {
//                System.out.println("Document inserted: " + change.getFullDocument());
//            } else if (change.getOperationType() == OperationType.UPDATE) {
//                System.out.println("Document updated: " + change.getUpdateDescription());
//            } else if (change.getOperationType() == OperationType.DELETE) {
//                System.out.println("Document deleted: " + change.getDocumentKey());
//            }
//        });
//
//
//    }
//}