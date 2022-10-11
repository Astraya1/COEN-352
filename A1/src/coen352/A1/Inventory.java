package coen352.A1;

class Inventory 
{
	private String sku;
	private String description;
	private String bin;
	private String location;
	private String unit;
	private int quantity;
	private int reorderqty;
	private float cost;
	private float inventoryval;
	private boolean reorder;
	
	Inventory()
	{
		sku = "";
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
	
	Inventory(String a, String b, String c, String d, String e, int f, int g, float h, float i, bool j)
	{
		sku = a;
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
	
	public String getsku()
	{
		return sku;
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
	
	public float getcost()
	{
		return cost;
	}
	
	public float getinventoryval()
	{
		return inventoryval;
	}
	
	public boolean getreorder()
	{
		return reorder;
	}
	
	public String toString()
	{
		StringBuffer out = new StringBuffer();
		out.append(sku);
		out.append("; ");
		out.append(description);
		out.append("; ");
		out.append(bin);
		out.append("; ");
		out.append(location);
		out.append("; ");
		out.append(unit);
		out.append("; ");
		out.append(quantity);
		out.append("; ");
		out.append(reorderqty);
		out.append("; ");
		out.append(cost);
		out.append("; ");
		out.append(inventoryval);
		out.append("; ");
		out.append(reorder);
		
	}
}
