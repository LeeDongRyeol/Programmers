package twoNTiling;

public class TwoNTiling {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.solution(4));
	}
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n + 1];
        arr[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                arr[i] = 1;
            } else {
            	arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
            }
        }
        
        answer = arr[n];
        
        return answer;
    }
}