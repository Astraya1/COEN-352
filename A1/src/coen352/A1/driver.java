package coen352.A1;

public class driver {
	public static void main(String[] args) {
		DLDictionary<Integer, String> mydict = new DLDictionary<Integer, String>();
		mydict.insert(3, "Bob");
		mydict.insert(4, "Brianne");
		mydict.insert(8, "David");
		System.out.println(mydict.size());
		System.out.println(mydict.find(8));
		System.out.println(mydict.toString());
		System.out.println(mydict.remove(6));
	}
}