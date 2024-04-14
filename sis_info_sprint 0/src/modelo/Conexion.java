
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class Conexion{
    Connection con;

    public Connection getConnection(){
        
        String url =  "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres";
        String usuario = "postgres.rtumwxghmalkjqxfehwb";
        String pass = "sisinfo2Passw";

        //String driver = "com.mysql.cj.jdbc.Driver";

        try {
            con = DriverManager.getConnection(url, usuario, pass);
            if(con != null){
                System.out.println("base de datos conectada");
            }else{
                System.out.println("base de datos no conectada");
            }
            
        } catch (Exception e) {
        }
        return con;
    }
}
