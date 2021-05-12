package com.mendix.shoppingcart_java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import com.mendix.shoppingcart_java.customers.Address;
import com.mendix.shoppingcart_java.customers.Customer;
import com.mendix.shoppingcart_java.customers.Gender;
import com.mendix.shoppingcart_java.orders.Order;
import com.mendix.shoppingcart_java.products.Product;

public class OrderTest{
	
	Customer customer;
	Address address;
	Product product;
	
	public OrderTest(){
      
       customer = new Customer("FirstName", "LastName", Gender.Female);
       address = new Address(customer, "street", 0, "1234");
       product = new Product("Product 1", 1, 10.0);
    }

	public void customerCanPlaceOneItemInShoopingCart() {
    	
    		Order order = new Order();
    		order.add(product);
    		order.setCustomer(customer);
    		
    		assertEquals(2, order.orderLines.size());
    }
    
    @Test
	public void It_should_have_multiple_items_in_shopping_cart() {
    		
    		Order order = new Order();
        order.add2(product);
        order.setCustomer(customer);

        assertEquals(2, order.orderLines.size());
    }    
    
    @Test
    public void It_should_create_an_order_for_customer()
    {
        Order order = new Order(customer);

        assertEquals(customer, order.getCustomer());
    }
            
    @Test
    public void It_should_update_the_amount_of_a_product_in_cart()
    {
        Order order = new Order(product);
        order.add(product, 5);
        order.setCustomer(customer);

        assertEquals(6, order.orderLines.stream().filter(line -> line.getProduct() == product).findFirst().get().getAmount());
    }
    
    @Test
    public void It_should_create_an_order_from_a_product()
    {
        Order order = new Order(product, 3);

        assertEquals(3, order.orderLines.get(0).getAmount());
    }
    
    @Test        
	public void It_should_have_an_order_bound_to_a_customer()
	{
	    Order order = new Order();
	    order.add(product);
	    
	    assertNotNull(customer);
	}
            
    @Test(expected = IndexOutOfBoundsException.class)
	public void It_should_fail_after()
    {
        Order order = new Order();
        order.add(product);
        order.remove(product);

        assertEquals(0, order.orderLines.size());
    }

    @Test
    public void It_should_apply_discount_when_order_total_greater_than_20_euros() throws Exception {
	    final double DELTA = 1e-8;//delta value needs to be added while asserting the double values
        Order order = new Order();//Create the order first
        order.setCustomer(customer);//Set the customer to created order
        order.add(product,2);//Adding product with default base price as 10.0 and amount/quantity as 2
        
        double totalPrice=order.totalPriceBeforeDiscount();//Get the total price of added products before discount
        
        //If price is greater or equal to 20, apply the discount of 5% which will be 1.0 in this case
        // and compare discounted price with our expected price which is 19.0 in this case
        if(totalPrice>=20.0)
        {
            double totalOriginalPrice = order.totalPriceBeforeDiscount();//Retrive total price
            double calculatedDiscount = (totalOriginalPrice*5)/100;//Calculate 5 % discount on total price
            double totalPriceAfterDiscount = totalOriginalPrice-calculatedDiscount;//Calculate discounted price
            Assert.assertEquals(totalPriceAfterDiscount,order.totalPriceAfterDiscount(),DELTA);
        }
        //Else compare the original price of amount
        else
        {
            Assert.assertEquals(order.totalPriceBeforeDiscount(),order.totalPriceAfterDiscount(),DELTA);
        }
	}

}
