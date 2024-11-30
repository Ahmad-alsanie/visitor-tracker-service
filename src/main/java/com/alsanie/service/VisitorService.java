package com.alsanie.service;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    private final DynamoDB dynamoDB;
    private final String tableName = "VisitorCount";

    public VisitorService(DynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    public void incrementVisitorCount() {
        Table table = dynamoDB.getTable(tableName);
        try {
            Item item = table.getItem("Page", "HomePage");
            if (item == null) {
                item = new Item().withPrimaryKey("Page", "HomePage").withNumber("Count", 1);
            } else {
                int currentCount = item.getInt("Count");
                item.withNumber("Count", currentCount + 1);
            }
            table.putItem(item);
        } catch (Exception e) {
            System.err.println("Unable to update visitor count: " + e.getMessage());
        }
    }

    public int getVisitorCount() {
        Table table = dynamoDB.getTable(tableName);
        try {
            Item item = table.getItem("Page", "HomePage");
            return item == null ? 0 : item.getInt("Count");
        } catch (Exception e) {
            System.err.println("Unable to retrieve visitor count: " + e.getMessage());
            return 0;
        }
    }
}
