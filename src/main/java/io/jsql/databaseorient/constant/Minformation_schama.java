package io.jsql.databaseorient.constant;

import io.jsql.databaseorient.adapter.MDBadapter;
import io.jsql.databaseorient.adapter.MException;

/**
 * Created by 长宏 on 2017/3/23 0023.
 */
public class Minformation_schama {
    public static final String dbname = "information_schema";

    public static void init_if_notexits() {
        if (MDBadapter.dbset.contains(dbname)) {
        } else {
            try {
                MDBadapter.createdbsyn(dbname);
                MvariableTable.init_if_notexits();
            } catch (MException e) {
                e.printStackTrace();
            }
        }
    }
}
