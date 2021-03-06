package io.jsql.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlLoadDataInFileStatement;
import io.jsql.config.ErrorCode;
import io.jsql.orientserver.OConnection;
import io.jsql.storage.DBAdmin;
import io.jsql.storage.MException;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * LOAD DATA INFILE 'data.txt' INTO TABLE db2.my_table;
 */
public class MloaddataINfile {
    public static void handle(MySqlLoadDataInFileStatement x, OConnection connection) {

        if (DBAdmin.currentDB == null) {
            connection.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "没有选择数据库");
        }
        try {
            OConnection.DB_ADMIN.exesqlforResult(x.toString(), DBAdmin.currentDB);
            connection.writeok();
        } catch (MException e) {
            e.printStackTrace();
            connection.writeErrMessage(e.getMessage());
        }

    }
}
