package lapr.project.data;

import javafx.util.Pair;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class PoiConnectionsDB extends DataHandler {

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    private PreparedStatement statement;
    private Connection con;
    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    /**
     * @param poiOriginAndDestiny
     * @return Map<Map < String ,   String>, Map<Pair<Long,Long>, Long>>
     */
    public Map<Pair<String, String>, Pair<Pair<Long, Long>, Long>> getVelAndWind(Map<String, String> poiOriginAndDestiny) {

        // Map<String, String> originAndDestinyPOI = new HashMap<>();
        Map<Pair<Long, Long>, Long> velocitiesAndAngleMap = new HashMap<>();
        Map<Pair<String, String>, Pair<Pair<Long, Long>, Long>> origDestinyMapAndVelocitiesAndAngleMap = new HashMap<>();
        Map<Map<String, String>, Map<Pair<Long, Long>, Long>> origDestinyMapAndVelocitiesAndAngleMapOfEntries = new HashMap<>();

        PreparedStatement getVelocitiesandAndAngleDistancePairsMap = null;
        //String getValuesForEachMapEntryInsertRequestQuery = "SELECT  POICONNECTION.origin, POI.destiny, POICONNECTION.vrK, POICONNECTION.vak, POI.angle    from  POICONNECTION  WHERE   (POICONNECTION.origin = ? and POICONNECTION.destiny = ? ";

        try {
            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement("SELECT  POICONNECTION.origin, POICONNECTION.destiny, POICONNECTION.vrK, POICONNECTION.vak, POICONNECTION.angle    from  POICONNECTION  WHERE   (POICONNECTION.origin = ? and POICONNECTION.destiny = ? )");
            String origin;
            String destiny;
            Pair<String, String> originDestinyMap = null;
            long velocityVrK = 0;
            long velocityVaK = 0;
            Pair<Long, Long> velocities = null;
            long angle = 0;
            long distance = 0;
            Pair<Pair<Long, Long>, Long> velocitiesAndAngle = null;


           //con.setAutoCommit(false);
            // getVelocitiesandAndAngleDistancePairsMap = con.prepareStatement(getValuesForEachMapEntryInsertRequestQuery);

            for (Map.Entry<String, String> item : poiOriginAndDestiny.entrySet()) {
                statement.setString(1, item.getKey());
                statement.setString(2, item.getValue());
                //getVelocitiesandAndAngleDistancePairsMap.executeUpdate();
                // con.commit();
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {


                    // Map<String,String> originDestiny = new HashMap<String, String>();
                    origin = resultSet.getString(1);
                    destiny = resultSet.getString(2);
                    originDestinyMap = new Pair<>(origin, destiny);

                    // Pair<Long, Long> velocities;
                    velocityVrK = resultSet.getLong(3);
                    velocityVaK = resultSet.getLong(4);
                    velocities = new Pair<>(velocityVrK, velocityVaK);

                    // Pair<Long, Long> angleAndDistances;
                    angle = resultSet.getLong(5);
                    //distance = resultSet.getLong(6);
                    velocitiesAndAngle = new Pair<Pair<Long, Long>, Long>(velocities, angle);

                    //Map velocities and angle
                    velocitiesAndAngleMap.put(velocities, angle);

                }
                resultSet.close();

                origDestinyMapAndVelocitiesAndAngleMap.put(originDestinyMap, velocitiesAndAngle);

            }
            System.out.println("orig Destiny Map And Velocities And Angl eMap recebidos da TabelaPoincoonnection: " + origDestinyMapAndVelocitiesAndAngleMap);
            return origDestinyMapAndVelocitiesAndAngleMap;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
