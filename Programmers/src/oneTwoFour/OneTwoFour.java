package oneTwoFour;

public class OneTwoFour {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(1));
		System.out.println(s.solution(2));
		System.out.println(s.solution(3));
		System.out.println(s.solution(4));
		System.out.println(s.solution(6));
		
	}
}

class Solution {
    public String solution(int n) {

    	String answer = "";
    	
    	String[] num = {"4", "1", "2"};

    	while (n > 0) {
    		answer = num[n % 3] + answer;
    		n = (n - 1) / 3;
    	}

    	
//    	시간초과 나는 코드
//    	int num = n, r = 0;
//    	
//    	while(num > 0) {
//    		r = num % 3;
//    		
//    		num /= 3;
//    		if(r == 0) {
//    			num--;
//    			r = 4;
//    		}
//    		
//    		answer = r + answer;
//    	}
    	
    	return answer;
    }
}