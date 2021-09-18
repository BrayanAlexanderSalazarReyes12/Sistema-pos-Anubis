/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import Pantalla.de.login.anubis.login_anubis;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import pantallas.de.menu.anubis.inicio;

/**
 *
 * @author braya
 */
public class iniciar_sesion {
    private String usuario;
    private String contraseña;

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public void conexion(JFrame cerraventana) throws SQLException{
        conexion.bd cbd = new bd();
        cbd.setServidor("jdbc:mysql://localhost/sistema_pos_anubis");
        cbd.setUsuario("root");
        cbd.setContrasena("");
        Connection con = cbd.getConexion();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM usuarios WHERE usuario = '"+usuario+"' AND contrasena = '"+contraseña+"'");
        if(rs.next()){
            cerraventana.dispose();
            pantallas.de.menu.anubis.inicio inicio = new inicio();
            inicio.setVisible(true);   
        }
    }
}
