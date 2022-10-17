package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Client;

public class DaoClient {
	
	public ArrayList<Client> uploadArrayList() throws SQLException, ClassNotFoundException {
        ArrayList<Client> listString = new ArrayList<>();
        String result = "";
        Statement stmt= null;
        String query = "SELECT * FROM client";
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
                    String lastname = res.getString("lastname");
                    String phone = res.getString("phone");
                    String address = res.getString("address");
                    String user = res.getString("user");
                    String password = res.getString("password");
                    //crear objeto
                    Client client = new Client(id, name, lastname, phone, address, user, password);
                    //agregar objeto a la lista
                    listString.add(client);
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
}
