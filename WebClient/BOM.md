# BOM(브라우저 객체 모델)

BOM은 웹 브라우저와 관련된 모든 객체들의 집합입니다. js에는 브라우저의 정보에 접근하거나 브라우저의 기능적 요소들을 직접 제어하고 관리할 수 있는 기능이 있습니다. 브라우저의 객체 모델의 종류는 다음과 같습니다.

- location 객체 : URL의 정보를 제공합니다.
- navigator 객체 : 현재 실행 중인 브라우저의 정보를 제공합니다.
- history 객체 : 방문 기록에 대한 정보를 제공합니다.
- screen 객체 : 모니터의 정보를 제공합니다.
- document 객체 : 문서에 대한 정보를 제공합니다.



## window 객체

window BOM의 최상위 객체입니다. window의 형체와 위치를 변경할 수 있는 메서드입니다. window는 생략이 가능합니다. window 객체 메서드는 다음과 같습니다.

| 메서드         | 설명                                                |
| -------------- | --------------------------------------------------- |
| open()         | 새로운 윈도우 객체를 생성합니다.                    |
| alert()        | 경고창을 띄웁니다.                                  |
| prompt()       | 입력창을 띄웁니다.                                  |
| confirm()      | 확인/취소 창을 띄웁니다.                            |
| setInterval()  | 일정 시간마다 실행합니다.                           |
| setTimeout()   | 타이머의 시간이 만료된 후 실행문을 수행합니다.(1회) |
| scrollBy(x, y) | 윈도우 스크롤의 위치를 상대 위치로 이동합니다.      |
| scrollTo(x, y) | 윈도우 스크롤의 위치를 절대 위치로 이동합니다.      |
| focus()        | 윈도우에 초점을 맞춥니다.                           |
| blur()         | 윈도우에 초점을 제거합니다.                         |
| close()        | 윈도우를 닫습니다.                                  |

```javascript
window.onload = function(){
    var win = window.open('win1.html', '', 'width=300, height=200');
    win.moveTo(100,100);
    
    //1초마다 윈도우 창을 이동한다.
    window.setInterval(function(){
        win.moveBy(20,20);
    }, 1000);
    
    //5초 후에 윈도우 창을 종료한다.
    window.setTimeout(function(){
        win.close();
    }, 5000);
}
```



## location 객체

location 객체는 URL과 관련된 인터넷의 주소와 관련된 속성입니다. 프로토콜, 호스트 이름, 문서 주소 등의 정보가 있습니다. location 객체 속성 및 메서드는 다음과 같습니다.

| 속성 및 메서드 | 설명                                  |
| -------------- | ------------------------------------- |
| href           | 문서의 url 주소를 반환합니다.         |
| host           | 호스트 이름과 포트 번호를 반환합니다. |
| hostname       | 호스트 이름을 반환합니다.             |
| port           | 포트 번호를 반환합니다.               |
| path           | 파일 경로를 반환합니다.               |
| protocol       | 프로토콜을 반환합니다.                |
| reload()       | 화면을 새로 고침합니다.               |
| replace(link)  | 현제 페이지를 link 페이지로 바꿉니다. |



## navigator 객체

navigator 객체는 웹 브라우저에 대한 정보를 제공하는 객체입니다. 브라우저의 종류나 버전 정보를 파악하기 위해 사용합니다. navigator 객체 속성은 다음과 같습니다.

| 속성        | 설명                                               |
| ----------- | -------------------------------------------------- |
| appCodeName | 브라우저의 코드명을 반환합니다.                    |
| appName     | 브라우저의 이름을 반환합니다.                      |
| language    | 브라우저의 사용 언어를 반환합니다.                 |
| product     | 브라우저의 사용 엔진 이름을 반환합니다.            |
| platform    | 사용중인 운영체제의 시스템 환경 정보를 반환합니다. |



## history 객체

history 객체는 인터넷 방문 기록에 대한 정보를 제공하는 객체입니다.

| 메서드    | 설명                                         |
| --------- | -------------------------------------------- |
| go(n)     | n만큼 페이지를 이동합니다.                   |
| back()    | 이전 페이지로 이동합니다.                    |
| forward() | 다음 페이지로 이동합니다.                    |
| length    | 방문 기록에 저장된 목록의 개수를 반환합니다. |



## screen 객체

screen 객체는 현재 화면의 해상도나 색상, 화면의 크기 정보 등의 속성을 제공하는 객체입니다.

| 속성        | 설명                                             |
| ----------- | ------------------------------------------------ |
| width       | 전체 화면의 너비입니다.                          |
| height      | 전체 화면의 높이입니다.                          |
| availWidth  | 전체 화면에서 사용 가능한 화면의 너비입니다.     |
| availHeight | 전체 화면에서 사용 가능한 화면의  높이입니다.*** |

