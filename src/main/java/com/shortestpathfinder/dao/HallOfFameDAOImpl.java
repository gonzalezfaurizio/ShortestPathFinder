// File: src/com/shortestpathfinder/dao/HallOfFameDAOImpl.java
package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.*;
import java.util.*;

/**
 * Interface for Hall of Fame data access operations.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @authors: - GONZALEZ ALFARO FAURIZIO - RODRIGUEZ GUTIERREZ REBECA - RODRIGUEZ
 * RODRIGUEZ ANDREY ELADIO
 */
public class HallOfFameDAOImpl implements HallOfFameDAO {

    private List<FameRecord> fameRecords;

    public HallOfFameDAOImpl() {
        this.fameRecords = new ArrayList<>();
    }

    @Override
    public List<FameRecord> getAllFameRecords() {
        return new ArrayList<>(fameRecords);
    }

    @Override
    public FameRecord getFameRecordById(String id) {
        Optional<FameRecord> fameRecord = fameRecords.stream()
                .filter(fr -> String.valueOf(fr.getId()).equals(id))
                .findFirst();
        return fameRecord.orElse(null);
    }

    @Override
    public void addFameRecord(FameRecord fameRecord) {
        fameRecords.add(fameRecord);
        sortFameRecordsBySteps();
    }

    @Override
    public void updateFameRecord(FameRecord fameRecord) {
        fameRecords.replaceAll(fr -> String.valueOf(fr.getId()).equals(String.valueOf(fameRecord.getId())) ? fameRecord : fr);
        sortFameRecordsBySteps();
    }

    @Override
    public void deleteFameRecord(String id) {
        fameRecords.removeIf(fr -> String.valueOf(fr.getId()).equals(id));
    }

    private void sortFameRecordsBySteps() {
        fameRecords.sort(Comparator.comparingInt(FameRecord::getSteps));
    }
}
