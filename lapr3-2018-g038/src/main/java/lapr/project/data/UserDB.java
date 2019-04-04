package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import lapr.project.model.User;
import lapr.project.model.Trip;
import oracle.jdbc.OracleTypes;

/**
 * @author marco
 */
public class UserDB extends DataHandler {

    String eMail;
    String pass;

    Connection conn = null;
    PreparedStatement pstmt1 = null;
    ResultSet rs = null;

    private PreparedStatement statement = null;
    private Connection con;
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    /**
     * Method that returns an user
     *
     * @param email
     * @return User
     */
    public User getUserByEmail(String email) {

        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call GETUSERBYEMAIL(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getUser".
            callStmt.setString(2, email);

            // Executa a invocação da função "getUser".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                User user = new User();
                user.setIdUser(rSet.getLong(1));
                user.setUsername(rSet.getString(2));
                user.setEmail(rSet.getString(3));
                user.setPassword(rSet.getString(4));
                user.setCardNumber(rSet.getString(5));
                user.setHeight(rSet.getDouble(6));
                user.setWeight(rSet.getDouble(7));
                user.setPoints(rSet.getLong(8));
                user.setInitialCost(rSet.getDouble(9));
                return user;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("No User with Email:" + email);
        }
        return null;
    }

    /**
     * Regist a new User on Data Base
     *
     * @param user
     * @return boolean, true
     */
    public boolean newUser(User user) {
        CallableStatement callStmt;
        try {
            // Regista o tipo de dados SQL para interpretar o resultado obtido.

            // Especifica o parâmetro de entrada da função "getUserByUsername".
            callStmt = getConnection().prepareCall("{ call NEWUSER(?,?,?,?,?,?,?,?) }");
            callStmt.setString(1, user.getUsername());
            callStmt.setString(2, user.getEmail());
            callStmt.setString(3, user.getPassword());
            callStmt.setString(4, user.getCardNumber());
            callStmt.setDouble(5, user.getHeight());
            callStmt.setDouble(6, user.getWeight());
            callStmt.setLong(7, user.getPoints());
            callStmt.setDouble(8, user.getInitialCost());
            // Executa a invocação da função "getUserByUsername".
            callStmt.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public User getUserByMailAndPass(String password, String userBykes_Email) {
        return validation(password, userBykes_Email);
    }

    private User validation(String password, String userBykes_Email) {
        long idUser = 0;
        String username = null;
        String password1 = null;
        String email = null;
        String cardNumber = null;
        float height = 0;
        float weight = 0;
        long points = 0;
        double initialCost = 0;

        try {

            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    "SELECT * from USERBYKES WHERE  password = ? and userBykes_Email = ? ");
            statement.setString(1, password);
            statement.setString(2, userBykes_Email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                idUser = resultSet.getLong(1);
                username = resultSet.getString(2);
                email = resultSet.getString(3);
                password1 = resultSet.getString(4);
                height = resultSet.getFloat(6);

                weight = resultSet.getFloat(7);

                points = resultSet.getLong(8);
                initialCost = resultSet.getDouble(9);
                cardNumber = resultSet.getString(5);
                //username = rs.getString(2);

                // System.out.println(rs.toString());
                // STEP 5: Clean-up environment
            }
            resultSet.close();

        } catch (SQLException se) {

            // Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            // finally block used to close resources
            try {

                if (pstmt1 != null) {

                    pstmt1.close();

                }

            } catch (SQLException se2) {
                System.out.println("Erro de SQL");

            } // nothing we can do

            try {

                if (conn != null) {

                    conn.close();

                }

            } catch (SQLException se) {

                se.printStackTrace();

            } finally {

                closeAll();

            }

        } // end try

        User user = new User();

        user.setIdUser(idUser);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password1);
        user.setHeight(height);
        user.setWeight(weight);
        user.setPoints(points);
        user.setInitialCost(initialCost);
        user.setCardNumber(cardNumber);

        return user;

    }

    public double getUserMass(String userName) {

        double mass = 0;

        try {

            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    "SELECT mass from USERBYKES WHERE  userbykes_name = ? ");
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                mass = resultSet.getLong(1);

            }
            resultSet.close();

        } catch (SQLException se) {

            se.printStackTrace();

        } catch (Exception exc) {

            // Handle errors for Class.forName
            exc.printStackTrace();

        } finally {

            try {

                if (pstmt1 != null) {

                    pstmt1.close();

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

                closeAll();

            }

        } // end try

        return mass;

    }

    public Trip getTripByUser(User user) {

        Trip trip = null;
        long tripId = 0;
        long request_Id = 0;
        long bicycle_Id = 0;
        long originPark_Id = 0;
        long destinationPark_Id = 0;
        Date startDate = null;
        Date endDate = null;

        try {

            Class.forName(JDBC_DRIVER);
            con = getConnection();
            statement = con.prepareStatement(
                    "SELECT * from  Trip  WHERE   UserId = ? ");
            statement.setLong(1, user.getIdUser());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tripId = resultSet.getLong(1);
                request_Id = resultSet.getLong(2);
                bicycle_Id = resultSet.getLong(3);
                originPark_Id = resultSet.getLong(4);
                destinationPark_Id = resultSet.getLong(5);
                startDate = resultSet.getDate(6);
                endDate = resultSet.getDate(7);

            }
            resultSet.close();

        } catch (SQLException se) {

            // Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {

            // Handle errors for Class.forName
            e.printStackTrace();

        } finally {

            // finally block used to close resources
            try {

                if (pstmt1 != null) {

                    pstmt1.close();

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

                closeAll();

            }

        }
        trip = new Trip();
        trip.setTripId(tripId);
        trip.setRequest_Id(request_Id);
        trip.setBicycle_Id(bicycle_Id);
        trip.setOriginalPark_Id(originPark_Id);
        trip.setDestinationPark_Id(destinationPark_Id);

        return trip;
    }
}
