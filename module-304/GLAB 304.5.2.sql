select customer_name, country
from customers
where country = 'USA' or country = 'France';

select customer_name, country, credit_limit
from customers
where (country = 'USA' or country = 'France') and credit_limit > 100000;

select customer_name, country, credit_limit
from customers
where country = 'USA' or country = 'France' and credit_limit > 100000;

select product_code, product_name, buy_price
from products
where buy_price between 90 and 100;

select product_code, product_name, buy_price
from products
where buy_price >= 90 and buy_price <= 100;

select product_code, product_name, buy_price
from products
where buy_price not between 20 and 100;

select product_code, product_name, buy_price
from products
where buy_price < 20 or buy_price > 100;

select customer_name, country, sales_rep_employee_id
from customers
where sales_rep_employee_id is null
order by customer_name;

select customer_name, country, sales_rep_employee_id
from customers
where sales_rep_employee_id is not null
order by customer_name;

SELECT c.id, c.customer_name, o.id, o.status
FROM customers AS c
LEFT JOIN orders AS o
ON c.id = o.id
WHERE o.id IS NULL
order by c.id;