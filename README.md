1.일정 조회

+ API 명 : 단일 일정 조회
+ HTTP METHOD : GET
+ URL : /todolist/{id}
+ Request : 요청 파라미터 = Id

+ Response :
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
+ 상태코드 :
  ```
  '200 OK' 데이터 조회 성공
  '400 Bad Request' 요청 본문이 잘못된 경우
  '401 Unauthorized' 인증이 실패한 경우
  '404 Not Found' 사용자를 찾을수 없음
  ```
* * *
2.일정 작성

+ API 명 : 일정 생성
+ HTTP METHOD : POST
+ URL : /todolist
+ Request :
  ```
  {
    ”name”:”김길환”,
    "manager”:”신창섭",
    ”todo”:”정상화”,
    ”creationdate”:2024-08-13 12:34:56,
    ”modifydate”:2024-08-13 12:34:56,
    "password":"q1w2e3"
  }
  ```

+ Response :
  ```
  {
    ”id”:03,
    ”name”:”김길환”,
    "manager”:”신창섭",
    ”todo”:”정상화”,
    ”creationdate”:2024-08-13 12:34:56,
    ”modifydate”:2024-08-13 12:34:56,
    "password”:”q1w2e3"
  }
  ```
+ 상태코드 :
  ```
  '200 OK' 데이터 조회 성공
  '400 Bad Request' 요청 본문이 잘못된 경우
  '401 Unauthorized' 인증이 실패한 경우
  '404 Not Found' 사용자를 찾을수 없음
  ```
* * *
  3.일정 수정

+ API 명 : 일정 업데이트
+ HTTP METHOD : PUT
+ URL : /todolist/{id}
+ Request :
  ```
  {
    "manager":"이길환",
    ”todo":"넷플보기”,
    "password":"q1w2e3"
  }
  ```

+ Response :
  ```
  {
    "id":03,
    "manager":"이길환",
    ”todo":"넷플보기”,
    "modifydate":2024-08-09 11:22:33
  }
  ```
+ 상태코드 :
  ```
  '200 OK' 데이터 수정 성공
  '400 Bad Request' 요청 본문이 잘못된 경우
  '401 Unauthorized' 인증이 실패한 경우
  '404 Not Found' 사용자를 찾을수 없음

  ```
* * *
 4.일정 삭제

+ API 명 : 일정 삭제
+ HTTP METHOD : DELETE
+ URL : /todolist/{id}
+ Request : 요청 파라미터 = Id

+ Response :
  ```
  {
  "message":"성공적으로 삭제 되었습니다."
  }
  ```
+ 상태코드 :
  ```
  '200 OK' 데이터 삭제 성공
  '400 Bad Request' 요청 본문이 잘못된 경우
  '401 Unauthorized' 인증이 실패한 경우
  '404 Not Found' 사용자를 찾을수 없음
  ```
* * *
5.일정 목록 조회

+ API 명 : 일정 목록 조회
+ HTTP METHOD : GET
+ URL : /todolist
+ Request : 요청 파라미터 수정일 or 담당자명 한가지를 충족하는 경우, 한가지도 충족하지 않는 경우, 둘 다 충족하는 경우가 존재합니다. 수정일은 내림차순으로 정렬합니다.

+ Response :
  ```
  {
  "todolist":[
    {
    ”id”:03,
    ”name”:”김길환”,
    "manager”:”김갑환",
    ”todo”:”장보기”,
    ”creationdate”:2024-08-12 12:34:56,
    ”modifydate”:2024-08-12 12:34:56,
    },
    {
    ”id”:04,
    ”name”:”일론머스크”,
    "manager”:”크리스",
    ”todo”:”트위터업데이트”,
    ”creationdate”:2024-08-13 12:34:56,
    ”modifydate”:2024-08-13 12:34:56,
    }
  ],
  "total":2
  }
  ```
+ 상태코드 :
  ```
'200 OK' 데이터 목록 조회 성공
'404 Not Found' 사용자를 찾을수 없음
  ```
