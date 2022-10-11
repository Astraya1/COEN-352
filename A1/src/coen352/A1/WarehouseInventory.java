package coen352.A1;

public class WarehouseInventory<Key, E> {
	private static final int defaultSize = 100;
	private DList<Key> sku;
	private DList<E> values;
	
	WarehouseInventory()
	{
		sku = new DList<Key>();
		values = new DList<E>();
	}
	
	WarehouseInventory(int size)
	{
		keys = new DList<Key>(size);
		values = new DList<E>(size)
	}
	
	public void clear()
	{
		sku.clear();
		values.clear();
	}
	
	public E find(Key k)
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
	
	public int size()
	{
		return sku.length();
	}
	
	public void insert(Key k, E e)
	{
		if(find(k) == null)
		{
			sku.append(k);
			values.append(e);
		}
	}
	
	public E remove(Key k)
	{
		if (find(k) == null)
			return null;
		E temp = find(k);
		Key temp2 = sku.remove();
		return temp;
		
	}
}
