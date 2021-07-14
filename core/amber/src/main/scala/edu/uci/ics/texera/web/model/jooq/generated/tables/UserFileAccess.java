/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.web.model.jooq.generated.tables;


import edu.uci.ics.texera.web.model.jooq.generated.Indexes;
import edu.uci.ics.texera.web.model.jooq.generated.Keys;
import edu.uci.ics.texera.web.model.jooq.generated.TexeraDb;
import edu.uci.ics.texera.web.model.jooq.generated.tables.records.UserFileAccessRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserFileAccess extends TableImpl<UserFileAccessRecord> {

    private static final long serialVersionUID = -996014671;

    /**
     * The reference instance of <code>texera_db.user_file_access</code>
     */
    public static final UserFileAccess USER_FILE_ACCESS = new UserFileAccess();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserFileAccessRecord> getRecordType() {
        return UserFileAccessRecord.class;
    }

    /**
     * The column <code>texera_db.user_file_access.uid</code>.
     */
    public final TableField<UserFileAccessRecord, UInteger> UID = createField(DSL.name("uid"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>texera_db.user_file_access.fid</code>.
     */
    public final TableField<UserFileAccessRecord, UInteger> FID = createField(DSL.name("fid"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>texera_db.user_file_access</code> table reference
     */
    public UserFileAccess() {
        this(DSL.name("user_file_access"), null);
    }

    /**
     * Create an aliased <code>texera_db.user_file_access</code> table reference
     */
    public UserFileAccess(String alias) {
        this(DSL.name(alias), USER_FILE_ACCESS);
    }

    /**
     * Create an aliased <code>texera_db.user_file_access</code> table reference
     */
    public UserFileAccess(Name alias) {
        this(alias, USER_FILE_ACCESS);
    }

    private UserFileAccess(Name alias, Table<UserFileAccessRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserFileAccess(Name alias, Table<UserFileAccessRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UserFileAccess(Table<O> child, ForeignKey<O, UserFileAccessRecord> key) {
        super(child, key, USER_FILE_ACCESS);
    }

    @Override
    public Schema getSchema() {
        return TexeraDb.TEXERA_DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USER_FILE_ACCESS_FID, Indexes.USER_FILE_ACCESS_PRIMARY);
    }

    @Override
    public UniqueKey<UserFileAccessRecord> getPrimaryKey() {
        return Keys.KEY_USER_FILE_ACCESS_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserFileAccessRecord>> getKeys() {
        return Arrays.<UniqueKey<UserFileAccessRecord>>asList(Keys.KEY_USER_FILE_ACCESS_PRIMARY);
    }

    @Override
    public List<ForeignKey<UserFileAccessRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserFileAccessRecord, ?>>asList(Keys.USER_FILE_ACCESS_IBFK_1, Keys.USER_FILE_ACCESS_IBFK_2);
    }

    public User user() {
        return new User(this, Keys.USER_FILE_ACCESS_IBFK_1);
    }

    public File file() {
        return new File(this, Keys.USER_FILE_ACCESS_IBFK_2);
    }

    @Override
    public UserFileAccess as(String alias) {
        return new UserFileAccess(DSL.name(alias), this);
    }

    @Override
    public UserFileAccess as(Name alias) {
        return new UserFileAccess(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserFileAccess rename(String name) {
        return new UserFileAccess(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserFileAccess rename(Name name) {
        return new UserFileAccess(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<UInteger, UInteger> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
