
package modelo;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isai
 */
public class ProductoDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar(){
        List<Producto>datos=new ArrayList<>();
        String sql ="SELECT * FROM producto";
        try {
            con= conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setPosicion(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setComparador(rs.getInt(4));
                datos.add(p);
            }
        } catch (SQLException e) {
        }
        return datos;
    }
    
    public int agregar(Producto p){
        String sql = "INSERT INTO producto (marca,valor,mejor) VALUES (?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getMarca());
            ps.setInt(2, p.getPrecio());
            ps.setInt(3,p.getComparador());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }
}
