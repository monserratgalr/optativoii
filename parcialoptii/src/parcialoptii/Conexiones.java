/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialoptii;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexiones {
    private String userDB;
    private String passDB;
    private String portDB;
    private String hostDB;
    private String dataBase;
    private String url;
    private Statement querySQL;
    private ResultSet resultQuery;
    
    public Conexiones(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        Connection conn=null;
        this.userDB = userBD;
        this.passDB = passDB;
        this.portDB = portDB;
        this.dataBase = dataBase;
        this.hostDB = hostDB;
        this.url = "jdbc:postgresql://" + this.hostDB + ":"+ this.portDB+"/"+dataBase;
    }
    public Connection conexionDB() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(this.url, this.userDB, this.passDB);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Statement getQuerySQL(){
        return this.querySQL;
    }
    public void setQuerySQL(Statement sentencia){
        this.querySQL = sentencia;
    }
    public ResultSet getResultadoQuery(){
        return this.resultQuery;
    }
    public void setResultadoQuery(ResultSet resultado){
        this.resultQuery = resultado;
    }
}






    

