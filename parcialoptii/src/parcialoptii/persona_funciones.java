/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialoptii;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Monse
 */
public class persona_funciones {
        private Conexiones conexion;
    public persona_funciones(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }
    public String registrarPersona(persona persona1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO Personas(" +
                    "id_ciudad,"+"nombre,"+"apellido,"+"tipo_documento,"+"nro_documento,"+"direccion,"+"celular,"+"email,"+"estado)"+
                    "values('" +
                    persona1.id_ciudad+"','"+persona1.nombre+"','"+persona1.apellido+"','"+persona1.tipo_documento+"','"+persona1.nro_documento+"','"+
                    persona1.direccion+"','"+persona1.celular+"','"+persona1.email+"','"+persona1.estado+"')");
            conexion.conexionDB().close();
            return "La persona ingresada" + persona1.nombre + " ha sido registrada";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String actualizarPersona(persona persona1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Personas SET " +
                    "nombre='"+persona1.nombre+"',"+"apellido='"+persona1.apellido+"',"+"tipo_documento='"+persona1.tipo_documento+"',"+"nro_documento='"+persona1.nro_documento+"',"+
                    "direccion='"+persona1.direccion+"',"+"celular='"+persona1.celular+"',"+"email='"+persona1.email+"',"+"estado='"+persona1.estado+"'WHERE Personas.id_persona="+persona1.id_persona);
            conexion.conexionDB().close();
            return "Los datos de la persona"+persona1.nombre+"han sido actualizados";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String eliminarPersona(int persona) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM Personas WHERE id_persona = " + persona);
        conexion.conexionDB().close();
        if (rowCount > 0) {
            return "La persona con el id ingresado"+persona+"ha sido eliminada";
        } else {
            return "No existe ninguna persona con el id ingresado "+persona+"";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
    public List<persona> consultarPersonas() {
    List<persona> persona0 = new ArrayList<>();
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM Personas"));
        while (conexion.getResultadoQuery().next()) {
            persona persona1 = new persona();
            persona1.id_persona=conexion.getResultadoQuery().getInt("id_persona");
            persona1.id_ciudad=conexion.getResultadoQuery().getInt("id_ciudad");
            persona1.nombre = conexion.getResultadoQuery().getString("nombre");
            persona1.apellido = conexion.getResultadoQuery().getString("apellido");
            persona1.tipo_documento = conexion.getResultadoQuery().getString("tipo_documento");
            persona1.nro_documento = conexion.getResultadoQuery().getString("nro_documento");
            persona1.direccion = conexion.getResultadoQuery().getString("direccion");
            persona1.celular = conexion.getResultadoQuery().getString("celular");
            persona1.email = conexion.getResultadoQuery().getString("email");
            persona1.estado = conexion.getResultadoQuery().getString("estado");
            persona0.add(persona1);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return persona0;
}   
}
   

