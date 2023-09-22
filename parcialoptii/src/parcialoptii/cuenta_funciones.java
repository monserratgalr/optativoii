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
public class cuenta_funciones {
    private Conexiones conexion;
    public cuenta_funciones(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }
    public String registrodeCuenta(cuenta cuenta1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO Cuentas(" +
                    "nro_cuenta,"+"fecha_alta,"+"tipo_cuenta,"+"estado,"+"saldo,"+"nro_contrato,"+"promedio_acreditacion,"+"moneda,"+"costo_mantenimiento,"+"id_cliente)"+
                    "values('"+cuenta1.id_cliente+"','"+cuenta1.nro_cuenta+"','"+cuenta1.fecha_alta+cuenta1.tipo_cuenta+cuenta1.estado+cuenta1.saldo+cuenta1.nro_contrato+cuenta1.promedio_acreditacion+cuenta1.moneda+cuenta1.costo_mantenimiento+"')");
            conexion.conexionDB().close();
            return "La cuenta ha sido registrada exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String actualizarCuenta(cuenta cuenta1){
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Cuentas SET"+
                    "nro_cuenta='"+cuenta1.nro_cuenta+"',"+"fecha_alta='"+cuenta1.fecha_alta+"',"+"tipo_cuenta='"+cuenta1.tipo_cuenta+"estado='"+cuenta1.estado+"saldo='"+cuenta1.saldo+"nro_contrato='"+cuenta1.nro_contrato+"promedio_acreditacion='"+cuenta1.promedio_acreditacion+
                    "moneda='"+cuenta1.moneda+"costo_mantenimiento='"+cuenta1.costo_mantenimiento+"id_cliente='"+cuenta1.costo_mantenimiento+
                    "'WHERE cuenta.id_cuenta="+cuenta1.id_cuenta);
            conexion.conexionDB().close();
            return "Los datos de la cuenta han sido actualizados";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String eliminarCuenta(int cuenta) {
    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM Cuentas WHERE id_cuenta="+cuenta);
        conexion.conexionDB().close();
        if (rowCount > 0) {
            return "La cuenta con el id ingresado"+cuenta+"ha sido eliminada";
        } else {
            return "No existe ninguna cuenta con el id ingresado "+cuenta+"";
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public List<cuenta> consultadeCuenta() {
    List<cuenta> cuenta0 = new ArrayList<>();

    try {
        conexion.setQuerySQL(conexion.conexionDB().createStatement());
        conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM Cuentas"));
        while (conexion.getResultadoQuery().next()) {
            cuenta cuenta1 = new cuenta();
            cuenta1.nro_cuenta = conexion.getResultadoQuery().getString("nro_cuenta");
            cuenta1.fecha_alta = conexion.getResultadoQuery().getDate("fecha_alta");
            cuenta1.tipo_cuenta = conexion.getResultadoQuery().getString("tipo_cuenta");
            cuenta1.estado = conexion.getResultadoQuery().getString("estado");
            cuenta1.saldo = conexion.getResultadoQuery().getFloat("saldo");
            cuenta1.nro_contrato = conexion.getResultadoQuery().getString("nro_contrato");
            cuenta1.promedio_acreditacion=conexion.getResultadoQuery().getString("promedio_acreditacion");
            cuenta1.moneda = conexion.getResultadoQuery().getString("moneda");
            cuenta1.costo_mantenimiento=conexion.getResultadoQuery().getFloat("costo_mantenimiento");
            cuenta1.id_cliente=conexion.getResultadoQuery().getInt("id_cliente");
            cuenta1.id_cuenta=conexion.getResultadoQuery().getInt("id_cuenta");

            cuenta.add(cuenta0);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return cuenta0;
}  
}   

