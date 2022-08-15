# metaChat
## 오류 해결

- favicon → href=’#’ (때문에 조회 2번씩 발생) → 무조건 존재하는 현재 폴더 위치 다시 조회해서
    - 수 십번 코드 진행에 따라 살펴봄 → 스프링 부트 코드에는 문제 없음을 확인
        
        → 자바스크립트 단위별로 끊어서 확인 (주석처리로)
        
        → 모든 경우에서 두번씩 실행
        
        → 아이에 새로운 파일을 생성해서 실행 → 오류 해결
        
    - 해결 : 알고보니 맨 위에 favicon 오류 뜨는게 보기 싫어서 넣었던 href=’#’를 인지하지 못함
        
        이미지 파일 하나 넣어서 해결
        
- 인풋 submit 할 때 엔터 입력 시 중복 현상 발생
    - 위와 같은 과정 또 반복
        → ~엔터를 누르면서 form 형식이 submin → keyup을 사용하니 올라오면서 한번 더 적용~ | NO !!
        추가 조사 : JavaScript에서 keyup을 사용하는 경우 브라우저 마다, 다른 결과가 다름. 영어에는 오류 없고, 한글에 오류 나타남. keyup이 두번 일어날 때 엔터 말고 keycode 229가 나타남
        -> 한글과 영어의 문자 입력 방식에 차이 떄문에 발생 (각각의 문자로 이루어진 영어와는 다르게 문자의 조합으로 단어를 만드는 한글의 다른 처리 방식)
            - ex) 그럼 한글로 적더라도 마지막에 스페이스바로 끝내면 중복 없이 입력되나?  => __추가 서치 필요__
    - keyup → keydown으로 수정하니 해결
### [미해결 및 궁금증]

- 웹 소켓에서 Geolocation 사용하면 딜레이가 생기는건가?
    - (채팅 칠 때 마다 getCurrentPostion 해줌)
        
        → watchPosition은 배터리나 기타 리소스 많이 먹는다고해서… 
        
    - 처음 채팅방 입장하고 위치정보 가져오는데 시간이 좀 걸림
    - 가끔 채팅을 치고 위치 정보를 가져오는데 시간이 걸림
- 배포 때 타임리프 확인하기
    - 분명 intellij에서 돌릴 때는 되는데 왜 빌드하면 안되는걸까? (배포는 gradle이 빌드해서 다른가?)
        - intellij Prefernce에서 build tool : gradle로 바꿔서 로컬 실행해도 됨
            - intellij가 알아서 파일 위치 해결해주는건가..?
        - 근데 build 돌리면 기가 막히게 안된다…

## 개선필요
- 배포시 https 아니라서 사용자 정보 가져오지 못함 -> 추가하기
- 데이터를 그대로 넘겨주는 형태 (HTML 형식으로) -> sanitize ?? 관련 공부 후 추가
- 데이터베이스 연결
    - 로그인 (관리자 / 비 관리자 파악) + 사용자 정보 저장 → 아이디 중복 문제 해결
    - 실수로 중복된 이름 사용하면 아이디 겹쳐져서 내 채팅이 아니어도 오른쪽에 나와버림
- jquery안쓰고 axios로 바꾸기
- 그림에 마우스 올리면 커서 클릭으로 변하게
