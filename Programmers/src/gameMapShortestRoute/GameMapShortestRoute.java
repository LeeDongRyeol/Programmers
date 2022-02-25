package gameMapShortestRoute;

/**
 *  https://programmers.co.kr/learn/courses/30/lessons/1844
 *  
 *  게임 맵 최단거리
 *  
 *  BFS를 활용하여 최단거리를 구하면 됌
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestRoute {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int[][] arr2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		
		System.out.println(s.solution(arr1));
		System.out.println(s.solution(arr2));
	}
}

class Solution {
	int[] dy = {1, 0, -1, 0};
	int[] dx = {0, 1, 0, -1};
	boolean[][] visit;
	
    public int solution(int[][] maps) {
    	int n = maps.length;
    	int m = maps[0].length;
    	
        visit = new boolean[n][m];
    	int answer = Integer.MAX_VALUE;
        
        Queue<Pos> q = new LinkedList<Pos>();
        q.add(new Pos(0,0,1));
        while(!q.isEmpty()) {
        	Pos temp = q.poll();
        	
        	if(temp.y == n-1 && temp.x == m-1) {
        		answer = Math.min(answer, temp.cnt);
        		continue;
        	}
        	
        	for (int dir = 0; dir < 4; dir++) {
				int ny = dy[dir] + temp.y;
				int nx = dx[dir] + temp.x;
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx]) continue;
				if(maps[ny][nx] == 0) continue;
				
				visit[ny][nx] = true;
				int cnt = temp.cnt + 1;
				q.add(new Pos(ny, nx, cnt));
			}
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

class Pos {
	int y, x, cnt;
	
	public Pos(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}