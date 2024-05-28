select order_id, sum(quantity_ordered) as qty,
	if(mod(sum(quantity_ordered),2),'odd','even') as odd_or_even
from orderdetails
group by order_id
order by order_id;

select truncate (1.555,1);

select product_id, avg(quantity_ordered * price_each) as avg_order_value
from orderdetails
group by product_id;

select product_id, round(avg(quantity_ordered * price_each)) as avg_order_value
from orderdetails
group by product_id;

UPDATE products 
SET product_description = REPLACE(product_description,'abuot','about');

SELECT DATEDIFF('2011-08-17','2011-08-17');  
#Result  :   0 day

SELECT DATEDIFF('2011-08-17','2011-08-08'); 
#Result:  9 days

SELECT DATEDIFF('2011-08-08','2011-08-17');  
#Result:  -9 days

select orders.id as order_number, datediff(required_date, shipped_date) as days_left
from orders
order by days_left desc;

select orders.id as order_number, datediff(required_date, order_date) as remaining_days
from orders
where status = 'In Process'
order by remaining_days desc;


SELECT 
    orders.id,
    ROUND(DATEDIFF(required_date, order_date) / 7, 2),
    ROUND(DATEDIFF(required_date, order_date) / 30,2)
FROM     orders 
WHERE    status = 'In Process';

SELECT 
    orders.id,
    DATE_FORMAT(order_date, '%Y-%m-%d') order_date,
    DATE_FORMAT(required_date, '%a %D %b %Y') required_date,
    DATE_FORMAT(shipped_date, '%W %D %M %Y') shipped_date
FROM    orders;

SELECT  
	orders.id,
    DATE_FORMAT(shipped_date, '%W %D %M %Y')  as 'Shipped date'
FROM    orders
ORDER BY shipped_date;

SELECT firstname, LPAD(firstname,10,'kk'), LPAD(firstname,5,'kk'), LPAD(firstname,4,'kk') 
FROM employees;

SELECT TRIM(' SQL TRIM Function ');

SELECT LTRIM('  SQL LTRIM function');

SELECT RTRIM('SQL RTRIM function   ');

SELECT YEAR(shipped_date) as year,  COUNT(orders.id) as orderQty
FROM    orders 
GROUP BY YEAR(shipped_date)
ORDER BY YEAR(shipped_date);

SELECT  DAY(order_date) as dayofmonth, COUNT(*)
FROM    orders WHERE    YEAR(order_date) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;













