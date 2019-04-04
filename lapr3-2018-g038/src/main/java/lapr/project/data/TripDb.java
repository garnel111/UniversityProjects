package lapr.project.data;

import javafx.util.Pair;


import java.sql.*;

public class TripDb extends DataHandler{

    String e_mail;
    String pass;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    private PreparedStatement statement = null;
    private Connection con;
    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";


    public Pair<Long, Long> getOriginAndDestinyParksIdByTripId(long trip_Id) {

        long trip_id = trip_Id;

        Pair<Long, Long> origin_destinyParks = null;

        long userId = 0;
        long request_Id = 0;
        long bicycle_Id = 0;
        long originPark_Id = 0;
        long destinationPark_Id = 0;


        try {

            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    "SELECT Trip.originPark_Id, Trip.DestinationPark_Id from Trip WHERE  Trip.Trip_ID = ?");
            statement.setLong(1, trip_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {


                originPark_Id = resultSet.getLong(1);
                destinationPark_Id = resultSet.getLong(2);
                origin_destinyParks = new Pair<>(originPark_Id, destinationPark_Id);

                // STEP 5: Clean-up environment
            }
            resultSet.close();

        } catch (SQLException se) {

            // Handle errors for JDBC
            se.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            // finally block used to close resources
            try {

                if (pstmt != null) {

                    pstmt.close();

                }

            } catch (SQLException se2) {
                se2.printStackTrace();
            }

            try {

                if (conn != null) {

                    conn.close();

                }

            } catch (SQLException se) {

                se.printStackTrace();

            }
        } 
        return origin_destinyParks;
    }
}
