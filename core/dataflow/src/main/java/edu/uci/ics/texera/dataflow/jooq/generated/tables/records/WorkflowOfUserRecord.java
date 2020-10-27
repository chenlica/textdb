/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.dataflow.jooq.generated.tables.records;


import edu.uci.ics.texera.dataflow.jooq.generated.tables.WorkflowOfUser;
import edu.uci.ics.texera.dataflow.jooq.generated.tables.interfaces.IWorkflowOfUser;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class WorkflowOfUserRecord extends UpdatableRecordImpl<WorkflowOfUserRecord> implements Record2<UInteger, UInteger>, IWorkflowOfUser {

    private static final long serialVersionUID = -1827901815;

    /**
     * Create a detached WorkflowOfUserRecord
     */
    public WorkflowOfUserRecord() {
        super(WorkflowOfUser.WORKFLOW_OF_USER);
    }

    /**
     * Create a detached, initialised WorkflowOfUserRecord
     */
    public WorkflowOfUserRecord(UInteger uid, UInteger wfId) {
        super(WorkflowOfUser.WORKFLOW_OF_USER);

        set(0, uid);
        set(1, wfId);
    }

    /**
     * Getter for <code>texera_db.workflow_of_user.uid</code>.
     */
    @Override
    public UInteger getUid() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>texera_db.workflow_of_user.uid</code>.
     */
    @Override
    public void setUid(UInteger value) {
        set(0, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UInteger, UInteger> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<UInteger, UInteger> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<UInteger, UInteger> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<UInteger> field1() {
        return WorkflowOfUser.WORKFLOW_OF_USER.UID;
    }

    @Override
    public Field<UInteger> field2() {
        return WorkflowOfUser.WORKFLOW_OF_USER.WF_ID;
    }

    @Override
    public UInteger component1() {
        return getUid();
    }

    @Override
    public UInteger component2() {
        return getWfId();
    }

    @Override
    public UInteger value1() {
        return getUid();
    }

    @Override
    public UInteger value2() {
        return getWfId();
    }

    @Override
    public WorkflowOfUserRecord value1(UInteger value) {
        setUid(value);
        return this;
    }

    @Override
    public WorkflowOfUserRecord value2(UInteger value) {
        setWfId(value);
        return this;
    }

    @Override
    public WorkflowOfUserRecord values(UInteger value1, UInteger value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>texera_db.workflow_of_user.wf_id</code>.
     */
    @Override
    public UInteger getWfId() {
        return (UInteger) get(1);
    }

    /**
     * Setter for <code>texera_db.workflow_of_user.wf_id</code>.
     */
    @Override
    public void setWfId(UInteger value) {
        set(1, value);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    @Override
    public void from(IWorkflowOfUser from) {
        setUid(from.getUid());
        setWfId(from.getWfId());
    }

    @Override
    public <E extends IWorkflowOfUser> E into(E into) {
        into.from(this);
        return into;
    }
}