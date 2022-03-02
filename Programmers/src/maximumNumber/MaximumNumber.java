package maximumNumber;

/**
 *  
  	https://programmers.co.kr/learn/courses/30/lessons/42746

	���� ū �� - Arrays.sort( arr, new Comparator<String> {} )�� Override�ؼ� Ǫ�� ����
	
	���ڿ� �� �񱳸� ���Ͽ� ������ �� �ִ�.
	
	�ؿ� �ּ��� ��Ʈ��ŷ �ҽ� �ּ�. �׽�Ʈ���̽��� ������ ���� �� �ð��ʰ�, �޸��ʰ��� �߻��Ѵ�.
 */

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumber {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr1 = {6, 10, 2};
		System.out.println(s.solution(arr1));
		int[] arr2 = {3, 30, 34, 5, 9};
		System.out.println(s.solution(arr2));
	}
}

class Solution {
	String[] numStr;
	
    public String solution(int[] numbers) {
        String answer = "";
        
        numStr = new String[numbers.length];
        boolean zero = true;
        
        for (int i = 0; i < numStr.length; i++) {
			numStr[i] = Integer.toString(numbers[i]);
			if(numbers[i] != 0) zero = false;
		}
        
        Arrays.sort(numStr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String str = o1 + o2, reverse = o2 + o1;
				return reverse.compareTo(str);
			}
		});
        
        for (int i = 0; i < numStr.length; i++) {
			answer += numStr[i];
		}
        
        if(zero) answer = "0";
        
        return answer;
    }
}

//class Solution {
//	boolean[] check;
//	int max;
//	String maxStr;
//	
//    public String solution(int[] numbers) {
//        String answer = "";
//        
//        check = new boolean[numbers.length];
//        max = Integer.MIN_VALUE;
//        maxStr = "";
//        
//        find(numbers, 0, 0, "");
//        answer = maxStr;
//        
//        return answer;
//    }
//    
//    public void find(int[] numbers, int idx, int cnt, String str) {
//    	if(cnt == numbers.length) {
//    		max = Math.max(max, Integer.parseInt(str));
//    		maxStr = Integer.toString(max);
//    		return;
//    	} 
//    	
//    	for (int i = 0; i < numbers.length; i++) {
//			if(!check[i]) {
//				check[i] = true;
//				find(numbers, i+1, cnt+1, str + numbers[i]);
//				check[i] = false;
//			}
//		}
//    }
//}