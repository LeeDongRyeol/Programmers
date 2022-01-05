package dfsAndBfs;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 * 
 * 타겟넘버
 * 
 * 백트래킹을 이용하여 풀려하였으나 시간초과 발생
 * 
 * BFS를 이용하면 손쉽게 풀 수 있음
 */

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(s.solution(numbers, target));
	}
}

class Solution {
	boolean[] check;
	int cnt = 0;
	int[] numArr, op = {1, -1};
	class Num {
		int val, cnt;
		public Num(int val, int cnt) {
			this.cnt = cnt;
			this.val = val;
		}
	}
	
    public int solution(int[] numbers, int target) {
        check = new boolean[numbers.length];
        numArr = numbers.clone();
//        dfs(numbers.length, 0, target, 0);
        bfs(numbers.length, target);
        
        return cnt;
    }
    
    public void bfs(int n, int target) {
    	
    	Queue<Num> q = new LinkedList<Num>();
    	q.add(new Num(0, 0));
    	
    	while(!q.isEmpty()) {
    		Num num = q.poll();
    		
    		if(num.cnt == n) {
    			if(num.val == target) cnt++;
    			continue;
    		}
    		
    		for (int i = 0; i < 2; i++) {
				int val = num.val + numArr[num.cnt]*op[i];
				q.add(new Num(val, num.cnt + 1));
			}
    	}
    }
    
    
    public void dfs(int n, int idx, int target, int sum) {
    	if(idx == n) {
    		if(sum == target) cnt++;
    		return;
    	}
    	
    	for (int i = idx; i < n; i++) {
			if(!check[i]) {
				check[i] = true;
				int num = numArr[i];
				
				for(int j = 0; j < 2; j++) {
					dfs(n, idx + 1, target, sum + op[j]*num);
				}
				
				check[i] = false;
			}
		}
    	
    }
}