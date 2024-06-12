package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.*;
import java.util.*;

/**
 * Interface for Hall of Fame data access operations.
 *
 * @version 1.0
 * @since 2024-05-21
 *
 * @author GONZALEZ ALFARO FAURIZIO
 * @author RODRIGUEZ GUTIERREZ REBECA
 * @author RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public class HallOfFameDAOImpl implements HallOfFameDAO {

    /**
     * A list of FameRecord objects managed by this DAO implementation.
     */
    private List<FameRecord> fameRecords;

    /**
     * Constructs a new HallOfFameDAOImpl with an empty list of fame records.
     */
    public HallOfFameDAOImpl() {
        this.fameRecords = new ArrayList<>();
    }

    /**
     * Retrieves a list of all fame records.
     *
     * @return a list of all FameRecord objects.
     */
    @Override
    public List<FameRecord> getAllFameRecords() {
        return new ArrayList<>(fameRecords);
    }

    /**
     * Retrieves a fame record by its unique ID.
     *
     * @param id the unique ID of the fame record.
     * @return the FameRecord object with the specified ID, or null if no such
     * record exists.
     */
    @Override
    public FameRecord getFameRecordById(String id) {
        Optional<FameRecord> fameRecord = fameRecords.stream()
                .filter(fr -> String.valueOf(fr.getId()).equals(id))
                .findFirst();
        return fameRecord.orElse(null);
    }

    /**
     * Adds a new fame record.
     *
     * @param fameRecord the FameRecord object to be added.
     */
    @Override
    public void addFameRecord(FameRecord fameRecord) {
        fameRecords.add(fameRecord);
        sortFameRecordsBySteps();
    }

    /**
     * Updates an existing fame record.
     *
     * @param fameRecord the FameRecord object with updated information.
     */
    @Override
    public void updateFameRecord(FameRecord fameRecord) {
        fameRecords.replaceAll(fr -> String.valueOf(fr.getId()).equals(String.valueOf(fameRecord.getId())) ? fameRecord : fr);
        sortFameRecordsBySteps();
    }

    /**
     * Deletes a fame record by its unique ID.
     *
     * @param id the unique ID of the fame record to be deleted.
     */
    @Override
    public void deleteFameRecord(String id) {
        fameRecords.removeIf(fr -> String.valueOf(fr.getId()).equals(id));
    }

    /**
     * Sorts the list of fame records by the number of steps taken in ascending
     * order.
     */
    private void sortFameRecordsBySteps() {
        fameRecords.sort(Comparator.comparingInt(FameRecord::getSteps));
    }
}
