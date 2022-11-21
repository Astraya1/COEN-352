package coen352.A1;

public class DLDictionary<Key, E> implements ADTDictionary<Key, E> {
	private static final int defaultSize = 100;
	private DList<Key> keys;
	private DList<Inventory> values;
	
	DLDictionary() {
		keys = new DList<Key>();
		values = new DList<Inventory>();
	}
	
	DLDictionary(int size)	{
		keys = new DList<Key>(size);
		values = new DList<Inventory>(size);
	}
	
	public DList<Key> getkeys() {
		return keys;
	}
	
	public void clear() {
		keys.clear();
		values.clear();
	}
	
	public Inventory find(Key k) {
		for (int i=0; i<keys.length(); i++) {
			keys.moveToPos(i);
			if (k == keys.getValue()) {
				values.moveToPos(i);
				return values.getValue();
			}
		}
		return null;		
	}
	
	public int size() {
		return keys.length();
	}
	
	public void insert(Key k,Inventory e) {
		if(find(k) == null)
		{
			keys.append(k);
			values.append(e);
		}
	}
	
	public Inventory remove(Key k) {
		if (find(k) == null)
			return null;
		Inventory temp = find(k);
		keys.remove();
		return temp;
		
	}
	
	public Inventory removeAny() 
	{
		if (size() != 0)
		{
			keys.remove();
			return values.remove();
		}
		else
			return null;
	}
	
	public String toString()
	{
		StringBuffer output = new StringBuffer();
		if (values.length() != keys.length())
			return "The dictionary is inconsistent.";
		for (int i=0; i<keys.length(); i++)
		{
			keys.moveToPos(i);
			output.append(keys.getValue().toString());
			output.append(" - ");
			values.moveToPos(i);
			output.append(values.getValue().toString());
			output.append("; ");
		}
		
		return output.toString().trim();
	}
	
	public <F> F[] createIndex(String attribute) //Question 1.1
	//Need to create a new generic type F in order to have variable return type, since type conflict arises if using generic type E.
	{

		if (attribute == "quantity")
		{
			
			Integer[] arr1 = new Integer[values.length()];
			for (int i=0; i<values.length(); i++)
			{
				values.moveToPos(i);
				arr1[i] = values.getValue().getquantity();
			}
			QuickSort.sort(arr1);
			return (F[])(arr1);
		}
		
		else if (attribute == "reorderqty")
		{
			
			Integer[] arr2 = new Integer[values.length()];
			for (int i=0; i<values.length(); i++)
			{
				values.moveToPos(i);
				arr2[i] = values.getValue().getreorderqty();
			}
			QuickSort.sort(arr2);
			return (F[])(arr2);
		}
		
		else if (attribute == "cost")
		{
		
			Double[] arr3 = new Double[values.length()];
			for (int i=0; i<values.length(); i++)
			{
				values.moveToPos(i);
				arr3[i] = values.getValue().getcost();
			}
			QuickSort.sort(arr3);
			return (F[])(arr3);
		}
		
		else if (attribute == "inventoryval")
		{
			
			Double[] arr4 = new Double[values.length()];
			for (int i=0; i<values.length(); i++)
			{
				values.moveToPos(i);
				arr4[i] = values.getValue().getinventoryval();
			}
			QuickSort.sort(arr4);
			return (F[])(arr4);
		}
			
		
		return null;
		
	}
	
	public <F extends Comparable<? super F>> BSTDictionary<F, String> BSTIndex(String attribute) //Question 1.2
	//Building an index as a binary search tree using BSTDictionary class due to being unable to build the index as a single BSTNode.
	{
		BSTDictionary<F, String> myBST = new BSTDictionary<F, String>();
		
		if (attribute == "quantity")
		{
			for (int i=0; i<values.length(); i++)
			{
				keys.moveToPos(i);
				values.moveToPos(i);
				String sku = (String)(keys.getValue());
				F val = (F)(Integer)(values.getValue().getquantity());
				myBST.insert(val, sku);
			}
		}
		else if (attribute == "reorderqty")
		{
			for (int i=0; i<values.length(); i++)
			{
				keys.moveToPos(i);
				values.moveToPos(i);
				String sku = (String)(keys.getValue());
				F val = (F)(Integer)(values.getValue().getreorderqty());
				myBST.insert(val, sku);
			}
		}
		else if (attribute == "cost")
		{
			for (int i=0; i<values.length(); i++)
			{
				keys.moveToPos(i);
				values.moveToPos(i);
				String sku = (String)(keys.getValue());
				F val = (F)(Double)(values.getValue().getcost());
				myBST.insert(val, sku);
			}
		}	
		else if (attribute == "inventoryval")
		{
			for (int i=0; i<values.length(); i++)
			{
				keys.moveToPos(i);
				values.moveToPos(i);
				String sku = (String)(keys.getValue());
				F val = (F)(Double)(values.getValue().getinventoryval());
				myBST.insert(val, sku);
			}
		}
		
		return myBST;
	}
}

