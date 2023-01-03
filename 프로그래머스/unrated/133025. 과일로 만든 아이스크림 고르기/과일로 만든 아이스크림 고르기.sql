-- 코드를 입력하세요
SELECT f.flavor
FROM FIRST_HALF f
JOIN ICECREAM_INFO i
ON f.flavor = i.flavor
WHERE f.TOTAL_ORDER > 3000 and i.INGREDIENT_TYPE = "fruit_based"
ORDER BY f.TOTAL_ORDER desc