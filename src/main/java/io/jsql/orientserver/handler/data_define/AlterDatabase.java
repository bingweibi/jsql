package io.jsql.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLAlterDatabaseStatement;
import io.jsql.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * ALTER {DATABASE | SCHEMA} [db_name]
 * alter_specification ...
 * ALTER {DATABASE | SCHEMA} db_name
 * UPGRADE DATA DIRECTORY NAME
 * <p>
 * alter_specification:
 * [DEFAULT] CHARACTER SET [=] charset_name
 * | [DEFAULT] COLLATE [=] collation_name
 * <p>
 * --ALTER DATABASE CUSTOM strictSQL=false
 */
public class AlterDatabase {
    public static void handle(SQLAlterDatabaseStatement x, OConnection connection) {

        connection.writeok();
    }
}
