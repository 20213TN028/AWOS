package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoOperations {
    Connection conn;
    PreparedStatement pste;
    ResultSet rs;

    public List<BeanOperations> showHistory(){
        List<BeanOperations> operations = new ArrayList<>();
        BeanOperations operation = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM operations;");
            rs = pste.executeQuery();
            while(rs.next()){
                operation = new BeanOperations();
                operation.setId(rs.getLong("id"));
                operation.setOperationType(rs.getString("type"));
                operation.setFirstNumber(rs.getDouble("first_number"));
                operation.setSecondNumber(rs.getDouble("second_number"));
                operation.setResult(rs.getDouble("result"));
                operation.setCreateAt(rs.getDate("create_at"));
                operations.add(operation);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoOperations.class.getName()).log(Level.SEVERE, "Error showHistory", e);
        }finally{
            closeConnection();
        }
        return operations;
    }

    public boolean saveOperation(BeanOperations operation){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO operations (type, first_number, second_number, result)" +
                    "VALUES (?, ?, ?, ?)");
            pste.setString(1, operation.getOperationType());
            pste.setDouble(2, operation.getFirstNumber());
            pste.setDouble(3, operation.getSecondNumber());
            pste.setDouble(4, operation.getResult());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoOperations.class.getName()).log(Level.SEVERE, "Error saveOperation", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
            if(pste != null){
                pste.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){

        }
    }
}
