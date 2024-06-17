-- I want to see all employees that work in an office in the USA
select * 
from employees e, offices o
where e.office_id = o.id
	and o.country = 'USA';
    
    -- let's start by looking at various tables
    select * from orders;
    select * from orderdetails;
    
    -- calculate the totla price for each line item in the order 10103
    -- add the product name to this query result
    select od.*, (quantity_ordered * price_each) as total_price, p.product_name
    from orderdetails od, products p
    where order_id = 10103
		and p.id = od.product_id
	order by order_line_number;
    
    -- now lets add the date of the order
    select od.*, (quantity_ordered * price_each) as total_price, p.product_name, o.order_date
    from orderdetails od, products p, orders o
    where order_id = 10103
		and p.id = od.product_id
        and o.id = od.order_id
	order by order_line_number;
    
    -- now lets add custumer name to this report
    select od.*, (quantity_ordered * price_each) as total_price, p.product_name, o.order_date, c.customer_name
    from orderdetails od, products p, orders o, customers c
    where order_id = 10103
		and p.id = od.product_id
        and o.id = od.order_id
        and o.customer_id = c.id
	order by order_line_number;
    
    -- I want to see the total cost (sum of cost) for all line items for oder 10103
    -- the sum function is called an aggregate function
    select sum(quantity_ordered * price_each) as total_order_cost,
		max(quantity_ordered) as max_quantity_ordered,
        min(quantity_ordered) as min_quantity_ordered,
        avg(quantity_ordered * price_each) as avg_line_item_cost,
        avg(quantity_ordered) as avg_quantity_ordered
    from orderdetails od
    where order_id = 10103;
    
    -- I want to see the total order cost for all orders
    select order_id, sum(quantity_ordered * price_each) as total_order_cost,
		count(*) as number_of_products
    from orderdetails
    where order_id in ( 101013, 10104 )
    group by order_id;
    
    
    -- example of turning a query into a table to then aggregate
    select sum(total_order_cost)
    from
		(  select order_id, sum(quantity_ordered * price_each) as total_order_cost,
			count(*) as number_of_products
		from orderdetails
		where order_id in ( 101013, 10104 )
		group by order_id ) a;
    
    -- now I want to see the total amount each customer has spent
    -- step 1 join the customer table and the order table
    -- we also limited our columns in the result set so the data was a bit more consumbale by a human brain
    -- put an order by on this so we could see all of the customer order together
    select c.customer_name, o.id as order_id 
    from customers c, orders o
    where c.id = o.customer_id
    order by c.customer_name;
    
    -- step 2 we need to continue joining over to the order details table
    -- we added a second column to the order by so we could see the products in each order by the order id
    select c.customer_name, o.id as order_id, od.product_id
    from customers c, orders o, orderdetails od
    where c.id = o.customer_id
		and o.id = od.order_id
    order by c.customer_name;
    
    -- step 3 join to the orderdetails table and added the line item cost calculation
    -- at this step we can visualize the data in the database and think about how we can do a group by
	select c.customer_name, o.id as order_id, od.product_id, quantity_ordered, price_each, (quantity_ordered * price_each) as line_item_cost
    from customers c, orders o, orderdetails od
    where c.id = o.customer_id
		and o.id = od.order_id
    order by c.customer_name;
    
    -- step 4
    -- we removed the extra columns that were not in group by from the select
    -- we alseo removed the extra columns from the order by
    -- because we are grouping by the customer id we can also get the customer name because the customer record is singular and grouped by
    select c.id, c.customer_name, sum(quantity_ordered * price_each) as total_customer_spend
    from customers c, orders o, orderdetails od
    where c.id = o.customer_id
		and o.id = od.order_id
	group by c.id
    order by c.customer_name;
    
    -- to expand the original question to see the sum of each order for each customer
    -- we have now aded an order by for the order id so we can see the total cost for each order for all customers
    -- we can now include the order id in the select columns because it is in the group by
    select c.id, c.customer_name, o.id as order_id, sum(quantity_ordered * price_each) as total_customer_cost
    from customers c, orders o, orderdetails od
    where c.id = o.customer_id
		and o.id = od.order_id
	group by c.id, o.id
    order by c.customer_name;
    
    -- now lets make this one more step complex
    -- only show the orders over $50k
    select c.id, c.customer_name, o.id as order_id, sum(quantity_ordered * price_each) as total_order_cost
    from customers c, orders o, orderdetails od
    where c.id = o.customer_id
		and o.id = od.order_id
	group by c.id, o.id
    having total_order_cost > 50000 -- having only works filtering aggregate results
    order by c.customer_name;
    