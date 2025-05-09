package com.example.task.model;

import com.mongodb.client.model.changestream.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "changesLogging")
public class ChangesLogging {
    private int userId;
    private OperationType operation;
    private String description;
    private User before;
    private User after;
    private Date time;
    private String entityName;
}
