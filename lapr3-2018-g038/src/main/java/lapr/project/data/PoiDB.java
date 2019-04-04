package lapr.project.data;

import lapr.project.model.POI;
import lapr.project.model.Park;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PoiDB extends DataHandler {



    public void addPOI(POI poi) throws SQLException {

        Connection conn;
        Statement Stmt = null;
        try {
            conn = getConnection();
            Stmt = conn.createStatement();
            String sql = "INSERT INTO POI (name, latitude, longitude, type) VALUES ("
                    +poi.getName()+","
                    +poi.getLatitude()+","
                    +poi.getLongitude()+","
                    +poi.getType()
                    +")";

            Stmt.executeQuery(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (Stmt != null) {
                Stmt.close();
            }
        }
        throw new IllegalArgumentException("POI already exists!");

    }



    public List<String> getPOInames() throws SQLException {
        List<String> pois = new ArrayList<>();

        Connection conn;
        Statement Stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            Stmt = conn.createStatement();
            String sql = "Select POIname From POI";

            rs = Stmt.executeQuery(sql);

            while (rs.next()) {
                pois.add(rs.getString(1));

            }
            return pois;
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
        throw new IllegalArgumentException("No POIs found!");
    }




    public POI getPoiByName(String name) {
        CallableStatement callStmt;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getPoiByName(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getParkByName".
            callStmt.setString(2, name);

            // Executa a invocação da função "getParkByName".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                POI nP = new POI();
                nP.setId(rSet.getLong(1));
                nP.setName(rSet.getString(2));
                nP.setType(rSet.getString(3));
                nP.setLatitude(rSet.getFloat(4));
                nP.setLongitude(rSet.getFloat(5));
                nP.setOrganizationId(rSet.getLong(6));
                return nP;
            }
            closeAll();
        } catch (SQLException e) {
            throw new IllegalArgumentException("No Poi with name:" + name);
        }
        return null;
    }
}



