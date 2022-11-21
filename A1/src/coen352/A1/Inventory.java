package coen352.A1;

class Inventory 
{
	private String description;
	private String bin;
	private String location;
	private String unit;
	private int quantity;
	private int reorderqty;
	private double cost;
	private double inventoryval;
	private boolean reorder;
	
	Inventory()
	{
		description = "";
		bin = "";
		location = "";
		unit = "";
		quantity = 0;
		reorderqty = 0;
		cost = 0;
		inventoryval = 0;
		reorder = false;
	}
	
	Inventory(String b, String c, String d, String e, int f, int g, double h, double i, boolean j)
	{
		description = b;
		bin = c;
		location = d;
		unit = e;
		quantity = f;
		reorderqty = g;
		cost = h;
		inventoryval = i;
		reorder = j;
	}
	
	public String getdescription()
	{
		return description;
	}
	
	public String getbin()
	{
		return bin;
	}
	
	public String getlocation()
	{
		return location;
	}
	
	public String getunit()
	{
		return unit;
	}
	
	public int getquantity()
	{
		return quantity;
	}
	
	public int getreorderqty()
	{
		return reorderqty;
	}
	
	public double getcost()
	{
		return cost;
	}
	
	public double getinventoryval()
	{
		return inventoryval;
	}
	
	public boolean getreorder()
	{
		return reorder;
	}
}
