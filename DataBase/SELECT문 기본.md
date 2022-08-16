# SELECT 문 기본

### SELECT 기본 문법

- SELECT 구문은 저장되어있는 데이터를 가져올 때 사용한다.
- 작성 요령
    - SELECT 컬럼 FROM 테이블명
    - EX) SELECT * FROM EMPLOYEES
- 사용 예시
    
    ```sql
    -- 사원의 정보를 모두 가져온다
    SELECT * FROM EMPLOYEES
    
    -- 부서 정보를 모두 가져온다
    SELECT * FROM DEPARTMENTS
    
    -- 부서 관리자 정보를 모두 가져온다
    SELECT * FROM DEPT_MANAGER
    
    -- 사원들 직함 정보를 모두 가져온다
    SELECT * FROM TITLES
    ```
    
- 일부 컬럼만 가져오기
    - SELECT 컬렴명1, 컬럼명2, 컬렴명3, … FROM 테이블명
- 사용예시
    
    ```sql
    -- 사원의 사원번호, 이름을 가져온다
    SELECT EMP_NO, FIRST_NAME, LAST_NAME FROM EMPLOYEES
    
    -- 사원의 사원번호, 생년월일, 성별을 가져온다
    SELECT EMP_NO, BIRTH_DATE, GENDER FROM EMPLOYEES
    
    -- 부서의 부서번호, 부서 이름을 가져온다
    SELECT DEPT_NO, DEPT_NAME FROM DEPARTMENTS
    
    -- 각 사원의 사원번호, 급여액을 가져온다
    SELECT EMP_NO, SALARY FROM SALARIES
    
    -- 각 사원의 사원번호, 직함 이름을 가져온다
    SELECT EMP_NO, TITLE FROM TITLES
    ```
    

## 연산자 사용하기

### 산술연산자

- \+ : 더하기
    - SELECT 10 + 20;
- \- : 빼기
    - SELECT 20 - 10;
- \* : 곱하기
    - SELECT 20 * 10
- / : 나누기
    - SELECT 20 / 10
- 사용 예시
    
    ```sql
    -- 각 사원의 급여를 10% 인상된 금액을 가져온다.
    SELECT EMP_NO, SALARY, SALARY * 1.1 FROM SALARIES
    
    -- 각 사원의 급여를 10% 인하된 금액을 가져온다.
    SELECT EMP_NO, SALARY, SALARY * 0.9 FROM SALARIES
    ```
    

### DISTINCT 연산자

- 가져온 결과에서 중복을 제거한다.
- SELECT DISTINCT 컬럼명 FROM 테이블명
- 사용 예시
    
    ```sql
    -- 근무 부서 테이블에서 부서 번호를 가져온다
    SELECT DISTINCT DEPT_NO FROM DEPT_EMP
    -- 각 사원들의 직함을 중복되지 않게 가져온다.
    SELECT DISTINCT TITLE FROM TITLES
    ```
    

### 조건 사용하기

- SELECT 구문에 WHERE 절을 사용하면 조건을 설정할 수 있다.
- 컬럼에 저장되어 있는 데이터를 기준으로 검색하여 원하는 데이터만 뽑아올 수 있다.
- 조건 연산자 (=, >,<, ≥, ≤, <>)
- 사용예시
    
    ```sql
    -- D005 부서의 사원의 사원 번호, 부서번호를 가져온다
    SELECT EMP_NO, DEPT_NO FROM DEPT_MANAGER WHERE DEPT_NO = 'd005'
    
    -- 부서가 d003이 아닌 매니저 사원들의 사원번호와 부서 번호를 가져온다
    SELECT EMP_NO, DEPT_NO FROM DEPT_MANAGER WHERE DEPT_NO <> 'd003'
    
    -- 급여가 150000 이상인 사원들의 사원 번호, 급여를 가져온다.
    SELECT EMP_NO, SALARY FROM SALARIES WHERE SALARY >= 150000
    
    -- 급여가 40000 이하인 사원들의 사원 번호, 급여를 가져온다.
    SELECT EMP_NO, SALARY FROM SALARIES WHERE SALARY <= 40000
    
    -- 1986년 이후에 입사한 사원들의 정보
    SELECT EMP_NO, HIRE_DATE, FIRST_NAME, LAST_NAME FROM EMPLOYEES 
    WHERE HIRE_DATE >= '1986-01-01'
    
    -- 1990년 이후에 매니저가 된 사원들의 사원번호, 부서번호, 매니저 시작 날짜를 가져온다
    SELECT EMP_NO, DEPT_NO, FROM_DATE FROM DEPT_MANAGER WHERE FROM_DATE >= '1990-01-01';
    
    -- 1990년 이전에 입사한 사원들의 사원번호, 입사일을 가져온다.
    SELECT EMP_NO, HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE < '1990-01-01'
    ```
    

### 논리 연산자

- 두 개 이상의 조건문을 작성할 때 사용하는 연산자
- AND : 양쪽 조건을 모두 만족
- OR : 양쪽 조건 중 하나만 만족해도 선택
- NOT : 조건의 결과를 반대로 부정
- 사용 예시
    
    ```sql
    	-- d001부서의 매니저 중에 1990년 이후부터 매니저인 사원의 사원번호, 부서번호, 매니저 시작 날짜를 가져온다.
    SELECT EMP_NO, DEPT_NO, FROM_DATE FROM DEPT_MANAGER 
    WHERE DEPT_NO = 'd001'AND FROM_DATE >= '1990-01-01'
    
    -- 1990년 이후에 입사한 남자 사원의 사원번호, 성별, 입사일을 가져온다.
    SELECT EMP_NO, GENDER, HIRE_DATE FROM EMPLOYEES 
    WHERE HIRE_DATE >= '1990-01-01' AND GENDER = 'M'
    
    -- 1990년 이후부터 60000 이상의 급여를 받는 사원의 사원번호, 급여, 급여 수령 시작 날짜를 가져온다.
    SELECT EMP_NO, SALARY, FROM_DATE FROM SALARIES 
    WHERE FROM_DATE >= '1990-01-01' AND SALARY >= 60000
    
    -- d001 부서와 d002 부서 매니저의 사원 번호, 부서 번호를 가져온다.
    SELECT EMP_NO, DEPT_NO FROM DEPT_MANAGER
    WHERE DEPT_NO = 'd001' OR DEPT_NO = 'd002'
    
    -- 직함이 Staff인 사원과 Engineer인 사원의 사원번호, 직합을 가져온다.
    SELECT EMP_NO, TITLE FROM TITLES
    WHERE TITLE = 'Staff' or title = 'Engineer'
    
    -- d003 부서의 매니저가 아닌 매니저의 사원번호, 부서번호를 가져온다.
    SELECT EMP_NO, DEPT_NO FROM DEPT_MANAGER
    WHERE NOT DEPT_NO = 'd003'
    ```
    

### Between

- 컬럼의 범위를 조건으로 사용할 때 사용
- AND 대신 사용
- 컬럼명 BETWEEN 값1 AND 값2
- 사용 예시
    
    ```sql
    -- 급여가 60000이상 70000 미만인 사원들의 사원번호, 급여를 가져온다.
    SELECT EMP_NO, SALARY FROM SALARIES WHERE SALARY >= 60000 AND SALARY < 70000
    SELECT EMP_NO, SLALRY FROM SALARIES WHERE SALARY BETWEEN 60000 AND 69999
    ```
    

### IN

- 지정된 컬럼의 값이 특정 값에 해당되는 조건을 만들 때 사용한다.
- OR 대신 사용한다
- 컬럼명 IN (값1, 값2 …)
- 사용 예시
    
    ```sql
    -- d001 부서와 d002 부서 매니저의 사원 번호, 부서 번호를 가져온다.
    SELECT EMP_NO, DEPT_NO FROM DEPT_MANAGER WHERE DEPT_NO IN ('d001', 'd002')
    ```
    

### LIKE

- 조건식을 만들어 줄 때 문자열과 비교 시 사용한다
- 문자열 값을 비교할 때 = 을 이용하면 지정된 문자열이 저장된 문자열이 저장되어 있는 로우를 가져올 수 있다.
- LIKE는 이를 보다 확장해서 조건을 만들어 줄 때 사용한다.
- LIKE는 와일드 카드라는 개념을 사용하는데, 와일드 카드는 모든 글자를 의미하는 특수 기호이다.
- _ : 글자 하나를 의미
- % : 글자 수와 상관 없이 모든 글자를 의미
- 사용 예시
    
    ```sql
    -- 이름이 Tommaso 사원의 사원번호, 이름을 가져온다.
    SELECT EMP_NO, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME LIKE 'Tommaso'
    
    -- 이름의 첫 글자가 A로 시작하는 사원의 사원번호, 이름을 가져온다.
    SELECT EMP_NO, FIRST_NAME FROM EMPLOYEES WHERE FIRST_NAME LIKE 'A%'
    
    -- 이름의 마지막 글자가 s로 끝나는 사원의 사원번호, 이름을 가져온다.
    SELECT EMP_NO, FIRST_NAME FROM EMPLOYEES WHERE FIRST_NAME LIKE '%s'
    
    -- 이름의 두 번째 글자가 i인 사원의 사원번호, 이름을 가져온다.
    SELECT EMP_NO, FIRST_NAME FROM EMPLOYEES WHERE FIRST_NAME LIKE '_i%'
    
    -- 이름에 O가 포함되어 있는 사원의 사원번호, 이름을 가져온다.
    SELECT EMP_NO, FIRST_NAME FROM EMPLOYEES WHERE FIRST_NAME LIKE '%o%'
    
    -- 이름에 O가 포함되어 있는 사원의 사원번호, 이름을 가져온다. 
    -- 단 마지막 글자가 O가 아닌 사원만 가져온다.
    SELECT EMP_NO, FIRST_NAME FROM EMPLOYEES 
    WHERE FIRST_NAME LIKE '%o%' AND NOT FIRST_NAME LIKE '%o'
    
    -- 이름이 5글자인 사원들의 사원 번호, 이름을 가져온다.
    SELECT EMP_NO, FIRST_NAMR FROM EMPLOYEES WHERE FIRST_NAME LIKE '_____'
    ```
    

### 정렬

- 데이터를 가져올 때 오름차순 혹은 내림 차순으로 정렬하여 가져올 수 있다.
- ORDER BY 컬럼명 [ ASC | DESC ] : ASC - 오름차순 / DESC - 내림차순
- 정렬 기준은 숫자, 문자열, 날짜 등 모든 컬럼이 가능하다.
- 사용 예시
    
    ```sql
    -- 사원의 번호와 급여를 가져온다. 급여를 기준으로 오름차순 정렬한다.
    SELECT EMP_NO, SALARY FROM SALARIES ORDER BY SALARY ASC
    
    -- 사원의 번호와 급여를 가져온다. 급여를 기준으로 내림차순 정렬한다.
    SELECT EMP_NO, SALARY FROM SALARIES ORDER BY SALARY DESC
    
    -- 사원의 번호와 이름을 가져온다. 이름을 기준으로 오름차순 정렬한다.
    SELECT EMP_NO, FIRST_NAME FROM EMPLOYEES ORDER BY FIRST_NAME
    
    -- 사원의 번호와 이름을 가져온다. 이름을 기준으로 내림차순 정렬한다.
    SELECT EMP_NO, FIRST_NAME FROM EMPLOYEES ORDER BY FIRST_NAME DESC
    
    -- 사원의 사원의 번호와 입사일을 가져온다. 입사일을 기준으로 오름차순 정렬한다.
    SELECT EMP_NO, HIRE_DATE FROM EMPLOYEES ORDER BY HIRE_DATE
    
    -- 사원의 사원의 번호와 입사일을 가져온다. 입사일을 기준으로 내림차순 정렬한다.
    SELECT EMP_NO, HIRE_DATE FROM EMPLOYEES ORDER BY HIRE_DATE DESC
    ```