/*
 * TCSS 305
 * Assignment 2 - Shopping Cart
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Objects;

/**
 * 
 * @author Zachariah Wingo
 * @version 1.0
 */
public final class Item {
    
    /**
     * The name of the item. 
     */
    private final String myItemName;
    
    /**
     * The price of the item.
     */
    private final BigDecimal myItemPrice;
    
    /**
     * The quantity of bulk items.
     */
    private final int myItemBulkQuantity;
    
    /**
     * The price of bulk item.
     */
    private final BigDecimal myItemBulkPrice;
    
    /**
     * Status of whether this is a bulk item or not.
     */
    private final boolean myBulkStatus;
 
    
    /**
     * Creates an item with a name and price.
     * 
     * @param theName name of item.
     * @param thePrice price of item.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        
        if (theName.isEmpty()) {
            throw new IllegalArgumentException("Must give the item a name.");
        }
        
        myItemName = theName;
        myItemPrice = (BigDecimal) Objects.requireNonNull(thePrice);
        
        // If price is less than zero we throw an exception
        if (myItemPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be zero or greater.");
        }
        
        // Set Bulk Item values to zero and/or false.
        myItemBulkPrice = new BigDecimal("0.00");
        myItemBulkQuantity = 0;
        myBulkStatus = false;
    }

    
    /**
     * Creates a bulk item.
     * 
     * @param theName the name of the item.
     * @param thePrice the price of the item.
     * @param theBulkQuantity the quantity required for a bulk discount.
     * @param theBulkPrice the total price of the bulk discount per bulk quantity. 
     */
    public Item(final String theName, final BigDecimal thePrice,
                    final int theBulkQuantity, final BigDecimal theBulkPrice) {
     
        // Throw exception if string is empty.
        if (theName.isEmpty()) {
            throw new IllegalArgumentException("Must give the item a name");
        }
        
        myItemPrice = (BigDecimal) Objects.requireNonNull(thePrice);
        myItemBulkPrice = (BigDecimal) Objects.requireNonNull(theBulkPrice);
        
        //Test if price is less than zero
        if (myItemPrice.compareTo(BigDecimal.ZERO) < 0 
                        || myItemBulkPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Prices must be zero or positive.");
        }
        
        // Bulk quantity must be a positive value.
        if (theBulkQuantity <= 0) {
            throw new IllegalArgumentException("The bulk quantity must be a positive value!");
        }
        
        myItemBulkQuantity = theBulkQuantity;
        myItemName = theName;        
        myBulkStatus = true;
    }


    /**
     * 
     * @return price of item as BigDecimal object.
     */
    public BigDecimal getPrice() {
        
        return myItemPrice;
    }
    
    
    /**
     * 
     * @return quantity needed to get a bulk discount.
     */
    public int getBulkQuantity() {
        
        return myItemBulkQuantity;
    }
    
    
    /**
     * 
     * @return price of bulk items at the given quantity.
     */
    public BigDecimal getBulkPrice() {

        return myItemBulkPrice;
    }


    /**
     * 
     * @return returns true if item is a bulk item and false if not.
     */
    public boolean isBulk() {
        
        return myBulkStatus;
    }

    /**
     * To String. Gives Item name, Price and if necessary
     * Bulk Quantity and Bulk Price.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        
        // The Item name and price will always be included.
        sb.append(myItemName);
        sb.append(", ");
        sb.append(NumberFormat.getCurrencyInstance().format(myItemPrice));

        // If item is bulk we also append the price and quantity.
        if (myBulkStatus) {
            sb.append(" (");
            sb.append(myItemBulkQuantity);
            sb.append(" for ");
            sb.append(NumberFormat.getCurrencyInstance().format(myItemBulkPrice));
            sb.append(')');
        }
        return sb.toString();
    }

    /**
     * Hashcode from instance fields.
     */
    @Override
    public int hashCode() {

        return Objects.hash(myBulkStatus, myItemBulkPrice, myItemBulkQuantity, 
                           myItemName, myItemPrice);
    }

    /**
     * Equals method.
     */
    @Override
    public boolean equals(final Object theOther) {
        
        boolean result;
        
        if (this == theOther) { 
            result = true;
        } else if (theOther == null || getClass() != theOther.getClass()) {
            result = false;
        } else {
            
            // Cast the theOther to an Item.
            final Item other = (Item) theOther;
            
            // Test that both objects have matching values
            result = myItemName.equals(other.myItemName) 
                     && myItemPrice.equals(other.myItemPrice)
                     && myItemBulkPrice.equals(other.myItemBulkPrice)
                     && (myItemBulkQuantity == other.myItemBulkQuantity)
                     && (myBulkStatus == other.myBulkStatus);
            

        }
        
        return result;
    }

}
