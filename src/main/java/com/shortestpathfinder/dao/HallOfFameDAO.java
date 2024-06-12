package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.FameRecord;
import java.util.List;

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
public interface HallOfFameDAO {

    /**
     * Retrieves a list of all fame records.
     *
     * @return a list of all FameRecord objects.
     */
    List<FameRecord> getAllFameRecords();

    /**
     * Retrieves a fame record by its unique ID.
     *
     * @param id the unique ID of the fame record.
     * @return the FameRecord object with the specified ID, or null if no such
     * record exists.
     */
    FameRecord getFameRecordById(String id);

    /**
     * Adds a new fame record.
     *
     * @param fameRecord the FameRecord object to be added.
     */
    void addFameRecord(FameRecord fameRecord);

    /**
     * Updates an existing fame record.
     *
     * @param fameRecord the FameRecord object with updated information.
     */
    void updateFameRecord(FameRecord fameRecord);

    /**
     * Deletes a fame record by its unique ID.
     *
     * @param id the unique ID of the fame record to be deleted.
     */
    void deleteFameRecord(String id);
}
