# Write your MySQL query statement below
SELECT Date_Format(trans_date, '%Y-%m') as month, country, COUNT(*) as trans_count,
SUM(IF(state = 'approved',1,0)) AS approved_count,
SUM(amount) AS trans_total_amount,
SUM(IF(state = 'approved',amount,0)) approved_total_amount 
FROM Transactions
GROUP BY  month, country