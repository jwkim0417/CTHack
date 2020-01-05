본 프로그램은 player와 boss가 대결하는 tit-for-tat game을 바탕으로 하는 프로그램입니다.

# 클래스 구성
클래스는 가장 작은 단위에서부터 설명하도록 하겠습니다.

## State
DFA를 이루는 state를 정의한 class입니다.
`Action`에는 해당 state가 협력인지 배신인지에 대한 정보가 boolean 값으로 담겨있고,
`C_arc`에는 상대편이 협력했을 때 이동할 state의 stateID가 담겨 있습니다.
`B_arc`는 상대편이 배신했을 경우에 해당합니다.

## Dfa
DFA를 정의한 class입니다.
ArrayList 자료형을 이용해여 state들을 관리하고, src string을 이용해 DFA를 정의하는 .txt 파일의 위치를 저장합니다.

`setDfa()` 함수는 DFA가 정의된 .txt 파일의 path를 입력받아 해당 .txt 파일에 정의된 순서대로 state를 read합니다.
.txt 파일을 한 줄씩 read하며 `state` 객체를 만들어 ArrayList인 `states`에 이어붙입니다.

`getAction()`, `getNextState()` 함수는 게임을 플레이할 때, `player` class에서 호출하게 됩니다.

## Player
게임에 참가하는 플레이어가 정의된 class입니다.
`Player`는 플레이어가 가지는 DFA와 그 DFA의 현재 어떤 state에 있는지와 플레이어의 점수에 대한 값을 가집니다.

`Player` class가 가지는 `getAction()`, `addScore()`, `moveNextState()` 메소드는 모두 `Game` class의 `Play` 메소드에서 호출하게 됩니다.

## Game
게임에 대해 정의된 class입니다.
`Game` class는 게임을 진행할 턴 수, 플레이어와 보스, 그리고 게임의 결과(협력-배신의 sequence, 각 플레이어의 점수)를 저장할 path를 객체 변수로 가집니다.

`Play()` 메소드는 게임의 한 턴을 진행하게 하는 함수로, 각 플레이어 객체 변수에 대해 `getAction()` 함수를 호출하여 `Player` class가 가지는 DFA에 대해 `current_stateID`에 해당하는 state의 Action에 대한 정보를 받아 `if-else`문으로 협력-배신을 판단해 점수를 부여합니다. 이후, `Player` class의 `moveNextState()` 메소드로 `current_stateID`를 업데이트 합니다.

## Play
main 함수가 정의된 class입니다.

# DFA가 정의된 txt 파일
플레이어와 보스가 가지는 DFA를 정의하는 txt 파일입니다.
(협력/배신) (협력시 이동하는 state) (배신시 이동하는 state) 의 sequence가 한줄 씩 입력됩니다.

ex)
1 0 1
0 2 3
1 3 5
...

이 .txt 파일을 처리하는 class는 `Dfa` class입니다.


# 게임 결과 txt 파일
플레이어와 보스의 협력/배신에 대한 sequence가 한 줄씩 출력됩니다. 이후 마지막 줄에 플레이어와 보스의 최종 점수가 출력됩니다.

ex)
B C
B B
C C
-100 500


# 진행 상황 전달
- 아직 게임이 종료된 후, 게임의 결과를 저장할 .txt 파일을 생성하는 메소드 구현 안 함. -> 구현 했음!!
- 2020.01.05. 완성하고, 프로그램이 정상적으로 I/O 하는지까지 확인함.
- gui에게 어떻게 `Play()` 함수의 결과를 전달해줄지 안 정함.