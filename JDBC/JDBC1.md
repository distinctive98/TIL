# JDBC 프로그래밍 정리

## JDBC API, Driver

- JDBC API(interface) : SQL문에 대한 규약을 정해놓음(java.sql)

- JDBC Driver: DB서버에 맞는 드라이버

  위 두개를 통해 DB서버와 무관하게 JDBC를 사용할 수 있음



## JDBC 프로그램의 구현 과정

1. JDBC 드라이버 로딩 -> Class.forName(대표 클래스 이름)
2. DB서버 접속 -> DriverManager.getConnection(JDBCURL, ID, PW)
3. Statement, PreparedStatement 객체 생성
   - PreparedStatement 사용시 SQL문에 데이터를 동적으로 입력할 경우 ? 사용
   - **Connection** 객체의 팩토리메서드를 사용하여 객체를 생성해야 함

4. executeQuery(), executeUpdate()
   - executeQuery()는 ResultSet객체를 반환함
     - executeQuery()는 SELECT문 전용 메서드임
     - ResultSet객체에서 next(), getString() 메소드 등을 통해 데이터를 얻을 수 있음
   - exeuteUdate()는 int형 데이터를 반환함(변화된 행 개수)
     - exeuteUpdate()는 DDL, DML 문을 사용할 수 있는 메서드임

5. 연결된 자원 해제 : close()