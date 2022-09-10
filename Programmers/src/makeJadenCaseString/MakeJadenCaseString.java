package makeJadenCaseString;


/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 * JadenCase 문자열 만들기
 */

import java.util.regex.Pattern;

public class MakeJadenCaseString {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("3people unFollowed me"));
		System.out.println(s.solution("for the last week"));
	}
}

class Solution {
    public String solution(String s) {
        String answer = "";
        String temp = "";
        
        for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if("".equals(temp) && ch != ' ') {
        		String pattern = "^[0-9]*$";
        		temp += ch;
        		boolean result = Pattern.matches(pattern, temp);
        		temp = result ? temp : temp.toUpperCase();
        	} else if(!"".equals(temp) && ch != ' ') {
        		String tmp = "" + ch;
        		temp += tmp.toLowerCase();
        	} else if((!"".equals(temp) && ch == ' ')) {
        		answer += temp + " ";
        		temp = "";
        	} else if("".equals(temp) && ch == ' ') {
        		answer += " ";
        	}
			
			if( i == s.length() - 1) {
				answer += temp;
			}
		}
        
        return answer;
    }
}