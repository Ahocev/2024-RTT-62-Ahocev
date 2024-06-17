-- Display the name, product line, and buy price of all products. 
-- The output columns should display as: “Name,” “Product Line,” and “Buy Price.” 
-- The output should display the most expensive items first. 
select product_name as name, product_line, buy_price
from productlines pl, products p 
order by buy_price desc;


-- Display the first name, last name, and city name of all customers from Germany. 
-- The output columns should display as: “First Name,” “Last Name,” and “City.” 
-- The output should be sorted by “Last Name” (ascending).
select contact_firstname, contact_lastname, city
from customers
order by contact_lastname;


-- Display each of the unique values of the status field in the orders table. 
-- The output should be sorted alphabetically, ascending.
-- Hint: The output should show exactly six rows.
select distinct o.status
from orders o;


-- Display all fields from the payments table for payments made on or after January 1, 2005. 
-- The output should be sorted by the payment date from highest to lowest.
select payment_date
from payments
where payment_date >= '2005-01-01'
order by payment_date desc;


-- Display the last Name, first Name, email address, and job title of all employees working out of the San Francisco office. 
-- The output should be sorted by “Last Name.”
select * from employees;
select * from offices;

select e.lastname, e.firstname, e.email, e.job_title, o.city
from employees e, offices o
where e.office_id = o.id
	and o.city = 'San Francisco'
order by e.lastname;


-- Display the name, product line, scale, and vendor of all of the car products – both classic and vintage. 
-- The output should display all vintage cars first (sorted alphabetically by name), 
-- and all classic cars last (also sorted alphabetically by name).
select * from productlines;
select * from products;

select p.product_name, pl.product_line, p.product_scale, p.product_vendor
from products p, productlines pl
where pl.id = p.productline_id
	and pl.product_line in ('Vintage Cars', 'Classic Cars')
order by pl.product_line = 'Classic Cars',
substring(SUBSTRING_INDEX(p.product_name, ' ', 2), locate(' ', p.product_name) + 1) asc;
 