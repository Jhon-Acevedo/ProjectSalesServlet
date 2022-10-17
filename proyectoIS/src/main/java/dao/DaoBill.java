package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bill;

public class DaoBill {
	
	public ArrayList<Bill> uploadArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Bill> listString = new ArrayList<>();
        String result = "";
        Statement stmt= null;
        String query = "SELECT * FROM bill";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://"+ DaoUtilities.maquina+":"+DaoUtilities.puerto +"/shop",DaoUtilities.usuario,DaoUtilities.clave);
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res != null) {
                while (res.next()) {
                    //obtener todos los atributos
                    int id = res.getInt("id");
                    int idClient = res.getInt("idClient");
                    //crear objeto
                    Bill bill = new Bill(id, idClient);
                    //agregar objeto a la lista
                    listString.add(bill);
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
	
	public boolean findBill(int id) throws SQLException {
        Statement stmt= null;
		String query1 = "SELECT * FROM bill WHERE id = " + id;
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

	public void saveBill(int id, int idClient) throws SQLException, ClassNotFoundException{
        Statement stmt= null;
       
        if(!findBill(id)) {
        	String query2 = "insert into bill (id, idClient) values('"+id+"','"+idClient+"');";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://"+ DaoUtilities.maquina+":"+DaoUtilities.puerto +"/shop",DaoUtilities.usuario,DaoUtilities.clave);
                stmt = con.createStatement();
                stmt.executeUpdate(query2);
                con.close();
            }catch(SQLException sqlex){throw sqlex;}
        }
        
    }
	
}
