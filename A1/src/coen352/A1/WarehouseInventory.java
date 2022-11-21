package coen352.A1;

public class WarehouseInventory {

	private DLDictionary<String, Inventory> warehouse;
	
	WarehouseInventory()
	{
		warehouse = new DLDictionary<String, Inventory>();
	}
	
	WarehouseInventory(int size)
	{
		warehouse = new DLDictionary<String, Inventory>(size);
	}
	
	public void clear()
	{
		warehouse.clear();
	}
	
	public Inventory find(String k)
	{
		return warehouse.find(k);
	}
	
	public void insert(String k, Inventory e)
	{
		warehouse.insert(k, e);
	}
	
	public Inventory remove(String k)
	{
		return warehouse.remove(k);
		
	}
	
	public Inventory removeAny()
	{
		return warehouse.removeAny();
	}
	
	public int size()
	{
		return warehouse.size();
	}
	
	public double totalvalue()
	{
		double sum = 0;
		DList<String> skus = warehouse.getkeys();
		
		for (int i=0; i<skus.length(); i++)
		{
			skus.moveToPos(i);
			sum = sum + warehouse.find(skus.getValue()).getinventoryval();
		}
		
		return sum;
	}
		
	public String query(String attribute, double perct) //Question 2
	//I made the return type String instead of void so I can test it using JUnit 5.
	{
		if (perct >= 1)
		{
			System.out.println("Error: perct must be less than 1");
			return null;
		}
		
		Integer[] arrInt = new Integer[warehouse.size()];
		Double[] arrDouble = new Double[warehouse.size()];
		
		if (attribute == "quantity")
		{
			arrInt = warehouse.createIndex("quantity");
			int pivot = (int)(warehouse.size() * perct);
			System.out.println(arrInt[pivot]);
			return arrInt[pivot].toString();
		}
		
		else if (attribute == "reorderqty")
		{
			arrInt = warehouse.createIndex("reorderqty");
			int pivot = (int)(warehouse.size() * perct);
			System.out.print(arrInt[pivot]);
			return arrInt[pivot].toString();
		}
		
		else if (attribute == "cost")
		{
			arrDouble = warehouse.createIndex("cost");
			int pivot = (int)(warehouse.size() * perct);
			System.out.println(arrDouble[pivot]);
			return arrDouble[pivot].toString();
		}
		
		else if (attribute == "inventoryval")
		{
			arrDouble = warehouse.createIndex("inventoryval");
			int pivot = (int)(warehouse.size() * perct);
			System.out.println(arrDouble[pivot]);
			return arrDouble[pivot].toString();
		}
		
		return null;
	}

}