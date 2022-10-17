package model;

import java.util.ArrayList;

public class Bill {

	private int id;
	private int idClient;
	private double subtotal, total;
	
	
	public Bill(int id, int idClient) {
		super();
		this.id = id;
		this.idClient = idClient;
	}
	
	public int getId() {
		return id;
	}
	
	public int getIdClient() {
		return idClient;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void calculateSubtotal(ArrayList<Detail> details) {
		for (Detail detail : details) {
			if(detail.getIdBill() == id) {
				subtotal += detail.calculateSubtotal();
			}
		}
		System.out.println(subtotal);
	}
	
	public void calculateTotal() {
		total = (subtotal * 0.19) + subtotal;
		System.out.println(total);
	}
}
