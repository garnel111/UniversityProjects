package lapr.project.data;

import lapr.project.model.Bicycle;
import lapr.project.model.Park;
import lapr.project.model.User;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.Calendar;

public class BicycleDB extends DataHandler {
    //
    private PreparedStatement statement = null;
    private Connection request;
    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private Connection con;

    public int countBikeByType(String type, String namePark) {

        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call countBikeByType(?,?) }");
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            //   callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "countBikeByType".
            callStmt.setString(2, type);
            callStmt.setString(3, namePark);

            // Executa a invocação da função "countBikeByType".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            int count = (int) callStmt.getObject(1);
            closeAll();
            return count;
//            if (rSet.next()) {
//                int count = rSet.getInt(1);
//                return   count;
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Park with name:" + namePark);
    }

    //public boolean addBicycle(Bicycle b, String namePark) {
    //    return addBicycle(b.getBicycleMass(), b.getKm(), b.getType());
    //}
    public boolean addBicycle(float bicycleMass, float km, String type, String namePark) {

        try {
            openConnection();
            /*
             *  Objeto "callStmt" para invocar o procedimento "addBicycle" armazenado na BD.
             *
             *  PROCEDURE addBicycle(bicycleMass FLOAT, km FLOAT, type STRING)
             *  PACKAGE pkgBicycles AS TYPE ref_cursor IS REF CURSOR; END pkgBicycles;
             */
            CallableStatement callStmt = getConnection().
                    prepareCall("{ call addBicycle(?,?,?) }");

            callStmt.setFloat(1, bicycleMass);
            callStmt.setFloat(2, km);
            callStmt.setString(3, type);
            callStmt.execute();

            closeAll();
            return true;
        } catch (SQLException e) {
             return false;
        }
    }

    public long UserRequestBicycle(Park park, String bicycleType, User user) throws ClassNotFoundException, SQLException {

        long idpark = park.getId();

        CallableStatement callStmt;
        try {

            callStmt = getConnection().prepareCall("{?=call GETSLOT(?,?)}");
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            callStmt.setLong(2, idpark);
            callStmt.setString(3, bicycleType);
            callStmt.execute();

            long slotRetorno = callStmt.getLong(1);

            addRequest(user);
            closeAll();
            return slotRetorno;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("");
    }

    public void addRequest(User user) throws ClassNotFoundException {

        long userid = user.getIdUser();
        String requestTemporaryState = "Pago";

        Calendar systemDate = Calendar.getInstance();//creates calendar instance
        Date sysdateSql = new Date((systemDate.getTime().getTime()));// creates sql date

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = getConnection();
            String insertRequestQuery = "INSERT into REQUEST (USERBYKES_ID,REQUESTDATE,STATE)"
                    + "values (?,?,?)";

            PreparedStatement insertRequestStatement = connection.prepareStatement(insertRequestQuery);

            insertRequestStatement.setLong(1, userid);
            insertRequestStatement.setDate(2, sysdateSql);
            insertRequestStatement.setString(3, requestTemporaryState);

            insertRequestStatement.execute();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public long getBikeIDbyDescription(String description) {
        long bikeId = 0;
        try {

            Class.forName(JDBC_DRIVER);
            Connection connection = getConnection();
            PreparedStatement pStatement = con.prepareStatement("Select Bicycle.Bicycle_ID from Bicycle where Bicycle.description = ?");
            pStatement.setString(1, description);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                bikeId = rs.getInt(1);
            }

            connection.close();
            return bikeId;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("");
    }


    public boolean addBicyclesAndNewPark(Bicycle bike, Park park) {
        /*
         * adiciona a bike e o park qd nao existe park
         */
        long idpark = park.getId();

        CallableStatement callStmt;
        try {

            callStmt = getConnection().prepareCall("{call AddBikeAndPark(?,?,?,?,?,?,?,?,?,?,?)}");
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            //Bike Paramethers
            callStmt.setLong(1, (long) bike.getBicycleMass());
            callStmt.setLong(2, (long) bike.getKm());
            callStmt.setString(3, bike.getType());
            callStmt.setString(4, bike.getDescription());

            callStmt.setString(5, park.getName());
           // callStmt.setLong(6, park.getAdmin_Id());
            callStmt.setLong(6, 30);
            callStmt.setLong(7, (long) park.getLatitude());
            callStmt.setLong(8, (long) park.getLongitude());
            callStmt.setLong(9, (long) 1); //organization ID
            callStmt.setLong(10,park.getMaxCapacityNonEletric());
            callStmt.setLong(11,park.getMaxCapacityEletric());

      
            callStmt.execute();

            closeAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("");
    }


}
