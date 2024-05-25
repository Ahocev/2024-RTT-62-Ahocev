-- Homework 1

-- Question 0.1
-- I want to see the count of the number of products in each product line

-- Question 0.2
-- I want to see a list of employees and all of the customers for that employee. Employee name will be duplicated in the result set. I want to see the employee first and last name and the customer contact first and last name as well as the customer name

-- Question 0.3
-- I want to see a list of employees in each office. Show the office name and the employee name.

-- Question 0.4
-- I want to see the total number of each employee type based on job title. The result should be the job title and the number of employees with that job title.

-- Question 0.5
-- I was to see a list of all the payments each customer has made. Order the list by customer name ascending, then by the payment amount descending

-- Question 0.6
-- I want to see a list of products that have never been sold. use: where not in ( select product_id from order_details ) in your where clause
select * from products where id not in ( select product_id from orderdetails );

-- Question 1
-- How many customers are handled by each office?
-- I want to see the office name and the count of the number of customers in that office.

-- Question 2
-- I want to see the products with the most margin at the top of the table (margin is calculated by MSRP - buy_price)
-- Include the product name, buy price, msrp, and margin in the results

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

-- Question 7.9
-- I want to see the distinct order status ordered alphabetically

-- Question 8 
-- I want to see the  office name and the distinct product lines that have been sold in that office. This will require joining almost all of the tables.
select distinct o.name as office_name, pl.productlines as product_line_name