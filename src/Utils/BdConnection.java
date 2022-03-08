package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnection {
    private final String url = "jdbc:mysql://localhost:3308/esprin";
    private final String user = "root";
    private final String pwd = "";
    private static BdConnection instance;
    public Connection cnx;

    private BdConnection() throws SQLException {

            cnx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected to Database");
    }

    public static BdConnection getInstance() throws SQLException {
        if (instance == null)
            instance = new BdConnection();
        return instance;
    }
}
