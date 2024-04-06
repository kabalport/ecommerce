# `e-커머스 상품 주문 서비스`

# 마일스톤
- ~~요구사항분석~~
- ~~플로우차트=> 머메이드로 수정 04.05~~
- ~~시퀀스다이어그램=> 머메이드로 수정 04.05~~
- ~~erd => 머메이드로 수정 04.05~~
- Mockapi 04.08

## 4주차
주문결제 할때 Order table 이랑 order_item table 이 사실상 필수다.
erd,시퀀스 - 노션, 머메이드
시스템아키텍처 - 이레이저
PG 연동
문서작성능력이
컨틀롤러,인프라스트럭쳐는 상관없지만 도메인은 테스트커버리지100으로 하는 연습을 해야 퇴근이 빨라진다.
새로운 피처가 들어오는 경우 3~5단계로 나눠요
업데이트를 하는순간 베타락이 걸린다. 베타락이 걸려서 

격리레벨,베타락 중요

베타락 mvcc
원트랜잭션
주문서 만드시고 재고차감 결제생성 리턴
프론트 토스결제 sdk호출

주문 결제
장바구니에 담아요
아이템 -> 장바구니(n개) -> checkout -> 결제페이지 > 결제정보를 입력
(주소,결제수단) >> 결제하기
---
무신사 카드사ㅣ 나와있는 결제창이 뜬다.
결제창은 무신사가 아니다.
실제로는 토스사이트가 팝업으로 뜨는것이다.
팝업의 주소가 토스입니다
그러면 어떻게 가능한것이냐
무신사에 결제sdk가 자바스크립트로 깔려있는데 거기에 open결제을 쓰는것이다.
결제sdk가 팝업을 띄어주고 결제하기를 누르면 카드번호난 토스결제같은경우 휴대폰번호를 누르면
결제하시면 sdk화면에서 토스서버로 결제요청을 하고 토스서버가 사용자 휴대폰으로 푸시보내고
사용자가 생체인증 통해서 결제하고 다시 휴대폰 토스서버 결제완료하고 토스서버에서 결제정보 상태를 저장
리다이렉트 url로 요청을 보내준다.
무신사가 토스한테 url을준다. "v1/tosss/paymet" 파라미터로 요청
파라미터에 뭐가 담기냐 - 결제수단, 결제금액, 결제키, 주문키(식별키)식별키는 sdk에 결제요청할때 저의의 임의값을 그대로 돌려줘요 너가 요청했던것을 알수있게함

토스 -> v1/toss/payment {
1. 주문생성(마이크로 서비스로 빠질수 있음)
2. 재고차감(마이크로 서비스로 빠질수 있음)
3. 포인트추가(마이크로 서비스로 빠질수 있음)
return "결제완료"
}

비동기로하면 무슨일로 생기나요?
결제는 완료됬는데 포인트가 추가 안될수도 있다. 재고차감도 안될수도있다.

10개중에 9개 팔려서 1개 남았어
=== 
아이템_서비스
아이템_서비스, 결제했는데 취소되는경험.
===

환불절차가 실행된다.
환불해버려요

order,order_item의 테이블을 분리해야 하는 이유를 잘 모르겠습니다.

주문
뉴진스 티셔츠 order_item 결제완료
와이드 팬츠 order_item 결제완료
아일릿 백팩(이거 출고 안되 취소를 해야되) order_item status: 결제취소

주문서 Order를 생각해보세요
- 김밥
- 키토김밥
- 라면
- 떡라면
- 떡볶이
- 납작만두

메시지 각각의 ttl이 필요하다.

격리레벨은 db마다 다르고 3~6단계
컨텍스트 한정 격리레벨이 디비마다 3~5단계로 다 다른데 mysql기준
ㅓㅔㅁ, 쇼ㅔ대그dptjsms ㄱ덷ㅁㅅ뮤ㅣㄷ ㄱㄷㅁㅇrk 


jpa에서는 repeatabel read가 보장되기때문에 mysql dmf tkdydgkekekaus committed read로
디비 서절을 낮춰서 사용하면 리소스 이득이었다.

@Transactional(Isolation.level == "")
격리레벨 설정 x 디볼트 값이 뭔지 알고있어야 한다.
Isolation.Default <- 디비 설정 따라간다.

propagation을 공부하면되는데 변경할일이 그렇게 만들지않을것이다.

MysqlRepository

상품
상품정보
상품옵션
상품재고

데이터베이스 테이블 설계 팁
- 테이블은 동일한 위상읜 데이터 군집으로 구성한다.
- 적절한 정규화, 반정규화를 통해 데이터를 구성한다.
- 정규화는 쓰기 성능을 증가시킨다.
- 반정규화(비정규화) 읽기성능을 증가시킨다.

# 요구사항 분석
### 유스케이스
- 포인트 조회
- 포인트 충전
### 다이어그램(플로우차트,시퀀스다이어그램)
포인트 조회 : 사용자 식별자를 통해 해당 사용자의 포인트를 조회합니다.
```mermaid
flowchart TD
  조회[사용자 포인트 조회] --> 조회결과{조회 결과 확인}
  조회결과 -- "포인트 정보 있음" --> 반환[사용자 포인트 정보 반환]
  조회결과 -- "포인트 정보 없음" --> 생성[빈 포인트 정보 생성]
  생성 --> 반환
```
```mermaid
sequenceDiagram
    participant 클라이언트
    participant 서버
    participant 데이터베이스

    클라이언트->>+서버: 멤버 ID로 포인트 조회 요청
    서버->>+데이터베이스: 멤버 ID로 사용자 포인트 조회
    데이터베이스-->>-서버:  반환
```
포인트충전 : 사용자 식별자 및 충전할 금액을 받아 포인트를 충전합니다.
```mermaid
flowchart TD
    포인트충전(포인트충전) --> 기존포인트+충전금액{"기존포인트+충전금액"}
    기존포인트+충전금액 --> 포인트갱신[포인트 갱신]
```
상품주문 
- 사용자의 상품을 주문하고 결제하고 외부데이터플랫폼에 주문정보를 전송합니다.
- 사용자 식별자와 (상품 ID, 수량) 목록을 입력받아 주문하고 결제를 수행합니다.
- 사용자는 상품을 여러 개 선택해 주문할 수 있고, 미리 충전한 잔액을 이용합니다.
- 동시에 여러 주문이 들어올 경우, 유저의 보유 잔고에 대한 처리가 정확해야 합니다.
- 각 상품의 재고 관리가 정상적으로 이루어져 잘못된 주문이 발생하지 않도록 해야 합니다.
- 결제는 기 충전된 잔액을 기반으로 수행하며 성공할 시 잔액을 차감해야 합니다.
- 데이터 분석을 위해 결제 성공 시에 실시간으로 주문 정보를 데이터 플랫폼에 전송해야 합니다.
- 데이터 플랫폼이 어플리케이션 `외부` 라는 가정만 지켜 작업해 주시면 됩니다
- 데이터 플랫폼으로의 전송 기능은 Mock API, Fake Module 등 다양한 방법으로 접근해 봅니다.
```mermaid
sequenceDiagram
    participant 클라이언트
    participant 서버
    participant 데이터베이스
    participant 외부데이터플랫폼

    클라이언트->>+서버: 상품 주문 요청(사용자 ID, 상품ID및수량 목록)
    서버->>+데이터베이스: 주문 정보 확인(사용자 잔액, 상품 재고 조회)
    데이터베이스-->>-서버: 잔액 및 재고 확인 결과
    alt "모든 상품 재고 충분 및 잔액 충분"
        서버->>+데이터베이스: "주문 데이터 생성 및 재고 감소, 잔액 차감"
        데이터베이스-->>-서버: "주문 성공 응답"
        서버->>+외부데이터플랫폼: "주문 정보 전송"
        외부데이터플랫폼-->>-서버: "데이터 전송 성공 응답"
        서버-->>-클라이언트: "주문 및 결제 성공 응답"
    end
```
[상품조회]
- 이커머스 상품 정보 ( ID, 이름, 가격, 잔여수량 ) 을 조회합니다.
- 조회시점의 상품별 잔여수량이 정확하면 좋습니다.
[인기판매상품조회]
- 최근 3일간 가장 많이 팔린 상위 5개 상품 정보를 제공합니다.
- 통계 정보를 다루기 위한 기술적 고민을 충분히 해보도록 합니다.
- 상품 주문 내역을 통해 판매량이 가장 높은 상품을 추천합니다.
[장바구니 목록보기]
- 사용자는 모든 장바구니 상품목록을 볼 수 있습니다.
[장바구니 추가]
- 사용자는 구매 이전에 관심 있는 상품들을 장바구니에 적재할 수 있습니다.
[장바구니 수정]
- 사용자는 장바구니에 상품을 추가 혹은 변경할 수 있습니다.
[장바구니 삭제]
- 시용자는 장바구니에 있는 상품들을 삭제할수 있습니다.

## ERD
```mermaid
erDiagram
    MEMBER {
        long member_id PK "인조키"
        string user_id "사용자 ID"
        string pw "사용자 비밀번호"
        string nickName "사용자 닉네임"
        string member_role "사용자 역할"
    }
    USER_POINT {
        long user_point_id PK "인조키"
        long member_id FK "회원 ID"
        long user_point_point "사용자 포인트"
        string user_point_pointAction "포인트 액션 (충전, 사용)"
    }
    PRODUCT {
        long product_id PK "인조키"
        string product_name "상품 이름"
        long product_price "상품 가격"
        boolean delFlag "삭제 여부"
    }
    STOCK {
        long stock_id PK "인조키"
        long product_id FK "상품 ID"
        long stock_quantity "재고 수량"
    }
    CART {
        long ecommerce_cart_id PK "인조키"
        long member_id FK "회원 ID"
    }
    CART_ITEM {
        long ecommerce_cart_item_id PK "인조키"
        long product_id FK "상품 ID"
        long cart_id FK "카트 ID"
        long cart_quantity "카트 내 상품 수량"
    }
    ORDER {
        long ecommerce_order_id PK "인조키"
        long member_id FK "회원 ID"
        date ecommerce_order_date "주문 날짜"
        long product_id FK "상품 ID"
        long ecommerce_quantity "주문 수량"
        string status "주문 상태"
    }

    MEMBER ||--o{ USER_POINT : ""
    MEMBER ||--o{ CART : ""
    MEMBER ||--o{ ORDER : ""
    PRODUCT ||--o{ STOCK : ""
    PRODUCT ||--o{ CART_ITEM : ""
    PRODUCT ||--o{ ORDER : ""
    CART ||--o{ CART_ITEM : ""

```

## API 설계
### 포인트
[포인트충전 API]
- 사용자의 포인트를 충전합니다.
- endpoint : patch /api/point/charge

[포인트조회 API]
- 사용자의 포인트를 조회합니다.
- endpoint : get /api/point/{memberId}

### 이커머스 상품
[상품 조회 API]
- 이커머스의 상품을 조회합니다.
- endpoint : get /api/product

### 주문
[주문 API]
- 상품을 주문 및 결제합니다.
- 상품이 결제가 되면 주문상태를 저장합니다.
- endpoint : post /api/order

### 결제
[결제 API]
- 상품을 결제요청합니다.
- endpoint : post /api/pay

### 통계
[인기 판매 상품 조회 API]
- endpoint : get /api/popular/product

### 장바구니
[장바구니 조회 API]
- 사용자의 장바구니 상품목록을 조회합니다.
- endpoint : get /api/cart
  [장바구니 수정 API]
- 사용자의 장바구니 상품을 수정합니다.
- endpoint : get /api/cart
  [장바구니 삭제 API]
- 사용자의 장바구니 상품을 삭제합니다.
- endpoint : get /api/cart
- Query Parameters: x
- Request Body:
```json
{
}
```
Response:
- 성공시
```json
{
}
```
- 실패시-조건
```json
{
}
```