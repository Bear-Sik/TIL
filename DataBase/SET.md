# SET

- 두 SELECT 문을 통해 얻어온 결과를 집합 연산을 통해 하나의 결과로 만드는 것을 SET라고 부름
- 합집합, 교집합, 차집합 등 집합 연산을 할 수 있다.
- 집합 연산을 위해서는 두 SELECT문을 통해 가져오는 컬럼이 같아야 한다.

## 합집합

- 두 SELECT문의 결과를 모두 포함하는 최종 결과를 반환한다.
- UNION : 중복되는 데이터를 하나만 가져온다.
- UNION ALL : 중복되는 데이터도 모두 가져온다.
- 사용 예시
    
    ```sql
    SELECT EMP_NO FROM TITLES WHERE TITLE = 'Senior Staff'
    UNION
    SELECT EMP_NO FROM TITLES WHERE TITLE = 'Staff'
    -- 10002, 10005, 10007, 10011, ~~~
    
    SELECT EMP_NO FROM TITLES WHERE TITLE = 'Senior Staff'
    UNION ALL
    SELECT EMP_NO FROM TITLES WHERE TITLE = 'Staff'
    -- 10002, 10005, 10005, 10007, 10007, ~~~~
    ```
    

## 교집합

- 두 SELECT문의 결과 중 중복되는 부분만 가져온다.
- MYSQL에서는 지원하지 않으므로 교집합은 JOIN 문을 사용한다
- 사용 예시
    
    ```sql
    SELECT A1.EMP_NO
    FROM TITLES A1, TITLES A2
    WHERE A1.EMP_NO = A2.EMP_NO 
    	AND A1.TITLE = 'Senior Staff' AND A2.TITLE = 'Staff'
    ```
    

## 차집합

- 두 SELECT문에서 중복되는 부분을 제거하고 첫 번째 SELECT문 결과만 가져온다.
- MYSQL에서는 지원하지 않으므로 서브쿼리를 이용한다.
- 사용 예시
    
    ```sql
    SELECT EMP_NO
    FROM TITLES
    WHERE TITLE = 'Staff' 
    	AND EMP_NO NOT IN (SELECT EMP_NO FROM TITLES WHERE TITLE = 'Senior Staff');
    ```