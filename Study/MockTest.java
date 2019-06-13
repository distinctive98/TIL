package practice03;

import java.util.*;

//학생 클래스
class Student{
	int[] pattern;
	int number;
	int score;
	
	Student(int[] pattern, int number){
		this.pattern = pattern;
		this.number = number;
		score = 0;
	}
}

//채점 클래스
class Mark{
	
	int[] answer;
	Student[] s;
	
	Mark(int[] answer, int[] p1, int[] p2, int[] p3){
		this.answer = answer;
		s = new Student[3];
		s[0] = new Student(p1, 1);
		s[1] = new Student(p2, 2);
		s[2] = new Student(p3, 3);
	}
	
	//채점하기
	void marking() {
		for(int i=0; i<answer.length; i++) {
			if(s[0].pattern[i!=0 ? i%s[0].pattern.length : 0]==answer[i]) s[0].score++;
			if(s[1].pattern[i!=0 ? i%s[1].pattern.length : 0]==answer[i]) s[1].score++;
			if(s[2].pattern[i!=0 ? i%s[2].pattern.length : 0]==answer[i]) s[2].score++;
		}
	}
	
	//랭킹매기기
	int[] ranking() {
		//먼저 정렬
		Arrays.sort(s, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.score < o2.score)
					return 1;
				else if(o1.score > o2.score)
					return -1;
				else
					return 0;
			}
		});
		
		//경우의 수 도출해서 배열에 저장
		int[] result = null;
		
		//점수가 모두 같을 때
		if(s[0].score == s[1].score && s[1].score == s[2].score) {
			result = new int[3];
			for(int i=0; i<3; i++)
				result[i] = s[i].number;
		}
		//점수가 상위 두 명만 같을 때
		else if(s[0].score == s[1].score) {
			result = new int[2];
			for(int i=0; i<2; i++)
				result[i] = s[i].number;
		}
		//독보적일 때
		else {
			result = new int[1];
			result[0] = s[0].number;
		}
		
		return result;
	}
}

class Solution {
	public int[] solution(int[] answers) {
		
		int[] pattern1 = {1, 2, 3, 4, 5};
		int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		Mark mark = new Mark(answers, pattern1, pattern2, pattern3);
		mark.marking();
	    return mark.ranking();
	}
}

public class MockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer1 = {1, 2, 3, 4, 5};
		int[] answer2 = {1, 3, 2, 4, 2};
		
		Solution s = new Solution();
		int[] answer = s.solution(answer1);
		
		for(int i=0; i<answer.length; i++)
			System.out.println(answer[i]);
	}
}
