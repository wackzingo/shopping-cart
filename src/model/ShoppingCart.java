/*
 * TCSS 305
 * Assignment 2 - Shopping Cart
 */

package model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Creates a shopping cart.
 * @author Zachariah Wingo
 * @version 1.0
 */
public class ShoppingCart {

    /**
     * Stores items in the Shopping Cart as <k Item, v ItemOrder>
     * The HashMap allows only unique or Items to be stored.
     */
    private final Map<Item, ItemOrder>  myShoppingCart;
    
    /**
     * Membership status.
     */
    private boolean myMembershipStatus;
    
    /**
     * Constructor.
     */
    public ShoppingCart() {
        
        myShoppingCart = new HashMap<Item, ItemOrder>();
        //myItemOrdersCount = myShoppingCart.size();
        
        
    }


    /**
     * Add an item order to the shopping  cart.
     * @param theOrder takes an ItemOrder.
     */
    public void add(final ItemOrder theOrder) {
        myShoppingCart.put(theOrder.getItem(), theOrder);
    }


    /**
     * Sets the membership status.
     * @param theMembership set True if member. False is not a member.
     */
    public void setMembership(final boolean theMembership) {
        myMembershipStatus = theMembership;
    } 


    /**
     * Calculates the total of all item orders in the shopping cart.
     * @return returns the total of all item orders in the shopping cart as BigDecimal.
     */
    public BigDecimal calculateTotal() {
                        
        // Makes sure total is starting at zero.
        BigDecimal total = BigDecimal.ZERO;
        
        // Sub-Total to track prices.
        BigDecimal subTotal = BigDecimal.ZERO;
        
        // Iterator for the shopping cart orders.
        final Iterator<ItemOrder> itr = myShoppingCart.values().iterator();
        
        
        // Gets Item Orders
        while (itr.hasNext()) {
        
            // Cast the object returned by the iterator to an ItemOrder
            final ItemOrder itemOrder = (ItemOrder) itr.next();
            
            // Extract the reference to the Item from Item Order.
            final Item item = itemOrder.getItem();
            
            // Extract the quantity being ordered.
            final int orderQty = itemOrder.getQuantity();
            
            // Number of bulk purchases.
            int bulkPurchase;
            
            // Additional items not part of bulk discount.
            int additionalItems;

            // Calculates order cost if member is purchasing a bulk elligible item.
            if (myMembershipStatus && item.isBulk()) {
                
                /*
                 * We can only calculate a bulk discount if they order a quantity
                 * greater or equal to the bulk quantity. If the minimum amount
                 * is not met we will simply calculate the total by multiplying
                 * the total order quantity by the regular price. 
                 */
                if (orderQty >= item.getBulkQuantity()) {
                    
                    /*
                     * The bulk price represents the total for multiples of the bulk quantity.
                     * The additional items are items over a multiple of the bulk quantity
                     * and will be charged the normal price.
                     */
                    additionalItems = orderQty % item.getBulkQuantity();
                    
                    // The number of bulk quantity multiples.
                    bulkPurchase = orderQty - additionalItems;
                    
                    // Calculates the cost of the bulk purchases
                    subTotal = subTotal.add(
                        item.getBulkPrice().multiply(
                            new BigDecimal(bulkPurchase / item.getBulkQuantity())));
                    
                    // Calculates the cost of the additional items.
                    subTotal = subTotal.add(
                        item.getPrice().multiply(new BigDecimal(additionalItems)));

                } else {
                    
                    // Calculates bulk items below minimum at regular price.
                    subTotal = subTotal.add(item.getPrice().multiply(
                                   new BigDecimal(itemOrder.getQuantity())));
                }
                 
            } else {
                
                // Calculates all orders that do not qualify for a bulk / membership discount.
                subTotal = subTotal.add(item.getPrice().multiply(new BigDecimal(orderQty)));
            }

        }
        
        /*
         * A sub-total is used because we may need to calculate a sub-total
         * and total separate.
         */
        total = total.add(subTotal).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return total;
    } 
    
    /**
     * Clears the shopping cart of all orders.
     */
    public void clear() {
        myShoppingCart.clear();
    }

    /**
     * Overrides default toString() method.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        
        // Iterator for the shopping cart orders.
        final Iterator<ItemOrder> itr = myShoppingCart.values().iterator();
        
        sb.append('[');
        // Gets Item Orders
        while (itr.hasNext()) {
            sb.append(itr.next());
            sb.append(' ');
            
        }
        
        sb.append(" ]");
        System.out.println(sb.toString());
        return sb.toString();
    }

    

}
