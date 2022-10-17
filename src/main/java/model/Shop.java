package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoBill;
import dao.DaoClient;
import dao.DaoDetail;
import dao.DaoProduct;

public class Shop {

	private ArrayList<Product> products;
	private ArrayList<Client> clients;
	
	private ArrayList<Detail> details;
	private ArrayList<Bill> bills;
	
	private int idClient;
	public static int idBill;
	
	DaoClient daoClient = new DaoClient();
	DaoProduct daoProduct = new DaoProduct();
	DaoBill daoBill = new DaoBill();
	DaoDetail daoDetail = new DaoDetail();
	
	public Shop() {
		products = new ArrayList<Product>();
		clients = new ArrayList<Client>();
		updateList();
	}
	
	public void updateList() {
		try {
			details = daoDetail.uploadArrayList();
			bills = daoBill.uploadArrayList();
			clients = daoClient.uploadArrayList();
			products = daoProduct.uploadArrayList();
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public int getIdBill() {
		return idBill;
	}
	
	public int getIdClient() {
		return idClient;
	}

	public ArrayList<Product> getProducts() {
		ArrayList<Product> listProducts = new ArrayList<Product>();
		for (Product product : products) {
			if (product.getStock() > 4) {
				listProducts.add(product);
			}
		}
		return listProducts;
	}
	
	public ArrayList<Detail> getShoppingCar() {
		return details;
	}
	
	public ArrayList<Bill> getBills() {
		return bills;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}
	
	public boolean verifyClient(String user, String password) {
		for (Client client : clients) {
			if(client.verifyClient(user, password)){
				this.idClient = client.getId();
				return true;
			}
		}
		return false;
	}
	
	public int generateIdDetail() {
		return details.size();
	}
	
	public int generateIdBill() {
		idBill = bills.size();
		bills.size();
		return idBill;
	}
	
	public String[] getInfoClient() {
		String[] info = new String[3];
		for (Client client : clients) {
			if(idClient == client.getId()) {
				info[0] = client.getName();
				info[1] = client.getLastName();
				info[2] = client.getAddress(); 
			}
		}
		return info;
	}
	
	public ArrayList<Detail> getDetailsPurchase(){
		ArrayList<Detail> detailsPurchase = new ArrayList<>();
		for (Detail detail : details) {
			if(detail.getIdBill() == idBill) {
				detailsPurchase.add(detail);
			}
		}
		
		return detailsPurchase;
	}
	
	public Product productPurchase(int idProduct) {
		for (Product product : products) {
			if(idProduct == product.getId())
				return product;
		}
		return null;
	}
	
	public double getSubtotal() {
		System.out.println(idBill);
		for (Bill bill : bills) {
			if(idBill == bill.getId()) {
				return bill.getSubtotal();
			}
		}
		return 0;
	}
	
	public double getTotal() {
		for (Bill bill : bills) {
			if(idBill == bill.getId()) {
				return bill.getTotal();
			}
		}
		return 0;
	}
	
	public void updateProduct() {
		try {
			for (Product product : products) {
				daoProduct.actualizarProducto(product.getId(), product.getStock());
			}
			for (Bill bill : bills) {
				System.out.println("idbill: " + bill.getId());
				daoBill.saveBill(bill.getId(), bill.getIdClient());
			}
			for (Detail detail : details) {
				daoDetail.saveDetail(detail.getId(), detail.getIdProduct(), detail.getQuantity(), detail.getPrice(), detail.getIdBill());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
