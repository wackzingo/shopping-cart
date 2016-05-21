/*
 * TCSS 305
 * Assignment 2 - Shopping Cart
 */
package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import model.Item;
import org.junit.Before;
import org.junit.Test;



/**
 * @author Zachariah Wingo
 * @version 1.0
 */
public class ItemTest {
    /**
     * Create myItem1 and myItem1 fixture.
     */
    private Item myItem1;
    
    /**
     * Create myItem2 and myItem1 fixture.
     */
    private Item myItem2;
    
    
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        
        // Create standard Item
        myItem1 = new Item("Silly Putty", new BigDecimal("29.95"));
        
        // Create a bulk Item
        myItem2 = new Item("Silly Potty", new BigDecimal("34.97"), 21, 
                                    new BigDecimal("12.01"));
        
    }

    
    /**
     * Test hash code for matching hash codes on standard items.
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    public void testHashCodeStandardItems() {
        
        // Create a new Item that matches the values of Item 1
        final Item item1Dublicate = new Item("Silly Putty", new BigDecimal("29.95"));
        
        // Testing for matching hashcodes for equal objects.
        assertEquals(myItem1.hashCode(), item1Dublicate.hashCode());
    }

    
    /**
     * Test hash code for matching hash codes on bulk items.
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    public void testHashCodeBulkItems() {
        
        // Create a new Item that matches the values of Item 2
        final Item item2Duplicate = new Item("Silly Potty", new BigDecimal("34.97"), 21, 
                           new BigDecimal("12.01"));
        
        // Testing for matching hashcodes for equal objects.
        assertEquals(myItem2.hashCode(), item2Duplicate.hashCode());
    }
    
    
    /**
     * Test hash code for different hash codes on bulk items.
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test 
    public void testHashCodeDifferentBulkItems() {
        
        // Create a new Item that matches the values of Item 2
        final Item item2Duplicate = new Item("Silly Potty", new BigDecimal("34.96"), 21, 
                           new BigDecimal("12.01"));
        
        // Testing for matching hashcodes for equal objects.
        assertNotEquals(myItem2.hashCode(), item2Duplicate.hashCode());
    }
    

    /**
     * Test method for {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test
    public void testItemStringBigDecimal() {
        // Here we only test that the price is correctly being set.
        // We can test the private itemName field when we test ToString.
        assertTrue(new BigDecimal("29.95").equals(myItem1.getPrice()));

    }
    
    
    
    /**
     * Test method for {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalNegativePrice() {
        
        // Create a new test with a negative prices. Uncomment and test individually
        new Item("Silly Putty", new BigDecimal("-9.00"), 4, new BigDecimal("10.00"));

    }
    
    /**
     * Test method for {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalNegativeBulkPrice() {
        
        // Create a new test with a negative prices. Uncomment and test individually
        new Item("Silly Putty", new BigDecimal("9.00"), 4, new BigDecimal("-10.00"));

    }

    
    /**
     * Test method for {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalNegativeStandard() {
        
        // Create a new test with a negative prices. Uncomment and test individually
        new Item("Silly Putty", new BigDecimal("-5.00"));

    }
    
    
    /**
     * Test method for {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalEmptyString() {
        
        // Create a new test with a negative prices. Uncomment and test individually
        new Item("", new BigDecimal("5.00"));

    }
    
    
    /**
     * Test method for {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemStringBigDecimalEmptyStringBulkItem() {
        
        new Item("", new BigDecimal("5.00"), 5, new BigDecimal("6.40"));

    }
    
    
    /**
     * Test method for {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test
    public void testItemStringBigDecimalIntBigDecimal() {
        // We will test the name is correctly being set in the toString method.
        assertTrue(new BigDecimal("34.97").equals(myItem2.getPrice()));
        assertTrue(new BigDecimal("12.01").equals(myItem2.getBulkPrice()));
        assertEquals(myItem2.getBulkQuantity(), 21);
    }

    /**
     * Test method for {@link model.Item#getPrice()}.
     */
    @Test
    public void testGetPrice() {
        assertEquals(new BigDecimal("34.97"), myItem2.getPrice());
    }

    /**
     * Test method for {@link model.Item#getBulkQuantity()}.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(21, myItem2.getBulkQuantity());
    }

    
    /**
     * Test method for {@link model.Item#getBulkQuantity()}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetBulkQuantityNegative() {
        new Item("Negative Quantity", new BigDecimal("5.00"), -5, new BigDecimal("5.00"));
    }
    
    
    /**
     * Test method for {@link model.Item#getBulkQuantity()}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetBulkQuantityZero() {
        new Item("Negative Quantity", new BigDecimal("5.00"), 0, new BigDecimal("5.00"));
    }
    
    
    /**
     * Test method for {@link model.Item#getBulkPrice()}.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals(new BigDecimal("12.01"), myItem2.getBulkPrice());
    }

    /**
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    public void testIsBulk() {
        assertFalse(myItem1.isBulk());
        assertTrue(myItem2.isBulk());
    }

    /**
     * Test method for {@link model.Item#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Silly Putty, $29.95", myItem1.toString());
        assertEquals("Silly Potty, $34.97 (21 for $12.01)", myItem2.toString());
    }

    /**
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject() {
        
        // Create a new Item that matches the values of Item 1
        final Item item1Duplicate = new Item("Silly Putty", new BigDecimal("29.95"));
        
        // Testing for matching hash codes for equal objects.
        assertEquals(myItem1, item1Duplicate);
        
        final Item item2Duplicate = new Item("Silly Potty", new BigDecimal("34.97"), 21, 
                                             new BigDecimal("12.01"));
        
        assertEquals(myItem2, item2Duplicate);
    }

    
    /**
     * Test to see if the same object returns true
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectSame() {
        
        assertEquals(myItem1, myItem1);
    }

    
    /**
     * Test to see if the null object returns false
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectNull() {
        final Item nullItem = null;
        assertFalse(myItem1.equals(nullItem));
    }
    
    
    /**
     * Test different classes
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectNotSameClass() {
        
        assertFalse(myItem1.equals(new BigDecimal("4")));
    }
}
