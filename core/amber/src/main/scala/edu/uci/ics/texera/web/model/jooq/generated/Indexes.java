/*
 * This file is generated by jOOQ.
 */
package edu.uci.ics.texera.web.model.jooq.generated;


import edu.uci.ics.texera.web.model.jooq.generated.tables.File;
import edu.uci.ics.texera.web.model.jooq.generated.tables.KeywordDictionary;
import edu.uci.ics.texera.web.model.jooq.generated.tables.User;
import edu.uci.ics.texera.web.model.jooq.generated.tables.UserDictionary;
import edu.uci.ics.texera.web.model.jooq.generated.tables.UserFileAccess;
import edu.uci.ics.texera.web.model.jooq.generated.tables.Workflow;
import edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowOfUser;
import edu.uci.ics.texera.web.model.jooq.generated.tables.WorkflowUserAccess;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>texera_db</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index FILE_PRIMARY = Indexes0.FILE_PRIMARY;
    public static final Index FILE_UID = Indexes0.FILE_UID;
    public static final Index KEYWORD_DICTIONARY_PRIMARY = Indexes0.KEYWORD_DICTIONARY_PRIMARY;
    public static final Index KEYWORD_DICTIONARY_UID = Indexes0.KEYWORD_DICTIONARY_UID;
    public static final Index USER_GOOGLE_ID = Indexes0.USER_GOOGLE_ID;
    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;
    public static final Index USER_DICTIONARY_PRIMARY = Indexes0.USER_DICTIONARY_PRIMARY;
    public static final Index USER_FILE_ACCESS_FID = Indexes0.USER_FILE_ACCESS_FID;
    public static final Index USER_FILE_ACCESS_PRIMARY = Indexes0.USER_FILE_ACCESS_PRIMARY;
    public static final Index WORKFLOW_PRIMARY = Indexes0.WORKFLOW_PRIMARY;
    public static final Index WORKFLOW_OF_USER_PRIMARY = Indexes0.WORKFLOW_OF_USER_PRIMARY;
    public static final Index WORKFLOW_OF_USER_WID = Indexes0.WORKFLOW_OF_USER_WID;
    public static final Index WORKFLOW_USER_ACCESS_PRIMARY = Indexes0.WORKFLOW_USER_ACCESS_PRIMARY;
    public static final Index WORKFLOW_USER_ACCESS_WID = Indexes0.WORKFLOW_USER_ACCESS_WID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index FILE_PRIMARY = Internal.createIndex("PRIMARY", File.FILE, new OrderField[] { File.FILE.FID }, true);
        public static Index FILE_UID = Internal.createIndex("uid", File.FILE, new OrderField[] { File.FILE.UID, File.FILE.NAME }, true);
        public static Index KEYWORD_DICTIONARY_PRIMARY = Internal.createIndex("PRIMARY", KeywordDictionary.KEYWORD_DICTIONARY, new OrderField[] { KeywordDictionary.KEYWORD_DICTIONARY.KID }, true);
        public static Index KEYWORD_DICTIONARY_UID = Internal.createIndex("uid", KeywordDictionary.KEYWORD_DICTIONARY, new OrderField[] { KeywordDictionary.KEYWORD_DICTIONARY.UID, KeywordDictionary.KEYWORD_DICTIONARY.NAME }, true);
        public static Index USER_GOOGLE_ID = Internal.createIndex("google_id", User.USER, new OrderField[] { User.USER.GOOGLE_ID }, true);
        public static Index USER_PRIMARY = Internal.createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.UID }, true);
        public static Index USER_DICTIONARY_PRIMARY = Internal.createIndex("PRIMARY", UserDictionary.USER_DICTIONARY, new OrderField[] { UserDictionary.USER_DICTIONARY.UID, UserDictionary.USER_DICTIONARY.KEY }, true);
        public static Index USER_FILE_ACCESS_FID = Internal.createIndex("fid", UserFileAccess.USER_FILE_ACCESS, new OrderField[] { UserFileAccess.USER_FILE_ACCESS.FID }, false);
        public static Index USER_FILE_ACCESS_PRIMARY = Internal.createIndex("PRIMARY", UserFileAccess.USER_FILE_ACCESS, new OrderField[] { UserFileAccess.USER_FILE_ACCESS.UID, UserFileAccess.USER_FILE_ACCESS.FID }, true);
        public static Index WORKFLOW_PRIMARY = Internal.createIndex("PRIMARY", Workflow.WORKFLOW, new OrderField[] { Workflow.WORKFLOW.WID }, true);
        public static Index WORKFLOW_OF_USER_PRIMARY = Internal.createIndex("PRIMARY", WorkflowOfUser.WORKFLOW_OF_USER, new OrderField[] { WorkflowOfUser.WORKFLOW_OF_USER.UID, WorkflowOfUser.WORKFLOW_OF_USER.WID }, true);
        public static Index WORKFLOW_OF_USER_WID = Internal.createIndex("wid", WorkflowOfUser.WORKFLOW_OF_USER, new OrderField[] { WorkflowOfUser.WORKFLOW_OF_USER.WID }, false);
        public static Index WORKFLOW_USER_ACCESS_PRIMARY = Internal.createIndex("PRIMARY", WorkflowUserAccess.WORKFLOW_USER_ACCESS, new OrderField[] { WorkflowUserAccess.WORKFLOW_USER_ACCESS.UID, WorkflowUserAccess.WORKFLOW_USER_ACCESS.WID }, true);
        public static Index WORKFLOW_USER_ACCESS_WID = Internal.createIndex("wid", WorkflowUserAccess.WORKFLOW_USER_ACCESS, new OrderField[] { WorkflowUserAccess.WORKFLOW_USER_ACCESS.WID }, false);
    }
}
