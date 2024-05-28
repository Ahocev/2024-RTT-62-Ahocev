-- Homework 1

-- Question 0.1
-- I want to see the count of the number of products in each product line
select productline_id as product_id, count(*) as products_in_each_line
from products
group by productline_id;

-- Question 0.2
-- I want to see a list of employees and all of the customers for that employee. Employee name will be duplicated in the result set. I want to see the employee first and last name and the customer contact first and last name as well as the customer name
select firstname as employee_firstname, lastname as employee_lastname, customer_name as company, contact_firstname as customer_firstname, contact_lastname as customer_lastname
from employees e, customers;

-- Question 0.3
-- I want to see a list of employees in each office. Show the office name and the employee name.
select firstname as employee_firstname, lastname as employee_lastname, office_id
from employees, offices;

-- Question 0.4
-- I want to see the total number of each employee type based on job title. The result should be the job title and the number of employees with that job title.
select job_title, count(lastname) as employee_count
from employees
group by job_title;

-- Question 0.5
-- I was to see a list of all the payments each customer has made. Order the list by customer name ascending, then by the payment amount descending
select contact_firstname, contact_lastname, payments.customer_id, amount
from customers
join payments on customer_id
order by contact_firstname asc, amount desc;

-- Question 0.6
-- I want to see a list of products that have never been sold. use: where not in ( select product_id from order_details ) in your where clause
select * from products 
where id not in ( select product_id from orderdetails );

-- Question 0.7
-- Are there any customers that have never made an order?
select * from customers
where id not in ( select customer_id from orders );

-- Question 1
-- How many customers are handled by each office?
-- I want to see the office name and the count of the number of customers in that office.
select offices.id, count(customers.id) as customer_count
from offices, customers
group by offices.id;
 
-- Question 2
-- I want to see the products with the most margin at the top of the table (margin is calculated by MSRP - buy_price)
-- Include the product name, buy price, msrp, and margin in the results
SELECT product_name, buy_price, msrp, (msrp - buy_price) AS margin
FROM products
ORDER BY margin DESC;

-- Question 2.5
-- I want to see the top 5 customers in each state based on margin
SELECT 
    c.customer_name, 
    c.state,
    SUM(p.msrp - p.buy_price) AS profit_margin
FROM customers c, orders o, orderdetails od,  products p
WHERE c.id = o.customer_id
    AND o.id = od.order_id
    AND p.id = od.product_id
    AND c.state IS NOT NULL
GROUP BY c.id, c.state
ORDER BY c.state ASC, profit_margin DESC;

SELECT customer_name, state, profit_margin
        FROM (    SELECT  c.customer_name, c.state,
                                        SUM(od.quantity_ordered * (p.msrp - p.buy_price)) AS profit_margin,
                                          (ROW_NUMBER() over (partition by state order by SUM(p.msrp - p.buy_price) DESC)) AS row_num
                             FROM customers c
                                         INNER JOIN orders o ON c.id = o.customer_id
                                         INNER JOIN orderdetails od ON o.id = od.order_id
                                         INNER JOIN products p ON p.id = od.product_id
                               WHERE c.state IS NOT NULL
                                          AND c.country = 'USA'
                               GROUP BY c.id , c.state
                                 ORDER BY c.state , profit_margin DESC ) as  subquery
        WHERE row_num <= 5;

-- Question 3
-- I want to see the top 5 salesmen in the company based on the total amount sold

-- Question 4
-- I want to see the top 5 salesmen based on overall profit margin

-- Question 5
-- I want to see all of the orders that happened in 2004. You can use a function called year(order_date) = 2004

-- Question 6
-- I want to see the total amount of all orders grouped by the year

-- Question 7
-- I want to see the top 5 products based on quantity sold acrosss all orders

-- Question 7.5
-- How many times has each product appeared in an order regardless of how many were purchased?

-- Question 7.6
-- How many products would be out of stock based on the amount sold across time ( any product where the sum of the quantity sold is greated that the quantity in stock )

-- Question 7.9
-- I want to see the distinct order status ordered alphabetically

-- Question 8 
-- I want to see the  office name and the distinct product lines that have been sold in that office. This will require joining almost all of the tables.
select distinct o.name as office_name, pl.productlines as product_line_name