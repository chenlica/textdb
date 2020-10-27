/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.dataflow.jooq.generated.tables.daos;


import edu.uci.ics.texera.dataflow.jooq.generated.tables.KeySearchDict;
import edu.uci.ics.texera.dataflow.jooq.generated.tables.records.KeySearchDictRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.jooq.types.UInteger;

import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class KeySearchDictDao extends DAOImpl<KeySearchDictRecord, edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict, UInteger> {

    /**
     * Create a new KeySearchDictDao without any configuration
     */
    public KeySearchDictDao() {
        super(KeySearchDict.KEY_SEARCH_DICT, edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict.class);
    }

    /**
     * Create a new KeySearchDictDao with an attached configuration
     */
    public KeySearchDictDao(Configuration configuration) {
        super(KeySearchDict.KEY_SEARCH_DICT, edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict.class, configuration);
    }

    @Override
    public UInteger getId(edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict object) {
        return object.getKsdId();
    }

    /**
     * Fetch records that have <code>uid BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchRangeOfUid(UInteger lowerInclusive, UInteger upperInclusive) {
        return fetchRange(KeySearchDict.KEY_SEARCH_DICT.UID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uid IN (values)</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchByUid(UInteger... values) {
        return fetch(KeySearchDict.KEY_SEARCH_DICT.UID, values);
    }

    /**
     * Fetch records that have <code>ksd_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchRangeOfKsdId(UInteger lowerInclusive, UInteger upperInclusive) {
        return fetchRange(KeySearchDict.KEY_SEARCH_DICT.KSD_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ksd_id IN (values)</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchByKsdId(UInteger... values) {
        return fetch(KeySearchDict.KEY_SEARCH_DICT.KSD_ID, values);
    }

    /**
     * Fetch a unique record that has <code>ksd_id = value</code>
     */
    public edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict fetchOneByKsdId(UInteger value) {
        return fetchOne(KeySearchDict.KEY_SEARCH_DICT.KSD_ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(KeySearchDict.KEY_SEARCH_DICT.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchByName(String... values) {
        return fetch(KeySearchDict.KEY_SEARCH_DICT.NAME, values);
    }

    /**
     * Fetch records that have <code>content BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchRangeOfContent(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(KeySearchDict.KEY_SEARCH_DICT.CONTENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchByContent(byte[]... values) {
        return fetch(KeySearchDict.KEY_SEARCH_DICT.CONTENT, values);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(KeySearchDict.KEY_SEARCH_DICT.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<edu.uci.ics.texera.dataflow.jooq.generated.tables.pojos.KeySearchDict> fetchByDescription(String... values) {
        return fetch(KeySearchDict.KEY_SEARCH_DICT.DESCRIPTION, values);
    }
}