package miniRactangular;

/**
 * 최소직사각형 문제
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 * 
 * 이번문제는 Min, Max만 잘 써도 쉽게 풀 수 있음
 */

public class MiniRactangular {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};	
		System.out.println(s.solution(sizes1));
		
		int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		System.out.println(s.solution(sizes2));
		
		int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
		System.out.println(s.solution(sizes3));
	}
}

class Solution {
    public int solution(int[][] sizes) {
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        
        for (int i = 0; i < sizes.length; i++) {
			int w, h;
			
			int tmp1 = sizes[i][0];
			int tmp2 = sizes[i][1];
			
			w = tmp1 > tmp2 ? tmp1 : tmp2;
			h = tmp1 < tmp2 ? tmp1 : tmp2;
			
			maxW = Math.max(maxW, w);
			maxH = Math.max(maxH, h);
		}
        
        return maxW * maxH;
    }
}