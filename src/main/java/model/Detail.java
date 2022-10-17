package model;

public class Detail {

	private int id, idProduct, idBill, quantity;
	private int price;
	
	public Detail(int id, int idProduct, int idBill, int quantity, int price) {
		super();
		this.id = id;
		this.idProduct = idProduct;
		this.idBill = idBill;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public int getIdBill() {
		return idBill;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}
	
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	
	public double calculateSubtotal() {
		return quantity * price;
	}
}
