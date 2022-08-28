package checkDistance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author dr854
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 * 코딩테스트 연습 2021 카카오 채용연계형 인턴십 거리두기 확인하기
 */

public class CheckDistance {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(s.solution(places)));
	}
}

class Solution {
	int[] dy = {0, 1, 0, -1};
	int[] dx = {1, 0 ,-1, 0};
	String[][] chArr;
	boolean[][] visit;
	
    /**
     * @param places
     * @return
     */
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
			String[] strArr = places[i];
			
			Queue<Pos> q = new LinkedList<Pos>();
			
			chArr = new String[5][5];
			
			for (int j = 0; j < strArr.length; j++) {
				String[] temp = strArr[j].split("");
				
				for (int k = 0; k < temp.length; k++) {
					chArr[j][k] = temp[k];
					
					if(temp[k].charAt(0) == 'P') {
						q.add(new Pos(j, k));
					}
				}
				
				System.out.println(Arrays.toString(chArr[j]));
			}
			
			
			int result = 1;
			
			while(!q.isEmpty()) {
				Pos cur = q.poll();
				visit = new boolean[5][5];
				visit[cur.y][cur.x] = true;
				
				for (int j = 0; j < 4; j++) {
					int nx = dx[j] + cur.x;
					int ny = dy[j] + cur.y;
					
					if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
					if("X".equals(chArr[ny][nx])) continue;
					
					if("P".equals(chArr[ny][nx]))  {
						result = 0;
						break;
					}
					
					result = find(ny, nx);
					if(result == 0) break;
					
				}
				
				if(result == 0) break;
			}
			
			answer[i] = result;
			System.out.println();
		}
        
        return answer;
    }
    
    public int find(int r, int c) {
    	visit[r][c] = true;
    	
    	for (int i = 0; i < 4; i++) {
			int ny = r + dy[i];
			int nx = c + dx[i];
			
			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
			if(visit[ny][nx]) continue;
			if("X".equals(chArr[ny][nx])|| "O".equals(chArr[ny][nx])) continue;
			
			return 0;
		}
    	
    	return 1;
    }
}

class Pos {
	int y,x;
	
	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}