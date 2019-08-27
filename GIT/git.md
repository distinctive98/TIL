# Git

## 기본명령어

1. 저장소 초기화
2. git add
3. git commit



## Git 되돌리기

1. commit 메세지 수정

   ```bash
   $ git commit --amend
   ```

   - git bash에서 vim이 실행된다
   - 편집모드(i) 상태에서 수정 후 esc + :wq 종료
   - push 이후에 진행하면 충돌이 무조건 발생한다
   - 커밋을 다시 하게되면 해시값이 변경되기 때문!

2. Stating area(INDEX)에서 취소하기

   ```bash
   $ git reset HEAD 파일명
   ```

3. git 이력에서 특정 파일 삭제 커밋

   ```bash
   $ git rm --cached 파일명
   ```

   - 한 번도 커밋된 이력이 없을 때에는 staging area에서 취소와 동일함
   - 다만, 커밋에 포함된 적 있는 경우에는 삭제 커밋이 됨
   - 실제 파일은 삭제되지 않음!

4. 특정 파일 포함해서 다시 커밋

   ```bash
   $ git add a.py
   $ git commit -m 'a, b 추가'
   $ git add b.py
   $ git commit --amend
   ```

   - commit 메세지를 수정하기 전에 staging area에 변경을 해주면, 해당 파일까지 포함하여 다시 커밋을 진행함

5. 현재 작업 내역 커밋 시점으로 되돌리기

   - 예를 들어, 특정 파일을 삭제하였거나 혹은 코드 수정과정에서 오류가 많이 발생하여 직전 커밋 시점 상태로 돌아가고 싶을 때 사용이 가능함

   ```bash
   $ git checkout -- 파일명	
   ```



## 원격저장소(github) 활용하기

1. 원격 저장소 설정

   ```bash
   $ git remote add origin URL.git
   ```

2. 원격 저장소 확인

   ```bash
   $ git remote -v
   ```

3. 원격 저장소에 push

   ```bash
   $ git push origin master
   ```

4. 원격 저장소 삭제

   ```bash
   $ git remote rm origin
   ```

5. 원격 저장소 복제

   ```bash
   $ git clone URL.git
   ```

   - 로컬에 원격 저장소를 받아오고 싶다면, clone을 통해 가져온다!
   - 이후에는 push - pull을 통해서 업데이트하면 된다

   

   

## 충돌 해결하기

> 기본적으로 push - pull 하는 과정에서 동일한 파일의 다른 이력이 기록될 경우 충돌이 발생한다
>
> 다른 파일이 수정되는 경우 fast-fowarding을 통해 자동으로 merge가 되기도 함!
>
> 이러한 오류를 발생시키지 않으려면, 항상 작업 하기전에 `pull` 을 확인하고, 작업 및 커밋을 한 이후에 `push` 를 하는 것을 습관화 하자!



1. Local A에서 a.txt 작성 후 커밋

2. Local A에서 원격저장소(Origin)로 push

3. Local B에서 pull하지 않은 상태에서 a.txt 동일한 라인 작성 후 커밋

4. Local B에서 원격저장소(Origin)로 push -> push 되지 않음!

5. 해결(원격저장소 변경사항 Local B에서 반영)

   ```bash
   $ git pull origin master
   ```

6. 충돌 발생(동일 파일 수정시)

   - 어떤 파일에서 충돌되었는지 확인하는 명령어

   ```bash
   $ git log --online --left-right --p
   ```

   ```bash
   <<<<<<< HEAD
   집 수정 내용
   =======
   멀캠 수정 내용
   >>>>>>> 12dfas12sadf124fdsa
   ```

   - `HEAD` : 현재 작업하고 있는 곳(Local B)
   - `해쉬값`: pull 을 통해 받아온 변경사항(origin)
   - 해당 하는 위치를 찾아서 직접 수정을 진행함!

7. merge conflict 해결 commit 남기기

   ```bash
   $ git status
   $ git add .
   $ git commit -m 'Merge conflict 해결'
   ```

8. 원격저장소로 `push`

   ```bash
   $ git push origin master
   ```

