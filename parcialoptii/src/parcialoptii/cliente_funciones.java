/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import parcialoptii.Conexiones;
import parcialoptii.cliente;


public class cliente_funciones {
    private Conexiones conexion;
    public cliente_funciones(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }
    public String registrarCliente(cliente cliente1) throws SQLException{
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        boolean execute = conexion.getQuerySQL().execute("INSERT INTO Clientes(" +
                "fecha_ingreso," +"estado," +"calificacion," +"id_persona)" +
                "values('" +
                cliente1.fecha_ingreso+"','"+cliente1.estado +cliente1.calificacion +cliente1.id_persona +"')");
        conexion.conexionDB().close();
        return "El cliente  ha sido registrado";
    }
    public String eliminarCliente(int cliente) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM Clientes WHERE id_cliente = " + cliente);
        conexion.conexionDB().close();
        if (rowCount > 0) {
            return "El cliente con el id ingresado " + cliente + " ha sido eliminado";
        } else {
            return "No se existe ningun cliente con el id ingresado " + cliente;
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
    public String actualizarCuenta(cliente cliente1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Clientes SET"+
              "fecha_ingreso='"+cliente1.fecha_ingreso+"',"+"estado='"+cliente1.estado+"',"+"calificacion='"+"id_persona='"+cliente1.id_persona+"' WHERE cliente1.id_cliente="+cliente1.id_cliente);
            conexion.conexionDB().close();
            return "Los datos han sido actualizados";
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<cliente> consultaACliente() throws SQLException {
    List<cliente> cliente0 = new ArrayList<>();
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM Clientes"));
        while (conexion.getResultadoQuery().next()) {
            cliente cliente1 = new cliente();
            cliente1.fecha_ingreso = conexion.getResultadoQuery().getDate("fecha_ingreso");
            cliente1.estado = conexion.getResultadoQuery().getString("estado");
            cliente1.calificacion = conexion.getResultadoQuery().getString("calificacion");
            cliente1.id_persona = conexion.getResultadoQuery().getInt("id_persona");
            cliente1.id_cliente = conexion.getResultadoQuery().getInt("id_cliente");
            cliente.add(cliente1);
        }
    }
    catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return cliente0;
} 
}

      
        
    


