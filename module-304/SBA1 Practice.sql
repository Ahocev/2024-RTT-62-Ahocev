-- 
select * from orderdetails;
select * from products;

select p.product_name, format(max(buy_price),2) as max_offer, format(min(buy_price),2) as min_offer, 
format(round(avg(buy_price),2),2) as avg_buy_price, count(*) as product_count
from products p, orderdetails od
where p.id = od.product_id
group by od.product_id;

-- An auction web service needs a query that returns a list of all available lots with offers left by buyers.
-- The result should have the following columns: name | min _offer | avg_offer | max_offer | offers.
-- • name - lot name
-- • min_offer - minimum offer for a specific lot
-- • avg_offer - average offer for a specific lot, rounded to two decimal places
-- • max_offer - maximum offer for a specific lot
-- • offers - total number of offers for a specific lot
-- The result should be sorted in descending order by offers.
-- Notes:
-- • Some lots may not have offers.
-- • Values for min offer, avg-offer, and max offer should always show two places after the decimal, e.g., 10 is shown as 10.00.

select * from lots; -- contains id, and name
Select * from offers; -- contains lot_id, and amount

select l.name as name, format(min(o.amount),2) as min_offer, format(round(avg(o.amount),2),2) as avg_offer, 
format(max(o.amount),2) as max_offer, count(*) as offers
from lots l, offers o
where l.id = o.lot_id
group by o.lot_id desc;


