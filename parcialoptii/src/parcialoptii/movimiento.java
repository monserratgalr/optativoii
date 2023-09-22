/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialoptii;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Monse
 */
public class movimiento {

    static void add(List<movimiento> movimiento0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Date fecha_movimiento;
    public String tipo_movimiento;
    public float saldo_anterior;
    public float saldo_actual;
    public float monto_movimiento;
    public float cuenta_origen;
    public float cuenta_destino;
    public float canal;
    public int id_cuenta;
    public int id_movimiento;
    
    public Date getFecha_movimiento(){
        return fecha_movimiento;
    }
    public void setFecha_movimiento(Date fecha_movimiento) {
	this.fecha_movimiento = fecha_movimiento;
	}
    public String getTipo_movimiento(){
        return tipo_movimiento;
    }
    public void setTipo_movimiento(String tipo_movimiento) {
	this.tipo_movimiento = tipo_movimiento;
	}
    public float getSaldo_interior(){
        return saldo_anterior;
    }
    public void setSaldo_anterior(float saldo_anterior) {
	this.saldo_anterior = saldo_anterior;
	}
    public float getSaldo_actual(){
        return saldo_actual;
    }
    public void setSaldo_actual(float saldo_actual) {
	this.saldo_actual = saldo_actual;
	}
    public float getMonto_movimiento(){
        return monto_movimiento;
    }
    public void setMOnto_movimiento(float monto_movimiento) {
	this.monto_movimiento = monto_movimiento;
	}
    public float getCuenta_origen(){
        return cuenta_origen;
    }
    public void setCuenta_origen(float cuenta_origen) {
	this.cuenta_origen = cuenta_origen;
	}
    public float getCuenta_destino(){
        return cuenta_destino;
    }
    public void setCuenta_destino(float cuenta_destino) {
	this.cuenta_destino = cuenta_destino;
	}
    public float getCanal(){
        return canal;
    }
    public void setCanal(float canal) {
	this.canal = canal;
	}
     public int getId_cuenta(){
        return id_cuenta;
    }
    public void setId_cuenta(int id_cuenta) {
	this.id_cuenta = id_cuenta;
	}
     public int getId_movimiento(){
        return id_movimiento;
    }
    public void setId_movimiento(int id_movimiento) {
	this.id_movimiento = id_movimiento;
	}
            

    
}
