package coen352.A1;

public class LLDictionary<Key, E> implements ADTDictionary<Key, E> {
	
	private static final int defaultSize = 100;
	private LList<Key> keys;
	private LList<E> values;
	
	LLDictionary() {
		keys = new LList<Key>();
		values = new LList<E>();
	}
	
	LLDictionary(int size)	{
		keys = new LList<Key>(size);
		values = new LList<E>(size);
	}
	
	public void clear() {
		keys.clear();
		values.clear();
	}
	
	public E find(Key k) {
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
	
	public void insert(Key k,E e) {
		if(find(k) == null)
		{
			keys.append(k);
			values.append(e);
		}
	}
	
	public E remove(Key k) {
		if (find(k) == null)
			return null;
		E temp = find(k);
		Key temp2 = keys.remove();
		return temp;
		
	}
	
	public E removeAny() 
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
	
}
