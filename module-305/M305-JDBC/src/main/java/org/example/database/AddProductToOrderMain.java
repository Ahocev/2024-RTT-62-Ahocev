package org.example.database;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

public class AddProductToOrderMain {

    // I want to be able to add a product to an order with the quantity 100

    // 1) Load an order from the database by id
    // 2) Load a product from the database by id
    // 3) Create a new OrderDetail object and add the order and the product
    // 4) Save the OrderDetail object to the database

    private OrderDAO orderDAO = new OrderDAO();
    private ProductDAO productDAO = new ProductDAO();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    private CustomerDAO customerDAO = new CustomerDAO();

    public void run () {

        // read the order from the database
        Order order = orderDAO.findById(10100);

        System.out.println(order);

        // these 2 lines of code do the same thing
        // the second manually does the query with the FK id
        Customer customer = order.getCustomer();
        // Customer customer = customerDAO.findById(order.getCustomerId());

        System.out.println("This order is for customer with an id = " + customer.getId() + " and name = " + customer.getCustomerName() );

        // NOTE - This way of looping over the products is very inefficient on the database (runs a lot of queries)
        // the same thing could be accomplished with a custom query that returns columns from multiple different tables
        // lets print out the products that are part of this order already
        // this next line of code executes a query to get the order details
        // its doing the equivalent of
        // orderDetails.findByOrderId(order.getId());
        for ( OrderDetail od : order.getOrderDetails() ) {
            // the next line of code is going to cause hibernate to query the product table
            // essentially doing productDAO.findById(od.getProductId());
            System.out.println(od.getProduct().getProductName() + " | " + od.getQuantityOrdered() + " | " + od.getPriceEach());
        }

        // read the product from the database
        Product product = productDAO.findById(80);
        System.out.println(product);

        // setup the order details object with the values I want to save to the database
        // if this query returns a product, it means the product is already part of the order
        OrderDetail orderDetail = orderDetailDAO.findByOrderIdAndProductId(order.getId(), product.getId());
        if ( orderDetail == null ) {
            // this means the product was not found in the order
            // this will be a new insert of the product
            orderDetail = new OrderDetail();
        }

        // we want to increase the quantity ordered
        // if this is a new orderdetail the existing quantity ordered will be 0
        // if this is an existing orderdetail, the quantity will already be set
        // in either case I want to increase quantity ordered by one
        if ( orderDetail.getQuantityOrdered() == null ) {
            orderDetail.setQuantityOrdered(1);
        } else {
            orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered() + 1);
        }

        // We can just set the product and order objects we just queried on the orderDetail
        orderDetail.setProduct(product);
        orderDetail.setOrder(order);
        orderDetail.setPriceEach(product.getMsrp());
        orderDetail.setOrderLineNumber(10);

        // save the order details to the database
        // it is important to know if the id is null then you need to insert it
        // if the record was found in the database then the id will be not null so that is how we know it is an update rather than an insert
        if (orderDetail.getId() == null ) {
            orderDetailDAO.insert(orderDetail);
        } else {
            orderDetailDAO.update(orderDetail);
        }

    }

    public static void main(String[] args) {

        AddProductToOrderMain apto = new AddProductToOrderMain();
        apto.run();

    }

}
