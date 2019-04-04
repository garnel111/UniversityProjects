package lapr.project.data;

//import lapr.project.model.POI;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lapr.project.model.Administrator;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author marco
 */
public class AdministratorDB extends DataHandler {

    /**
     * Method that returns an Administrator
     *
     * @param email
     * @return Administrator
     */
    public Administrator getAdministratorByEmail(String email) {

        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call GETADMINISTRATORBYEMAIL(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getUser".
            callStmt.setString(2, email);

            // Executa a invocação da função "getUser".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                Administrator admin = new Administrator();
                admin.setIdAdministrator(rSet.getLong(1));
                admin.setName(rSet.getString(2));
                admin.setEmail(rSet.getString(3));
                admin.setPassword(rSet.getString(4));
                return admin;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("No Administrator with Email:" + email);
        }
        return null;
    }

    /**
     * Regist a new Administrator on Data Base
     *
     * @param admin
     * @return boolean, true
     */
    public boolean newAdministrator(Administrator admin) {
        CallableStatement callStmt;
        try {
            // Regista o tipo de dados SQL para interpretar o resultado obtido.

            callStmt = getConnection().prepareCall("{ call NEWADMINISTRATOR(?,?,?) }");
            callStmt.setString(1, admin.getName());
            callStmt.setString(2, admin.getEmail());
            callStmt.setString(3, admin.getPassword());

            callStmt.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

//    public void addPOI(POI ponto) throws SQLException {
//
//        Connection conn;
//        Statement Stmt = null;
//        try {
//            conn = getConnection();
//            Stmt = conn.createStatement();
//            String sql = "INSERT into POI (name, type, latitude, longitude,organization_id) VALUES ("
//                    +ponto.getName()+","
//                    +ponto.getType()+","
//                    +ponto.getLatitude()+","
//                    +ponto.getLongitude()+","
//                    +ponto.getOrganizationId()+","
//                    +")";
//
//            Stmt.executeQuery(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (Stmt != null) {
//                Stmt.close();
//            }
//        }
//        throw new IllegalArgumentException("POI already exists!");
//
//    }
//
}
