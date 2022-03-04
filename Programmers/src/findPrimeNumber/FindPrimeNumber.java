package findPrimeNumber;

/**
 * 
 *  https://programmers.co.kr/learn/courses/30/lessons/42839
 *  
 *  소수 찾기
 *  
 *  Math.sqrt()와 백트래킹을 사용하면 쉽게 찾을 수 있다.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindPrimeNumber {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("17"));
		System.out.println(s.solution("011"));
	}
}

class Solution {
	boolean[] check;
	Map<Integer, Boolean> map;
	int len;
	
    public int solution(String numbers) {
    	len = numbers.length();
        check = new boolean[len];
        map = new HashMap<Integer, Boolean>();
        
        String[] card = numbers.split("");
        
        Arrays.sort(card, Collections.reverseOrder());
        search(card, "");
        
        return map.size();
    }
    
    public void search(String[] card, String str) {
    	if(len == str.length()) return;
    	
    	for (int i = 0; i < card.length; i++) {
			if(!check[i]) {
				check[i] = true;
				String temp = str + card[i];
				int num = Integer.parseInt(str + card[i]);
				boolean isPrime = false;
				if(num >= 2) isPrime = isPrimeNumber(temp);
				if(isPrime && !map.containsKey(num)) map.put(num, true);
				search(card, temp);
				check[i] = false;
			}
		}
    }
    
    public boolean isPrimeNumber(String str) {
    	int num = Integer.parseInt(str);
    	
    	for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
    	
    	return true;
    }
}