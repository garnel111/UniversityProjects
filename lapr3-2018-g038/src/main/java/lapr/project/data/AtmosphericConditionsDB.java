package lapr.project.data;

import java.sql.*;

public class AtmosphericConditionsDB extends DataHandler {


    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    private PreparedStatement statement;
    private Connection con;
    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    public int getWindWayDirection(String parkOrigin, String parkDestiny) {
        int wayDirection = 0;
        String parkOrigin_Id = null;
        String parkDestiny_Id = null;
        try {

            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    "SELECT Atmospheric_Conditions.WindDIRECTION, Atmospheric_Conditions.origin, Atmospheric_Conditions.Destination  from Atmospheric_Conditions WHERE  (\n" +
                            "(Atmospheric_Conditions.origin = ? AND Atmospheric_Conditions.Destination = ?) OR  (Atmospheric_Conditions.origin = ? AND Atmospheric_Conditions.Destination = ?))");
            statement.setString(1, parkOrigin);
            statement.setString(2, parkDestiny);
            statement.setString(3, parkDestiny);
            statement.setString(4, parkOrigin);


            rs = statement.executeQuery();

            while (rs.next()) {


                wayDirection = rs.getInt(1);
                parkOrigin_Id = rs.getString(2);
                parkDestiny_Id = rs.getString(3);

                // STEP 5: Clean-up environment
            }
            rs.close();

            if (parkOrigin.equals(parkOrigin_Id) && parkDestiny.equals(parkDestiny_Id)) {

                return wayDirection;
            }
            return -wayDirection;
        } catch (Exception se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }// Handle errors for Class.forName
        throw new IllegalArgumentException("");
    }
}
