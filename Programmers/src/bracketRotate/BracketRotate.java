package bracketRotate;

/**
 *  https://programmers.co.kr/learn/courses/30/lessons/765023
 *  
 *  괄호 회전하기
 *  
 *  Stack을 이용하여 풀면 쉽게 풀린다.
 *  
 *  마지막에 stack 안에 값이 있는지 확인해주어야 한다.
 */

import java.util.Stack;

public class BracketRotate {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.solution("[](){}"));
		System.out.println(s.solution("}]()[{"));
		System.out.println(s.solution("[)(]"));
		System.out.println(s.solution("}}}"));
	}
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Character> stack = null;
        
        for (int i = 0; i < s.length(); i++) {
			String temp = i == 0 ? s : s.substring(i) + s.substring(0, i); 
			
			stack = new Stack<Character>();
			
			boolean isRight = false;
			
			for(char ch : temp.toCharArray()) {
				if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
				else {
					if(stack.size() == 0) {
						isRight = false;
						break;
					}
					
					char tmpCh = stack.pop();
					
					if((tmpCh == '(' && ch == ')')
						|| (tmpCh == '{' && ch == '}')
						|| (tmpCh == '[' && ch == ']')) {
						isRight = true;
					} 
				}
			}
			
			if(isRight) answer++;
		}
        
        if(!stack.isEmpty()) return 0;
        
        return answer;
    }
}