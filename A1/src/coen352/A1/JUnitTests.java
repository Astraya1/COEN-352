package coen352.A1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class JUnitTests {
	
	private static DLDictionary<String, Inventory> dict; //BSTDictionary for quantity/reorderqty
	WarehouseInventory myWH = new WarehouseInventory();
	String sku1 = "SP7875";
	String sku2 = "TR87680";
	String sku3 = "MK676554";
	String sku4 = "PW98762";
	String sku5 = "WT98768";
	String sku6 = "WDG123";
	Inventory inv1 = new Inventory("Item 1", "T345", "Row 2, slot 1", "Each", 8, 10, 30.00, 600.00, false);
	Inventory inv2 = new Inventory("Item 2", "T345", "Row 2, slot 1", "Each", 5, 15, 40.00, 1200.00, false);
	Inventory inv3 = new Inventory("Item 3", "T5789", "Row 1, slot 1", "Each", 10, 5, 5.00, 50.00, false);
	Inventory inv4 = new Inventory("Item 6", "T345", "Row 2, slot 1", "Each", 7, 10, 50.00, 350.00, true);
	Inventory inv5 = new Inventory("Item 9", "T9875", "Row 2, slot 2", "Package (5 ct)", 20, 30, 14.00, 280.00, true);
	Inventory inv6 = new Inventory("Item 11", "T349", "Row 1, slot 2", "Each", 25, 15, 8.00, 200.00, false);
	
	
	
	@BeforeEach
	void init() {
		
		  dict = new DLDictionary<String, Inventory>();
	}

		  @Test
		  //Testing createIndex method with attribute = reorderqty
		  public void testCreateIndexReorderqty() {
				
			  	dict.insert(sku1, inv1);
			  	dict.insert(sku2, inv2);
				dict.insert(sku3, inv3);
				dict.insert(sku4, inv4);
				dict.insert(sku5, inv5);
				dict.insert(sku6, inv6);
				
				Integer[] arr = dict.createIndex("reorderqty");
				String out =  new String();
				
				for (int i=0; i<6; i++)
				{
					out = out + arr[i].toString() + " ";
				}
				
				assertEquals(out, "5 10 10 15 15 30 ");
				
		  }
		  
		  @Test
		  //Testing createIndex method with attribute = inventoryval
		  public void testCreateIndexInventoryval() {
				
			  	dict.insert(sku1, inv1);
			  	dict.insert(sku2, inv2);
				dict.insert(sku3, inv3);
				dict.insert(sku4, inv4);
				dict.insert(sku5, inv5);
				dict.insert(sku6, inv6);
				
				Double[] arr = dict.createIndex("inventoryval");
				String out =  new String();
				
				for (int i=0; i<6; i++)
				{
					out = out + arr[i].toString() + " ";
				}
				
				assertEquals(out, "50.0 200.0 280.0 350.0 600.0 1200.0 ");
				
		  }
		  
		  @Test
		  //Testing BSTIndex method with attribute = quantity
		  public void testInOrderTraverseQty() { 
				  
			  	dict.insert(sku1, inv1);
			  	dict.insert(sku2, inv2);
				dict.insert(sku3, inv3);
				dict.insert(sku4, inv4);
				dict.insert(sku5, inv5);
				dict.insert(sku6, inv6);
				
				BSTDictionary<Integer, String> myBST = dict.BSTIndex("quantity");
				BSTTraverse.clear();
				BSTTraverse.depthFirstTraverse(myBST.getRoot());
			  
				assertEquals(BSTTraverse.print(), "TR87680 PW98762 SP7875 MK676554 WT98768 WDG123 ");
		  }
		  
		  @Test
		  //Testing BSTIndex method with attribute = cost
		  public void testInOrderTraverseCost()	{
			  
				dict.insert(sku1, inv1);
				dict.insert(sku2, inv2);
				dict.insert(sku3, inv3);
				dict.insert(sku4, inv4);
				dict.insert(sku5, inv5);
				dict.insert(sku6, inv6);
				
				BSTDictionary<Double, String> myBST = dict.BSTIndex("cost");
				BSTTraverse.clear();
				BSTTraverse.depthFirstTraverse(myBST.getRoot());
				
				assertEquals(BSTTraverse.print(), " MK676554 WDG123 WT98768 SP7875 TR87680 PW98762 ");
		  }
		  
		  @Test
		  //Testing query method with attribute = cost
		  public void testQueryCost() {
			  	
				myWH.insert(sku1, inv1);
				myWH.insert(sku2, inv2);
				myWH.insert(sku3, inv3);
				myWH.insert(sku4, inv4);
				myWH.insert(sku5, inv5);
				myWH.insert(sku6, inv6);
							  
				assertEquals(myWH.query("cost", 0.73), "40.0");
			  
		  }

		  @Test
		  //Testing query method with attribute = quantity
		  public void testQueryQuantity() {
			  	myWH.insert(sku1, inv1);
				myWH.insert(sku2, inv2);
				myWH.insert(sku3, inv3);
				myWH.insert(sku4, inv4);
				myWH.insert(sku5, inv5);
				myWH.insert(sku6, inv6);
				
				assertEquals(myWH.query("quantity", 0.45), "8");
		  }
	  
	
}
