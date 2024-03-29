package coen352.A1;

class BSTTraverse {
	
	
	static private StringBuffer out = new StringBuffer();
	
	static void clear() {
		if(out.length() > 0)
			out.delete(0, out.length()-1);
	}
	// Stick this in to test the preorder routine
	static void visit (BinNode X) 
	{
	  out.append(X.element());
	  out.append(" ");
	}
	
	public static void depthFirstTraverse(BinNode rt) // rt is the root of the subtree
	{
	  if (rt == null) 
		  return; // Empty subtree
	  
	  depthFirstTraverse(rt.left());
	  visit(rt);
	  depthFirstTraverse(rt.right());
	}
	
	public static void breathFirstTraverse(BinNode rt)
	{
	  
	  visit(rt);
	  if (rt.left() != null) 
		  depthFirstTraverse(rt.left());
	  if (rt.right() != null) 
		  depthFirstTraverse(rt.right());
	}
	
	static int count(BinNode rt) {
	  if (rt == null) 
		  return 0;  // Nothing to count
	  return 1 + count(rt.left()) + count(rt.right());
	}
	
	
	static boolean checkBST(BSTNode root,
	                 Integer low, Integer high) 
	{
	  if (root == null) 
		  return true; // Empty subtree
	  Integer rootkey = (Integer) root.key();
	  
	  if ((rootkey < low) || (rootkey > high))
	    return false; // Out of range
	  
	  if (!checkBST(root.left(), low, rootkey))
	    return false; // Left side failed
	  
	  return checkBST(root.right(), rootkey, high);
	}
	
	public static String print() {
		return out.toString();
	}
	
	
	

	
}
