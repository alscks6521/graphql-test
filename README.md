## Git협업, GraphQL 수업 

### 기존 주제 : 

닉네임 생성기 

### GraphQL 기능 역할: 
**1. DTO :** 김유진 

**2. Create :** 김민기, 백예준 

**3. Find 조회 :** 김민성, 김시온
#
### 팀 작업중 발생한 문제

#### develop 작업 브랜치에서의 병합 과정 충돌 
**원인 :** 각기 기능 구현을 같은 파일 내에서 개발, 병합이 이루어짐 

**해결 :** 이러한 경우, 복잡하지만 각 브랜치에 전부 develop의 최신 버전을 다시 pull하여 진행한다 

**방지 :** 각기 기능을 독립성가질 수 있게 서로 영향을 주지 않게 파일 분리   
#
### 팀 브랜치 관리 방법 
**브랜치 :** Master -> Develop ⇉ Feature(각자 브랜치...등)  

**Pull Request 사용**  
#
<img width="700" alt="image" src="https://github.com/alscks6521/api-test/assets/112923685/28cd8294-0166-4fd4-9bae-0c887361d871">
<img width="700" alt="image" src="https://github.com/alscks6521/api-test/assets/112923685/f1ef04ce-5f14-4faa-bc39-b5ebc9b7c794">

**칸반(Kanban) 보드의 전자적 형태**
<img width="997" alt="image" src="https://github.com/alscks6521/api-test/assets/112923685/423530b8-20c7-4fe3-b287-cde80dd91cfd">


---

[API & GRAPHQL]
5주차 API 와 GRAPHQL 실습
간단한 실습으로 확인해보는 API 와 GRAPHQL
#
### 접속 방법
## API (SWAGGER-UI)
http://localhost:8080/swagger-ui/index.html

## GraphQL (GRAPHIQL)
http://localhost:8080/graphiql
