# 나만의 일정 관리 앱 서버 만들기

## ⚙ STACK
![](https://img.shields.io/badge/SpringBoot-6db33f?style=flat-square&logo=springboot&logoColor=white)
![](https://img.shields.io/badge/Gradle-02303a?style=flat-square&logo=gradle&logoColor=white)
![](https://img.shields.io/badge/IntelliJ-000000?style=flat-square&logo=intellijidea&logoColor=white)
![](https://img.shields.io/badge/Postman-ff6c37?style=flat-square&logo=postman&logoColor=white)
![](https://img.shields.io/badge/Git-f05032?style=flat-square&logo=git&logoColor=white)

<div style="display: flex; align-items: flex-start;">
<img src="https://techstack-generator.vercel.app/java-icon.svg" alt="icon" width="65" height="65" />
<img src="https://techstack-generator.vercel.app/mysql-icon.svg" alt="icon" width="65" height="65" />
<img src="https://techstack-generator.vercel.app/github-icon.svg" alt="icon" width="65" height="65" />
<img src="https://techstack-generator.vercel.app/restapi-icon.svg" alt="icon" width="65" height="65" />
</div>

## API
### [🔗 API Document](https://)

| 기능      | Method | URL               | request | response |
|---------|--------|-------------------|---------|----------|
| 일정 등록   | POST   | /api/todos        | body    | 등록 정보    |
| 일정 단건 조회 | GET    | /api/todos/{id}   | param   | 단건 응답 정보 |
| 일정 수정   | PUT    | /api/todos/{id}   | body    | 수정 정보    |
| 댓글 등록   | POST   | /api/comment      | body    | 등록 정보    |
| 댓글 단건 조회 | GET    | /api/comment/{id} | param   | 단건 응답 정보 |
| 댓글 전체 조회 | GET    | /api/comment      | param   | 다건 응답 정보 |
| 댓글 수정   | PUT    | /api/comment/{id} | body    | 수정 정보    |
| 댓글 삭제   | DELETE | /api/comment/{id} | param   | 삭제 정보    |


## ERD
### [🔗 ERDCloud](https://) <br/>
![ERD](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FyoMty%2FbtsJgDlR8dy%2FO2pFZy6bmX8CFRJno80kK1%2Fimg.png)

## SQL
### [🔗 schedule.sql](https://github.com/everydayspring/spring-jpa-scheduler/blob/main/query.sql) <br/>
![SQL](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fsw0R7%2FbtsJgEd3lJE%2FIZ1C9swPLekPZAnxhrRD2k%2Fimg.png)

