package com.liy.gradle.infrastructure.script;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.sql.Connection;

@Component
public class ScriptRun {

    @Autowired
    DataSource dataSource;

    public void executeSqlFile() {

        try {
            Connection conn = dataSource.getConnection();
            ScriptRunner runner = new ScriptRunner(conn);
            //Set UTF-8
            Resources.setCharset(Charset.forName("UTF-8"));
            //Execute SQL
            runner.runScript(Resources.getResourceAsReader("sql/test.sql"));
            //Close
            runner.closeConnection();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


