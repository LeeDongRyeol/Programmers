package farJump;

/*
 * 	https://school.programmers.co.kr/learn/courses/30/lessons/12914
 * 
 *  프로그래머스 멀리 뛰기
 * */

public class FarJump {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(4));
		System.out.println(s.solution(5));
		System.out.println(s.solution(11));
	}
}

class Solution {
    public long solution(int n) {
        if(n <= 3) return (long)n;
        
        long[] arr = new long[n+1];
        for(int i = 0; i < 4; i++) {
            arr[i] = i;
        }
        
        int cnt = 3;
        while(cnt <= n) {
            arr[cnt] = (arr[cnt - 1] + arr[cnt - 2]) %1234567;
            cnt++;
        }
        
        return arr[n];
    }
}