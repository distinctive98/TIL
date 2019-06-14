# Servlet

- Java 언어로 구현하는 웹 프로그래밍 기술
- CGI의 단점을 보완해서 나온 것이 Servlet
- 멀티쓰레드 (메모리 사용이 효율적)
- Servlet은 Servlet(컨테이너)를 통해 수행(Web Server가 직접 수행하는 것이 아님)
- Tomcat : Web Server(코요테) + Application Server(카탈리나) = WAS(Web Application Server)



## Servlet 프로그래밍 정리

1. HttpServlet 클래스를 상속
   - HttpServletRequest : 요청 정보를 추출하고자 할 때(쿼리 문자열)
   - HttpServletResponse : 응답과 관련하여 응답 스트림 객체, 컨텐트 타입 설정

2. Servlet의 수행상의 특징
   - Servlet은 한 번 메모리 할당(객체 생성)되면 할당된 상태를 계속 유지한다.
   - 여러 클라이언트 요청에 대해서 하나의 Servlet 객체를 공유해서 수행한다.
   - 각 시점마다 호출되는 메서드가 정해져 있다.
     - 객체 생성 후 - init()
     - 요청이 올 때마다 - service(), doGet(), doPost()
     - 객체 해제 전 - destroy()

3. 쿼리 문자열 추출 방법
   - name=value&name=value&name=value&...
   - HttpServletRequest 객체의 getParameter()로 추출
   - String getParameter(String) : value 값, null, 또는 ""
   - String[] getParameterValues(String) : value 값들의 배열 또는 null
   - Get 방식의 경우에는 Query 문자열 추출 시 한글이 깨지지 않음
   - Post 방식은 깨지므로 추출 전에 request.setCharacterEncoding("UTF-8") 호출