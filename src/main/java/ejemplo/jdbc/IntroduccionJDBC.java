package ejemplo.jdbc;

import java.sql.*;

public class IntroduccionJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://10.3.1.100:3306/test";
        try{
            Connection conexion = DriverManager.getConnection(url, "root", "Sengul23Yellow!");
            Statement instruccion = conexion.createStatement();
            String sql = "select id_persona, nombre, apellido, email, telefono from persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("Id Persona: " + resultado.getInt(1));
                System.out.print("Nombre: " + resultado.getString(2));
                System.out.print("Apellido: " + resultado.getString(3));
                System.out.print("Email: " + resultado.getString(4));
                System.out.println("Telefono: " + resultado.getString(5));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
