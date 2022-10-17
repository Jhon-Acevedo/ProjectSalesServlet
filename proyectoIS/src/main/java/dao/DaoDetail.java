package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Detail;

public class DaoDetail {
	
	public ArrayList<Detail> uploadArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Detail> listString = new ArrayList<>();
        String result = "";
        Statement stmt= null;
        String query = "SELECT * FROM detail";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://"+ DaoUtilities.maquina+":"+DaoUtilities.puerto +"/shop",DaoUtilities.usuario,DaoUtilities.clave);
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res != null) {
                while (res.next()) {
                    //obtener todos los atributos
                    int id = res.getInt("id");
                    int idProduct = res.getInt("idProduct");
                    int quantity = res.getInt("quantity");
                    int price = res.getInt("cost");
                    int idBill = res.getInt("idBill");
                    //crear objeto
                    Detail detail = new Detail(id, idProduct, idBill, quantity, price);
                    //agregar objeto a la lista
                    listString.add(detail);
                    System.out.println(result);
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
	
	public boolean findDetail(int id) throws SQLException {
        Statement stmt= null;
		String query1 = "SELECT * FROM detail WHERE id = " + id;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://"+ DaoUtilities.maquina+":"+DaoUtilities.puerto +"/shop",DaoUtilities.usuario,DaoUtilities.clave);
	        stmt = con.createStatement();
	        ResultSet res = stmt.executeQuery(query1);
	        
	        if (res != null) {
                while (res.next()) {
                    //obtener todos los atributos
        	        System.out.println("res:" + res.getInt("id"));
        	        return true;
                }
            } else {
                System.out.println( "No se encontraron resultados de la consulta");
            }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}

	public void saveDetail(int id, int idProduct, int quantity, int cost, int idBill) throws SQLException, ClassNotFoundException{
		 Statement stmt= null;
		if(!findDetail(id)) {

			String query = "insert into detail (id, idProduct, quantity, cost, idBill) values('"+id+"','"+idProduct+"','"+quantity+"', '"+cost+"', '"+idBill+"');";
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://"+ DaoUtilities.maquina+":"+DaoUtilities.puerto +"/shop",DaoUtilities.usuario,DaoUtilities.clave);
				stmt = con.createStatement();
				stmt.executeUpdate(query);
				con.close();
			}catch(SQLException sqlex){throw sqlex;}
		}
	}

}
