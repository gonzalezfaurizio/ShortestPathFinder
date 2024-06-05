// File: src/com/shortestpathfinder/model/HallOfFame.java
package com.shortestpathfinder.model;

import java.util.*;

/**
 * Class managing the Hall of Fame.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class HallOfFame {
    private static int currentId = 0;
    private final int id;
    private List<FameRecord> records;

    public HallOfFame() {
        this.id = ++currentId;
        this.records = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addRecord(FameRecord record) {
        this.records.add(record);
    }

    public List<FameRecord> getRecords() {
        return new ArrayList<>(records);
    }

    public void clearRecords() {
        this.records.clear();
    }

    @Override
    public String toString() {
        return "HallOfFame{" +
                "id=" + id +
                ", records=" + records +
                '}';
    }
}
