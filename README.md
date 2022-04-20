# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* 경주는 아래 기능을 가짐
  - 등록 과정
  - 경주 진행
  - 결과 출력
* 등록 과정
  - 다수의 차량 이름을 구분자(콤마)를 사용해 한 번에 받음.
    - 차량의 이름은 1~5자.
  - 전진 횟수를 받음
    - int 범위 내 값 중, 양수.
  - 각 과정에 문제가 있을 경우 문제가 있던 단계부터 다시 반복.
* 경주 진행
  - 매 경주마다 해당 경주의 결과를 출력
  - 차량은 조건에 따라 전진 혹은 정지.
  - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 정지. (전진은 엔진의 결함이 없을 때 가능, 해당 조건은 엔진 결함 발생 조건을 설명.)
  - 차는 현재 상황을 출력할 수 있어야 함. (이름과 주행거리만큼 -가 표시되어야 함.)
* 최종 결과 출력
  - 단독, 공동 우승을 구분해 표시.
  - 공동일 경우 마찬가지로 구분자(콤마)를 통해 이름을 표시.
* 제약
  - 일급콜렉션을 활용해 구현한다.
  - 모든 원시값과 문자열을 포장한다.