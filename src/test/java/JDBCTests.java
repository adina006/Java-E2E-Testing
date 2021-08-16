import org.testng.annotations.Test;

import java.sql.*;

public class JDBCTests {

    @Test
    public void test() throws SQLException {
        String conString = "jdbc:mysql://localhost:3306/testdatas";
        try {
            Connection conn = DriverManager.getConnection(conString, "root", "1230");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM loginData;");

            while(resultSet.next()){
                String tcName = resultSet.getString("TC_Name");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Pass");
                System.out.println(tcName + "," + email + "," + password);
            }

        } catch (SQLException ex) {
            throw ex;
        }
    }
}
