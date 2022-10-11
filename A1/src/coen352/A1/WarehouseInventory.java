package coen352.A1;

public class WarehouseInventory {
	private static final int defaultSize = 100;
	private DList<String> sku;
	private DList<Inventory> values;
	
	WarehouseInventory()
	{
		sku = new DList<String>();
		values = new DList<Inventory>();
	}
	
	WarehouseInventory(int size)
	{
		sku = new DList<String>(size);
		values = new DList<Inventory>(size);
	}
	
	public void clear()
	{
		sku.clear();
		values.clear();
	}
	
	public Inventory find(String k)
	{
		for (int i=0; i<sku.length(); i++)
		{
			sku.moveToPos(i);
			if (k == sku.getValue())
			{
				values.moveToPos(i);
				return values.getValue();
			}
		}
		return null;
	}
	
	public void insert(String k, Inventory e)
	{
		if(find(k) == null)
		{
			sku.append(k);
			values.append(e);
		}
	}
	
	public Inventory remove(String k)
	{
		if (find(k) == null)
			return null;
		Inventory temp = find(k);
		String temp2 = sku.remove();
		return temp;
		
	}
	
	public Inventory removeAny()
	{
		if (size() != 0)
		{
			sku.remove();
			return values.remove();
		}
		else
			return null;
	}
	
	public int size()
	{
		return sku.length();
	}
	
	public float totalvalue()
	{
		float sum = 0;
		for (int i=0; i<sku.length(); i++)
		{
			values.moveToPos(i);
			sum += values.getValue().getinventoryval();
		}
		
		return sum;
	}
	
}