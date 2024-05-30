-- Homework 1

-- Question 0.1
-- I want to see the count of the number of products in each product line
select productline_id as product_id, count(*) as products_in_each_line
from products
group by productline_id;

select pl.product_line, count(*)
from products p, productlines pl
where p.productline_id = pl.id
group by pl.id;

-- Question 0.2
-- I want to see a list of employees and all of the customers for that employee. Employee name will be duplicated in the result set. I want to see the employee first and last name and the customer contact first and last name as well as the customer name
select firstname as employee_firstname, lastname as employee_lastname, customer_name as company, contact_firstname as customer_firstname, contact_lastname as customer_lastname
from employees e, customers;

select * from employees;
select * from customers;

select e.id as employee_id, e.firstname, e.lastname, c.customer_name, c.contact_firstname, c.contact_lastname
from employees e, customers c
where c.sales_rep_employee_id = e.id
order by e.id;

-- Question 0.3
-- I want to see a list of employees in each office. Show the office name and the employee name.
select firstname as employee_firstname, lastname as employee_lastname, office_id
from employees, offices;

select * from offices;
select * from employees;

select o.city, e.firstname, e.lastname
from offices o, employees e
where o.id = e.office_id
order by o.city;

-- Question 0.4
-- I want to see the total number of each employee type based on job title. The result should be the job title and the number of employees with that job title.
select job_title, count(lastname) as employee_count
from employees
group by job_title;

select * from employees;

select job_title, count(*)
from employees
group by job_title;

-- Question 0.5
-- I was to see a list of all the payments each customer has made. Order the list by customer name ascending, then by the payment amount descending
select contact_firstname, contact_lastname, payments.customer_id, amount
from customers
join payments on customer_id
order by contact_firstname asc, amount desc;

select * from payments;
select * from customers;

select c.customer_name, p.amount
from customers c, payments p
where p.customer_id = c.id
order by c.customer_name asc, p.amount desc;

-- Question 0.6
-- I want to see a list of products that have never been sold. use: where not in ( select product_id from order_details ) in your where clause
select * from products 
where id not in ( select distinct product_id from orderdetails );

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

select * from offices;

select o.id, o.city, e.firstname, c.customer_name
from offices o, employees e, customers c
where o.id = e.office_id
	and e.id = c.sales_rep_employee_id
order by o.city, e.firstname;

select o.id, o.city, count(*)
from offices o, employees e, customers c
where o.id = e.office_id
	and e.id = c.sales_rep_employee_id
group by o.id
order by o.city;

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
ORDER BY c.state ASC, profit_margin DESC
limit 5;

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
select * from orders;

select * from orders
where year (order_date) = 2004;


-- Question 6
-- I want to see the total amount of all orders grouped by the year
select * from orders;
select * from orderdetails;

select year(o.order_date), sum(od.quantity_ordered * price_each) as total_amount, count(distinct o.id) as order_count
from orders o, orderdetails od
where o.id = od.order_id
group by year(o.order_date);

-- Question 7
-- I want to see the top 5 products based on quantity sold across all orders

select * from orderdetails;

select product_name, sum(quantity_ordered) as total_ordered
from products p, orderdetails od
where od.product_id = p.id
	and od.order_id not in ( select id from orders where status = 'Cancelled' )
group by od.product_id
order by total_ordered desc
limit 5;

select product_name, sum(quantity_ordered) as total_ordered
from products p, orderdetails od, orders o
where od.product_id = p.id
	and od.order_id = o.id
    and o.status != 'Cancelled'
group by od.product_id
order by total_ordered desc
limit 5;

-- Question 7.5
-- How many times has each product appeared in an order regardless of how many were purchased?

select * from orderdetails;

select p.id, p.product_name, count(p.id) as cnt
from orderdetails od, products p
where od.product_id = p.id
group by p.id
order by cnt desc;

-- Question 7.6
-- How many products would be out of stock based on the amount sold across time ( any product where the sum of the quantity sold is greater than the quantity in stock )

select * from products;
select * from orderdetails;

select product_id, p.product_name, sum(quantity_ordered) as total_ordered, p.quantity_in_stock - sum(quantity_ordered) as overordered
from orderdetails od, products p
where p.id = od.product_id
group by product_id
having overordered < 0;

select product_id, p.product_name, sum(quantity_ordered) as total_ordered, p.quantity_in_stock
from orderdetails od, products p
where p.id = od.product_id
group by product_id
having total_ordered < ( select quantity_in_stock from products pp where pp.id = od.product_id);

-- Question 7.9
-- I want to see the distinct order status ordered alphabetically

select * from orders;

select distinct status 
from orders 
order by status asc;

-- Question 8 
-- I want to see the  office name and the distinct product lines that have been sold in that office. This will require joining almost all of the tables.

select distinct ofc.city, pl.product_line
from offices ofc, employees e, customers c, orders o, orderdetails od, products p, productlines pl
where ofc.id = e.office_id
	and c.sales_rep_employee_id = e.id
    and o.customer_id = c.id
    and od.order_id = o.id
    and od.product_id = p.id
    and p.productline_id = pl.id;


SELECT DISTINCT offices.city AS office_name, pl.product_line AS product_line_name
FROM offices, productlines pl, customers c, employees e, orders o, orderdetails od, products p
WHERE o.customer_id = c.id
      AND c.sales_rep_employee_id = e.id
      AND od.order_id = o.id
      AND od.product_id = p.id
      AND p.productline_id = pl.id
ORDER BY office_name, product_line_name;