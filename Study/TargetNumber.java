package practice02;

class Result {
	
	int[] number;
	int target;
	int answer;
	
	Result(int[] number, int target){
		this.number = number;
		this.target = target;
		answer = 0;
	}
	
	int getAnswer() {
		return answer;
	}

	void dfs(int sum, int depth, int n) {
		if(n==0)	
			sum += number[depth];
		else	
			sum -= number[depth];
		
		if(depth==number.length-1) {
			if(target == sum)
				answer++;
			return;
		}
	
		dfs(sum, depth+1, 0);
		dfs(sum, depth+1, 1);
	}
}

class Solution {
	public int solution(int[] number, int target) {		
		Result r = new Result(number, target);
		r.dfs(0, 0, 0);
		r.dfs(0, 0, 1);
		
		int answer = r.getAnswer();
		return answer;
	}
}

public class TargetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number = new int[] {1, 1, 1, 1, 1};
		int target = 3;
		
		Solution s = new Solution();
		int result = s.solution(number, target);
		System.out.println(result);
	}

}
