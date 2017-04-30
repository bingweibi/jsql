package io.jsql.databaseorient.sqlhander.sqlutil;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLCreateDatabaseStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;

import java.util.*;

/**
 * Created by jiang on 2016/12/17 0017.
 */
public class MSQLutil {
    /**
     * Gets .
     *
     * @param sqlStatement the sql statement
     * @return the
     */
    public static String gettablename(SQLSelectStatement sqlStatement) {
        MySqlSelectQueryBlock select = (MySqlSelectQueryBlock) sqlStatement.getSelect().getQuery();
        return select.getFrom().toString();
    }

    /**
     * Gets .
     *
     * @param sqlStatement the sql statement
     * @return the
     */
    public static List<String> gettablenamefileds(SQLSelectStatement sqlStatement) {
        MySqlSelectQueryBlock select = (MySqlSelectQueryBlock) sqlStatement.getSelect().getQuery();
        List<String> list = new ArrayList<>();
        select.getSelectList().stream().forEach(a->list.add(a.getExpr().toString()));
        return list;
    }
    /**
     * Gets .
     *
     * @param sqlStatement the sql statement
     * @return the
     */
    public static Map<String,String> gettablenamefileds(MySqlCreateTableStatement sqlStatement) {
        Map<String, String> list = new HashMap<>();
       sqlStatement.getTableElementList().forEach(item->{
           SQLColumnDefinition columnDefinition = (SQLColumnDefinition) item;
           String name = columnDefinition.getName().toString();
           String type = columnDefinition.getDataType().getName();
           list.put(name, type);
       });
        return list;
    }


    /**
     * Gets .
     *
     * @param sqlStatement the sql statement
     * @return the
     */
    public static String gettablename(String sqlselectStatement) {
     SQLSelectStatement sqlSelectStatement = null;
     MySqlStatementParser parser = new MySqlStatementParser(sqlselectStatement);
     sqlSelectStatement = (SQLSelectStatement) parser.parseStatement();
     return gettablename(sqlSelectStatement);
    }

    /**
     * Gets .
     *
     * @param sqlStatement the sql statement
     * @return the
     */
    public static List<String> gettablenamefileds(String sqlStatement) {
        SQLSelectStatement sqlSelectStatement = null;
        MySqlStatementParser parser = new MySqlStatementParser(sqlStatement);
        sqlSelectStatement = (SQLSelectStatement) parser.parseSelect();
        return gettablenamefileds(sqlSelectStatement);
    }

    /**
     * Gets .
     *
     * @param statement the statement
     * @return the
     */
    public static String getdbname(SQLCreateDatabaseStatement statement) {
        return statement.getName().getSimpleName();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        String sql = "create table t1(id int,name varchar);";
        gettablenamefileds((MySqlCreateTableStatement) SQLUtils.parseStatements(sql, "mysql").get(0));
//        System.out.println(gettablenamefileds("select *,rff from dd"));
//        System.out.println(gettablename("select * from dd"));
    }
}
