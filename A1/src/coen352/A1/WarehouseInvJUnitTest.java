package coen352.A1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarehouseInvJUnitTest {
	
	private static WarehouseInventory dict;
	private static Inventory inv1;
	private static Inventory inv2;
	private static Inventory inv3;
	private static Inventory inv4;
	private static Inventory inv5;
	  
	@BeforeAll
	public static void setUp() {
		dict = new WarehouseInventory(11);
		//dict = new LLDictionary<String, InventoryRecord>(10);
		inv1 = new Inventory("SP7875", "Item 1", "T345", "Row 2, slot 1", "Each", 20, 10, 30.00, 600.00, false);
		inv2 = new Inventory("TR87680", "Item 2", "T345", "Row 2, slot 1", "Each", 20, 15, 40.00, 1200.00, false);
		inv3 = new Inventory("MK676554", "Item 3", "T5789", "Row 1, slot 1", "Each", 10, 5, 5.00, 50.00, false);
		inv4 = new Inventory("PW98762", "Item 6", "T345", "Row 2, slot 1", "Each", 7, 10, 50.00, 350.00, true);
		inv5 = new Inventory("WT98768", "Item 9", "T9875", "Row 2, slot 2", "Package (5 ct)", 20, 30, 14.00, 280.00, true);
		
	}

	@Test
	void testClear() {
		dict.clear();
		assertEquals(0, dict.size(), "clear failed, size is non zero");
	}

	@Test
	void testInsert() {
		dict.clear();
		dict.insert("SP7875", inv1);
		dict.insert("TR87680", inv2);
		dict.insert("MK676554", inv3);
		dict.insert("PW98762", inv4);
		dict.insert("WT98768", inv5);
		assertEquals(5, dict.size(), "insert failed, size is not as expected");
	}

	@Test
	void testRemove() {
		
		dict.clear();
		dict.insert("SP7875", inv1);
		dict.insert("TR87680", inv2);
		dict.insert("MK676554", inv3);
		dict.insert("PW98762", inv4);
		dict.insert("WT98768", inv5);
		
		//assertEquals("1:blue , 2:yellow , 3:grey ,", dict.toString());
		
		assertEquals(50.00, dict.remove("MK676554").getinventoryval(), "remove failed: return"); 
		assertEquals(4, dict.size(), "remove failed: size");
		
	}
		

	@Test
	void testFind() {
		
		dict.clear();
		dict.insert("SP7875", inv1);
		dict.insert("TR87680", inv2);
		dict.insert("MK676554", inv3);
		dict.insert("PW98762", inv4);
		
		assertEquals("PW98762", dict.find("PW98762").getsku(), "find failed"); 
	}

	@Test
	void testSize() {
		dict.clear();
		dict.insert("SP7875", inv1);
		dict.insert("TR87680", inv2);
		dict.insert("MK676554", inv3);
	
		
		assertEquals(3, dict.size(), "size failed, size is not as expected");
	}
	
	@Test
	void testTotalVal()	{

		dict.clear();
		dict.insert("SP7875", inv1);
		dict.insert("TR87680", inv2);
		dict.insert("MK676554", inv3);
		dict.insert("PW98762", inv4);
		
		assertEquals(2200.00, dict.totalvalue(), "failed, total value not as expected");
	}

}
