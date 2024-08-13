1.일정 조회

+ API 명 : 단일 일정 조회
+ HTTP METHOD : GET
+ URL : /todolist/{id}
+ Request :
  ```
  {
    ”id”:03,
    ”name”:”김길환”,
    "manager”:”신창섭",
    ”todo”:”정상화”,
    ”creationdate”:2024-08-13 12:34:56,
    ”modifydate”:2024-08-13 12:34:56
  }
  ```
+ Response :
  ```
  '200 OK' 데이터 조회 성공
  '400 Bad Request' 요청 본문이 잘못된 경우
  '401 Unauthorized' 인증이 실패한 경우
  '404 Not Found' 사용자를 찾을수 없음
  ```
