package io.jsql.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLCreateTriggerStatement;
import io.jsql.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class CreateTrigger {
    public static void handle(SQLCreateTriggerStatement x, OConnection connection) {

        connection.writeok();

    }
}
