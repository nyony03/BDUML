package DAO;

import java.sql.*;

public class ConnexionBD {

    private Driver driverJDBC;
    private String url;
    private String login;
    private String mdp;
    protected Statement st;
    protected ResultSet rs;
    private Connection cn;
    private static ConnexionBD connexionBD = null;

    private ConnexionBD() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        url = "jdbc:oracle:thin:@162.38.222.149:1521:iut";
        login = "nussbaumerj";
        mdp = "07051993";
        cn = DriverManager.getConnection(url, login, mdp);
    }

    public static ConnexionBD getInstance() throws SQLException, ClassNotFoundException {
        if (connexionBD == null) {
            connexionBD = new ConnexionBD();
        }
        return connexionBD;
    }

    public Connection getCn() {
        return cn;
    }
}
