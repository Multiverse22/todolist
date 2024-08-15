1.일정 조회

+ API 명 : 단일 일정 조회
+ HTTP METHOD : GET
+ URL : api/todolist/{id}
+ Request : @Pathvariable = id값

+ Response :
  ```
  {
    ”id”:03,
    "managerName”:”신창섭",
    ”toDoListContents”:”정상화”,
    ”creationDate”:2024-08-13 12:34:56,
    ”modifiedDate”:2024-08-13 12:34:56,
    "password":null
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
+ URL : api/todolist
+ Request :
  ```
  {
    "managerName”:”신창섭",
    ”toDoListContents”:”정상화”,
    ”creationdate”:2024-08-13 12:34:56,
    ”modifiedDate”:2024-08-13 12:34:56,
    "password":"q1w2e3"
  }
  ```

+ Response :
  ```
  {
    ”id”:03,
    "managerName”:”신창섭",
    ”toDoListContents”:”정상화”,
    ”creationdate”:2024-08-13 12:34:56,
    ”modifiedDate”:2024-08-13 12:34:56,
    "password”:null
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
+ URL : api/todolist/{id}
+ Request :
  ```
  {
    "id":"10",
    "managerName": "김갑환",
    "toDoListContents": "집에있기",
    "creationDate": "1999-06-20 11:11:11",
    "modifiedDate": "1999-06-20 11:11:11",
    "password": "qqq"
  }
  ```

+ Response :
  ```
  {
    "id": 10,
    "managerName": "김갑환",
    "toDoListContents": "집에있기",
    "creationDate": "1999-06-20 11:11:11",
    "modifiedDate": "2024-08-15 17:05:31",
    "password": null
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
+ Request : @PathVariable id,RequestDto

+ Response :
  ```
  {
   id값을 반환
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
+ URL : /todolist/inquiry/{value}
+ Request :@PathVariable int value, @RequestParam(required = false) String managerName, @RequestParam(required = false) Timestamp modifiedDate
+
+ 요청 파라미터 수정일 or 담당자명 한가지를 충족하는 경우, 한가지도 충족하지 않는 경우, 둘 다 충족하는 경우가 존재합니다. 수정일은 내림차순으로 정렬합니다.

+ Response :
  ```
  예 http://localhost:8080/api/todolist/inquiry/0?managerName=김길환
    {
        "id": 7,
        "managerName": "집에서쉬기",
        "toDoListContents": "김길환",
        "creationDate": "1999-06-20 11:11:11",
        "modifiedDate": "1999-06-20 11:11:11",
        "password": null
    },
    {
        "id": 9,
        "managerName": "집가고싶다",
        "toDoListContents": "김길환",
        "creationDate": "1999-06-20 11:11:11",
        "modifiedDate": "1999-06-20 11:11:11",
        "password": null
    }
  ```
  ```
+ 상태코드 :
  ```
  '200 OK' 데이터 목록 조회 성공
  '404 Not Found' 사용자를 찾을수 없음
  ```
***
ERD 다이어그램
![image](https://github.com/user-attachments/assets/b1f1dc44-f06d-461b-9b4e-a4bb9acd976c)

다이어그램 변경점 id(primary key) -> id(primary key,auto increment)

todo->toDoListContents

creationdate->creationDate

modifydate->modifiedDate

manager->managerName



