# Write your MySQL query statement below
SELECT Date_Format(trans_date, '%Y-%m') as month, country
FROM Transactions
GROUP BY  month, country