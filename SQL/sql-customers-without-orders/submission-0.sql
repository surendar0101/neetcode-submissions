-- Write your query below
select name from customers where id NOT IN (select customer_id from orders);