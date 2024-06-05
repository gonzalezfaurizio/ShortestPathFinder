// File: src/com/shortestpathfinder/dao/HallOfFameDAO.java
package com.shortestpathfinder.dao;

import com.shortestpathfinder.model.FameRecord;
import java.util.List;

/**
 * Interface for Hall of Fame data access operations.
 * 
 * @version 1.0
 * @since 2024-05-21
 * 
 * @authors:
 * - GONZALEZ ALFARO FAURIZIO
 * - RODRIGUEZ GUTIERREZ REBECA
 * - RODRIGUEZ RODRIGUEZ ANDREY ELADIO
 */
public interface HallOfFameDAO {

    List<FameRecord> getAllFameRecords();

    FameRecord getFameRecordById(String id);

    void addFameRecord(FameRecord fameRecord);

    void updateFameRecord(FameRecord fameRecord);

    void deleteFameRecord(String id);
}
