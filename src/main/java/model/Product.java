package model;

public class Product {
	
	private int id;
	private String name;
	private String presentation;
	private int cost;
	private int stock;
	
	public Product(int id, String name, String presentation, int cost, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.presentation = presentation;
		this.cost = cost;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
