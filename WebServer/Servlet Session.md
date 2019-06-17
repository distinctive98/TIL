# Session

## HttpSession 객체

- HttpSession 객체는 요청을 보내온 클라이언트 단위이다.
- 한 개만 생성되는 객체로서, 생성되면 해당 클라이언트가 종료될 때까지 객체가 유지된다.
- 클라이언트별로 어떤 정보를 원하는 시간까지 유지하고 싶을 때 사용한다.



## Scope

- 메모리에 저장장소가 만들어진 후 언제까지 유지되는가?

1. page scope : 요청된 서버 프로그램이 수행하는 동안 - 지역변수
2. request scope : 요청된 서버 프로그램이 수행하고 응답하기 전까지 - HttpServletRequest 객체의 객체
3. session scope : 세션이 유지되는 동안 - HttpSession 객체에 저장된 객체
4. application scope : 서버가 기동되고 나서 종료될 때까지 - 멤버변수, ServletContext 객체에 저장된 객체



1. 지역변수 : 수행하는 동안, 클라이언트 별로 각각 메모리 할당
2. 멤버변수 : 서버가 종됴될 때까지

클라이언트 별로 개별적 저장, 원할 때까지 유지 --> HttpSession 객체에 보관



- HttpSession 객체는 언제까지 유지되는가?

1. 브라우저가 기동되어 있는 동안
2. invalidate() 메서드가 호출되기 전까지
3. inactive interval 시간이 적용되기 전까지(default : 마지막으로 요청 뒤 30분)



## Session 보관 방법

- 객체로 만든다(배열 객체)
- 저장 : session.setAttribute("이름", 객체)
- 삭제 : session.removeAttribute("이름")
- 추출 : session.getAttribute("이름") (return Object, 강제 형변환 필수)