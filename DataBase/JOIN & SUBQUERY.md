# JOIN

## JOIN을 사용하는 이유

- 데이터베이스에서 가장 중요한 부분은 데이터를 가져오는 데 걸리는 시간의 최소화이다.
- 저장된 데이터의 총량이 크면 클수록 데이터를 가져오는 데 시간이 오래걸리게 된다.
- 데이터의 중복을 최소화 하여 데이터를 빠르게 가져올 수 있도록 테이블을 구성하게 된다.
- 중복을 최소화 하기위해서는 테이블을 두 개 이상으로 분리할 수 밖에 없다.
- **데이터의 중복을 최소화 하기 위해** `테이블을 분리` 시킨 후 데이터를 가져올 때 여러 테이블을 하나의 결과로 가져와야할 때 JOIN을 사용한다.

### 기본 JOIN

- 여러 테이블을 JOIN 할 때는 테이블의 이름을 , 로 구분하여 작성
- 각 테이블의 컬럼명을 기술하여 주면 원하는 데이터를 가져올 수 있다.
- **SELECT 컬럼명1, 컬럼명2, 컬럼명3 FROM 테이블1, 테이블2**
- **주의사항!** 조건문을 설정하지 않으면 잘못된 데이터를 가져올 수 있기 때문에 연관관계를 통해 조건문을 설정해야함 !!!
- 사용 예시
    
    ```sql
    -- 사원들의 사원번호, 근무 부서 번호, 근무 부서 이름을 가져온다.
    -- 사원 번호를 기준으로 오름차순 한다.
    SELECT DE.EMP_NO, DE.DEPT_NO, DP.DEPT_NAME 
    FROM DEPT_EMP DE, DEPARTMENTS DP 
    WHERE DE.DEPT_NO = DP.DEPT_NO
    ORDER BY DE.EMP_NO
    
    -- 각 사원들의 사원번호, FIRST_NAME, 근무 부서 번호를 가져온다.
    SELECT EM.EMP_NO, EM.FIRST_NAME, DE.DEPT_NO FROM EMPLOYEES EM, DEPT_EMP DE
    WHERE DE.DEPT_NO = EM.DEPT_NO
    
    -- 각 사원들의 사원번호, FIRST_NAME, 현재 받고 있는 급여액을 가져온다.
    SELECT EM.EMP_NO, EM.FIRST_NAME, SL.SALARY FROM EMPLOYEES EM, SALARIES SL 
    WHERE EM.EMP_NO = SL.EMP_NO AND SL.TO_DATE = '9999-01-01'
    
    -- 각 사원들의 사원번호, FIRST_NAME, 근무 부서 이름을 가져온다.
    SELECT EM.EMP_NO, EM.FIRST_NAME, DE.DEPT_NAME 
    FROM EMPLOYEES EM, DEPT_EMP DE, DEPARTMENTS DP
    WHERE EM.EMP_NO = DE.EMP_NO AND DE.DEPT_NO = DP.DEPT_NO
    
    ```
    

# SUBQUERY

- 쿼리문 안에 쿼리문이 있는 것
- 조건문 등을 만들 때 값을 직접 지정하지 못하고 **쿼리문을 통해 구해와야 할 경우** 서브쿼리를 통해 값을 구해와 조건문을 완성할 수 있다.
- SUBQUERY로 할 수 있는 쿼리는 JOIN으로 해결 할 수 있음.
- 사용 예시
    
    ```sql
    -- 현재 받는 급여의 평균보다 많이 받는 사원들의 사원번호, 급여액을 가져온다.
    SELECT EMP_NO, SALARY FROM SALARIES
    WHERE SALARY > (SELECT AVG(SALARY) FROM SALARIES WHERE TO_DATE = '9999-01-01')
    AND TO_DATE = '9999-01-01'
    
    -- d001 부서에 근무하고 있는 사원들의 사원번호와 FIRST_NAME을 가져온다.
    SELECT EMP_NO, FIRST_NAME FROM EMPLOYEES
    WHERE EMP_NO IN (SELECT EMP_NO FROM DEPT_EMP WHERE DEPT_NO = 'd001')
    
    SELECT EM.EMP_NO, EM.FIRST_NAME FROM EMPLOYEES EM, DEPT_EMP DE
    WHERE EM.EMP_NO = DE.EMP_NO AND DE.DEPT_NO = 'd001'
    
    -- 1960년 이후에 태어난 사원들의 사원번호, 근무 부서 번호를 가져온다.
    SELECT EMP_NO, DEPT_NO FROM DEPT_EMP
    WHERE EMP_NO IN (SELECT EMP_NO FROM EMPLOYEES WHERE BIRTH_DATE >= '1960-01-01')
    ```