/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.dataflow.resource.dictionaryJooq.tables;


import edu.uci.ics.texera.dataflow.resource.dictionaryJooq.DefaultSchema;
import edu.uci.ics.texera.dataflow.resource.dictionaryJooq.Indexes;
import edu.uci.ics.texera.dataflow.resource.dictionaryJooq.Keys;
import edu.uci.ics.texera.dataflow.resource.dictionaryJooq.tables.records.DictionaryRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Dictionary extends TableImpl<DictionaryRecord> {

    private static final long serialVersionUID = -500512355;

    /**
     * The reference instance of <code>DICTIONARY</code>
     */
    public static final Dictionary DICTIONARY = new Dictionary();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DictionaryRecord> getRecordType() {
        return DictionaryRecord.class;
    }

    /**
     * The column <code>DICTIONARY.ID</code>.
     */
    public final TableField<DictionaryRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>DICTIONARY.NAME</code>.
     */
    public final TableField<DictionaryRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>DICTIONARY.CONTENT</code>.
     */
    public final TableField<DictionaryRecord, String> CONTENT = createField("CONTENT", org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * Create a <code>DICTIONARY</code> table reference
     */
    public Dictionary() {
        this(DSL.name("DICTIONARY"), null);
    }

    /**
     * Create an aliased <code>DICTIONARY</code> table reference
     */
    public Dictionary(String alias) {
        this(DSL.name(alias), DICTIONARY);
    }

    /**
     * Create an aliased <code>DICTIONARY</code> table reference
     */
    public Dictionary(Name alias) {
        this(alias, DICTIONARY);
    }

    private Dictionary(Name alias, Table<DictionaryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Dictionary(Name alias, Table<DictionaryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Dictionary(Table<O> child, ForeignKey<O, DictionaryRecord> key) {
        super(child, key, DICTIONARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.DICTIONARY_NAME_INDEX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<DictionaryRecord, Integer> getIdentity() {
        return Keys.IDENTITY_DICTIONARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DictionaryRecord> getPrimaryKey() {
        return Keys.PK_DICTIONARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DictionaryRecord>> getKeys() {
        return Arrays.<UniqueKey<DictionaryRecord>>asList(Keys.PK_DICTIONARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dictionary as(String alias) {
        return new Dictionary(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dictionary as(Name alias) {
        return new Dictionary(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Dictionary rename(String name) {
        return new Dictionary(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Dictionary rename(Name name) {
        return new Dictionary(name, null);
    }
}
