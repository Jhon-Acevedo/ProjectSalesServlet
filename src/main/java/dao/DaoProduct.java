package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;

public class DaoProduct {
	
	public ArrayList<Product> uploadArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Product> listString = new ArrayList<Product>();
        Statement stmt= null;
        String query = "SELECT * FROM product";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://"+ DaoUtilities.maquina+":"+DaoUtilities.puerto +"/shop",DaoUtilities.usuario,DaoUtilities.clave);
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res != null) {
                while (res.next()) {
                    //obtener todos los atributos
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String presentation = res.getString("presentation");
                    int cost = res.getInt("cost");
                    int stock = res.getInt("stock");
                    //crear objeto
                    Product product = new Product(id, name, presentation, cost, stock);
                    //agregar objeto a la lista
                    listString.add(product);
                }
            } else {
                System.out.println( "No se encontraron resultados de la consulta");
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL Exeption: " + query + " en " + ex);
        }
        return listString;
    }
	
	public void actualizarProducto(int id, int stock) throws SQLException, ClassNotFoundException{
        Statement stmt= null;
        String query = "update product set stock="+stock+" where id="+id+";";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://"+ DaoUtilities.maquina+":"+DaoUtilities.puerto +"/shop",DaoUtilities.usuario,DaoUtilities.clave);
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.close();
        }catch(SQLException sqlex){throw sqlex;}
    }
}
