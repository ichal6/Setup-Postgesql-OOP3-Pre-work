package com.Lechowicz.apps;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Formatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    public static Properties readProperties() {

        Properties props = new Properties();
        Path myPath = Paths.get("src/main/resources/database.properties");

        try {
            BufferedReader bf = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);
            props.load(bf);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }

        return props;
    }

    public static void main(String[] args) {

        //Properties props = readProperties();

        String url = "jdbc:postgresql://localhost:5432/test_db";
        String user = "michael";
        String password = "1234";

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            //Initialize the script runner
            ScriptRunner sr = new ScriptRunner(con);

            //Creating a reader object with new db
            Reader reader = new BufferedReader(new FileReader("src/main/resources/dinos-create.sql"));
            //Running above script
            sr.runScript(reader);

            //Creating a reader object with insert to new db
            reader = new BufferedReader(new FileReader("src/main/resources/dinos-insert.sql"));
            //Running above script
            sr.runScript(reader);

        } catch (SQLException | IOException ex) {

            Logger lgr = Logger.getLogger(
                    Program.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("SELECT * FROM dinos");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                System.out.print(rs.getString(1));
                System.out.print(": ");
                System.out.print(rs.getInt(2));
                System.out.print(": ");
                System.out.println(rs.getInt(3));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Program.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}