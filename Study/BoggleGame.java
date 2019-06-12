package practice01;

import java.util.*;

public class BoggleGame {
	
	static char[][] arr = new char[][] {
		{'T', 'W', 'I', 'C', 'E'},
		{'I', 'S', 'C', 'U', 'B'},
		{'L', 'E', 'M', 'O', 'E'},
		{'U', 'F', 'M', 'O', 'A'},
		{'S', 'O', 'I', 'T', 'U'}
	};
	
	

	static boolean search8dir(String word, String result, int n, int i, int j) {
		
		//문자 일치하면 result에 저장
		if(arr[i][j]==word.charAt(n)) {
			result += arr[i][j];
			//단어 완성하면 true 반환
			if(word.equals(result))
				return true;
			//단어 완성 전이면 탐색
			else {
				if(search8dir(word, result, n+1, i, j))
					return true;
			}
		}
		//문자 일치 않으면 8방향 탐색
		else {
			//`1
			if(i-1 >= 0 && j-1 >=0 && arr[i-1][j-1] == word.charAt(n)) {
				//일치하면 해당 지점에서 탐색
				if(search8dir(word, result, n, i-1, j-1)) 
					return true;
			}
			//2
			if(i-1 >= 0 && arr[i-1][j] == word.charAt(n)) {
				if(search8dir(word, result, n, i-1, j))
					return true;
			}
			//3
			if(i-1 >= 0 && j+1 <=4 && arr[i-1][j+1] == word.charAt(n)) {
				if(search8dir(word, result, n, i-1, j+1))
					return true;	
			}
			//4
			if(j-1 >=0 && arr[i][j-1] == word.charAt(n)) {
				if(search8dir(word, result, n, i, j-1))
					return true;
			}
			//6
			if(j+1 <=4 && arr[i][j+1] == word.charAt(n)) {
				if(search8dir(word, result, n, i, j+1))
					return true;
			}
			//7
			if(i+1 <= 4 && j-1 >=0 && arr[i+1][j-1] == word.charAt(n)) {
				if(search8dir(word, result, n, i+1, j-1))
					return true;	
			}
			//8
			if(i+1 <= 4 && arr[i+1][j] == word.charAt(n)) {
				if(search8dir(word, result, n, i+1, j))
					return true;
			}
			
			//9
			if(i+1 <= 4 && j+1 <=4 && arr[i+1][j+1] == word.charAt(n)) {
				if(search8dir(word, result, n, i+1, j+1))
					return true;
			}
		}
		return false;
	}
	
	static boolean search(String word) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(search8dir(word, "", 0, i, j))
					return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		
		words.add("TWICE");
		words.add("IS");
		words.add("SO");
		words.add("BEAUTIFUL");

		for(int i=0; i<words.size(); i++) {
			if(search(words.get(i))) {
				System.out.println(words.get(i) + "를 찾았습니다.");
			}
		}
	}
}
