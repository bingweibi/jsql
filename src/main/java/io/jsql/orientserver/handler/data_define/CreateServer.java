package io.jsql.orientserver.handler.data_define;

import io.jsql.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class CreateServer {
    public static boolean isme(String sql) {
        String sqll = sql.toUpperCase().trim();
        String list[] = sqll.split("\\s+");
        if (list.length > 2 && list[0].equals("CREATE") && list[1].equals("SERVER")) {
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeok();
    }
}
