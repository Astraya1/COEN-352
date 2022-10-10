package coen352.A1;

public class driver {
	public static void main(String[] args) {
		LLDictionary<Integer, String> mydict = new LLDictionary<Integer, String>();
		mydict.insert(3, "Bob");
		mydict.insert(4, "Brianne");
		mydict.insert(8, "David");
		System.out.println(mydict.size());
		System.out.println(mydict.find(8));
	}
}