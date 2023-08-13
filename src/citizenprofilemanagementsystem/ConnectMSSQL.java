package citizenprofilemanagementsystem;

import java.sql.*;

public class ConnectMSSQL {
    
    Connection c;
    Statement s;

    public ConnectMSSQL () {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection(
"jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;selectMethod=cursor", "sa", "123456");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}