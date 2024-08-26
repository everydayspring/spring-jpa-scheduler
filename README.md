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

| 기능        | Method | URL                 | request | response       |
|-----------|--------|---------------------|---------|----------------|
| 일정 등록     | POST   | /api/scheduler      | body    | 등록 정보      |
| 선택한 일정 조회 | GET    | /api/scheduler/{id} | param   | 단건 응답 정보 |
| 선택한 일정 수정 | PUT    | /api/scheduler/{id} | body    | 수정 정보      |
| 댓글 등록     | POST   | /api/comment        | body    | 등록 정보      |
| 선택한 댓글 조회 | GET    | /api/comment/{id} | param   | 단건 응답 정보 |
| 선택한 댓긓 수정 | PUT    | /api/comment/{id} | body    | 수정 정보      |


## ERD
### [🔗 ERDCloud](https://) <br/>
![ERD](.png)

## SQL
### [🔗 schedule.sql](https://l) <br/>
![SQL](.png)

