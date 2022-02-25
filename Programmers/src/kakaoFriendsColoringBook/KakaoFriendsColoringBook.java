package kakaoFriendsColoringBook;

/**
 *  https://programmers.co.kr/learn/courses/30/lessons/1829
 *  
 *  카카오프렌즈 컬러링북 - 카카오 기출
 *  
 *  값이 0인 부분은 카운트 하면 안된다.
 *  
 *  제일 넓은 영역을 구하는 것이므로 bfs를 사용하여 풀면 된다.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoFriendsColoringBook {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(s.solution(6, 4, arr)));
	}
}

class Pos {
	int y, x;
	
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class Solution {
	int[] dy = {1, 0, -1 , 0};
	int[] dx = {0, 1, 0, -1};
	boolean[][] visit;
	
    public int[] solution(int m, int n, int[][] picture) {
    	visit = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(visit[i][j] || picture[i][j] == 0) continue;
				numberOfArea++;
				int val = bfs(picture, i, j);
				maxSizeOfOneArea = Math.max(val, maxSizeOfOneArea);
			}
		}

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int[][] picture, int y, int x) {
    	
    	int val = picture[y][x];
    	visit[y][x] = true;
    	
    	Queue<Pos> q = new LinkedList<Pos>();
    	q.add(new Pos(y, x));
    	
    	int size = 1;
    	
    	while(!q.isEmpty()) {
    		Pos pos = q.poll();
    		
    		for (int dir = 0; dir < 4; dir++) {
				int ny = pos.y + dy[dir];
				int nx = pos.x + dx[dir];
				
				if(isInvalidRange(ny, nx) || visit[ny][nx]) continue;
				if(val != picture[ny][nx]) continue;
				
				visit[ny][nx] = true;
				size++;
				q.add(new Pos(ny, nx));
			}
    	}
    	
    	return size;
    }
    
    public boolean isInvalidRange(int ny, int nx) {
    	return ny < 0 || nx < 0 || ny >= visit.length || nx >= visit[0].length;
    }
}