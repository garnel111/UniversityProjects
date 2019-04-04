/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import lapr.project.controller.ParkController;
import lapr.project.model.Bicycle;
import lapr.project.model.Park;
import oracle.jdbc.OracleTypes;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author magal
 */
public class ParkDB extends DataHandler {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    private PreparedStatement statement = null;
    private Connection con;
    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    /**
     * Construtor sem parâmetros
     */
    public ParkDB() {
        //Construtor vazio
    }

    public Park getParkByName(String name) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkByName(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getParkByName".
            callStmt.setString(2, name);

            // Executa a invocação da função "getParkByName".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                Park nP = new Park();
                nP.setId(rSet.getLong(1));
                nP.setAdmin_Id(rSet.getLong(2));
                nP.setName(rSet.getString(3));
                nP.setLatitude(rSet.getFloat(4));
                nP.setLongitude(rSet.getFloat(5));
                nP.setMaxCapacityNonElectric(rSet.getLong(6));
                nP.setMaxCapacityElectric(rSet.getLong(7));
                return nP;
            }
            closeAll();
        } catch (SQLException e) {
            throw new IllegalArgumentException("No Park with name:" + name);
        }
        return null;
    }


    public Park getParkByCoordinates(BigDecimal latitude, BigDecimal longitude) throws SQLException {

        Park parque;
        String parkName = new String();
        ParkController pC = new ParkController();

        Connection conn;
        Statement Stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            Stmt = conn.createStatement();
            String sql = "Select ParkName From Park WHERE Latitude = " + latitude + " AND Longitude = " + longitude;

            rs = Stmt.executeQuery(sql);

            while (rs.next()) {
                parkName = rs.getString(1);
            }
            System.out.println("PNAME:" + parkName);
            parque = pC.getParkByName(parkName);
            return parque;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (Stmt != null) {
                Stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        throw new IllegalArgumentException("No Park found!");
    }


    public boolean newPark(Park park) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ call ADDNEWPARK (?,?,?,?,?) }");

            callStmt.setString(1, park.getName());
            callStmt.setFloat(2, park.getLatitude());
            callStmt.setFloat(3, park.getLongitude());
            callStmt.setLong(4, park.getMaxCapacityNonEletric());
            callStmt.setLong(5, park.getMaxCapacityElectric());

            callStmt.execute();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean removePark(String parkName) {

        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call REMOVEPARK(?) }");

            callStmt.setString(1, parkName);

            callStmt.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<String> getParkNames() throws SQLException {

        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkNames }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);

            // Executa a invocação da função "getParkByName".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            List<String> parks = new ArrayList<>();
            while (rSet.next()) {
                parks.add(rSet.getString(1));
            }
            closeAll();
            return parks;
        } catch (SQLException e) {
            throw new IllegalArgumentException("No Parks found!");
        }
    }

    public String getParkById(Long park_Id) {

        park_Id = park_Id;
        String parkName = null;

        try {

            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    "SELECT PARK.PARKNAME from PARK WHERE  PARK.PARK_ID = ?");
            statement.setLong(1, park_Id);

            ResultSet rSet = statement.executeQuery();

            while (rSet.next()) {

                parkName = rSet.getString(1);

                // System.out.println(rs.toString());
                // STEP 5: Clean-up environment
            }
            rSet.close();

        } catch (SQLException se) {

            // Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {

            // Handle errors for Class.forName
            e.printStackTrace();

        } finally {

            // finally block used to close resources
            try {

                if (pstmt != null) {

                    pstmt.close();

                }

            } catch (SQLException se2) {

            } // nothing we can do

            try {

                if (conn != null) {

                    conn.close();

                }

            } catch (SQLException se) {

                se.printStackTrace();

            } finally {

            }

        } // end try

        return parkName;
    }

    public boolean updateBicycleOnDestinyPark(Park destinationPark, Bicycle bicycle) throws SQLException {
        try {
            openConnection();
            /*
             *  Objeto "callStmt" para invocar o procedimento "updatePark" armazenado na BD.
             *
             *  PROCEDURE updatePark(Park destination and bicycle)
             *
             */

            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    "UPDATE  Slot  set Bicycle_ID = ? \n"
                            + "where slot.bicycle_id is NUll\n"
                            + "AND\n"
                            + "slot.slot_id = (select min(slot.slot_id) from slot where slot.bicycle_id is null and slot.Park_Id = ? and slot.SlotType=?) ");
            statement.setLong(2, destinationPark.getId());
            statement.setLong(1, bicycle.getIdBicycle());
            if (!(bicycle.getType().equals("Electric"))) {
                statement.setString(3, "NonElectric");
            } else {
                statement.setString(3, "Electric");
            }
            ResultSet rSet = statement.executeQuery();

//            callStmt.setFloat(1, bicycleMass);
//            callStmt.setFloat(2, km);
//            callStmt.setString(3, type);
//            callStmt.execute();
            closeAll();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public long getFreeSlot(String destinationParkName, String bicycleType) {

        CallableStatement getslot = null;

        try {

            getslot = getConnection().prepareCall("{?=call GETFREESLOT(?,?)}");
            getslot.registerOutParameter(1, OracleTypes.INTEGER);
            getslot.setString(2, destinationParkName);
            getslot.setString(3, bicycleType);
            getslot.execute();

            long freeslot = getslot.getLong(1);

            closeAll();
            if (freeslot > 0) {

                return freeslot;

            } else {
                System.out.println("there is no free slot avaiable please try another park");
            }


        } catch (SQLException error) {

            error.printStackTrace();
        }

        throw new IllegalArgumentException("");
    }

    public boolean checkParkExistence(Park park) {
        CallableStatement checkParkExistence = null;
        float counter = 0;
        try {

            /*
             *  Objeto "callStmt" para invocar o procedimento "updatePark" armazenado na BD.
             *
             *  PROCEDURE updatePark(Park destination and bicycle)
             *
             */
            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    " SELECT COUNT(1)\n"
                            + "FROM Park\n"
                            + "WHERE (Latitude =? AND Longitude = ?)");
            statement.setFloat(1, park.getLatitude());
            statement.setFloat(2, park.getLongitude());

            ResultSet rSet = statement.executeQuery();
            while (rSet.next()) {
                counter = rSet.getInt(1);
            }
            rSet.close();

            return counter != 0;

        } catch (SQLException error) {

            error.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("");
    }

    public Park getParkByLatitudeAndLongitudeValues(float latitude, float longitude) {
        CallableStatement checkParkExistence = null;
        Park park = new Park();
        try {

            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    " SELECT *"
                            + "FROM Park\n"
                            + "WHERE (Latitude =? AND Longitude = ?)");
            statement.setFloat(1, latitude);
            statement.setFloat(2, longitude);

            ResultSet resultTest = statement.executeQuery();
            while (resultTest.next()) {
                park.setMaxCapacityElectric(resultTest.getLong(7));
                park.setLongitude(resultTest.getFloat(5));

                park.setMaxCapacityNonElectric(resultTest.getLong(6));

                park.setName(resultTest.getString(3));
                park.setLatitude(resultTest.getFloat(4));

                park.setAdmin_Id(resultTest.getLong(2));
                park.setId(resultTest.getLong(1));
                return park;
            }
            rs.close();

            return park;

        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("");
    }
}
