/*
 * TCSS 305
 * Assignment 2 - Shopping Cart
 */

package model;

/**
 * Creates an Item Order.
 * 
 * @author Zachariah Wingo
 * @version 1.0
 */
public final class ItemOrder {

    /**
     * Item being ordered.
     */
    private final Item myItemOrder;
    
    /**
     * Quantity being ordered.
     */
    private final int myItemQuantity;

    
    /**
     * Constructor for creating an order.
     * 
     * @param theItem item being ordered.
     * @param theQuantity quantity to order.
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        myItemOrder = theItem;
        myItemQuantity = theQuantity;
    }

    /**
     * 
     * @return returns the Item being ordered.
     */
    public Item getItem() {
        
        return myItemOrder;
    }
    
    /**
     * 
     * @return returns the quantity to order.
     */
    public int getQuantity() {
        
        return myItemQuantity;
    }


    /**
     * Overrides default toString method. Displays "Item: item.toString() Quantity Ordered: #".
     */
    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder(100);
        sb.append("Item: ");
        sb.append(myItemOrder.toString());
        sb.append(" Quantity Ordered: ");
        sb.append(myItemQuantity);
        return sb.toString();
    }

}
