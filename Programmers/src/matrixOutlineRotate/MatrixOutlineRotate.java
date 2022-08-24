package matrixOutlineRotate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author dr854
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 * 
 * 프로그래머스 행렬 테두리 회전하기
 *
 */

public class MatrixOutlineRotate {
	public static void main(String[] args) {
		Solution s = new Solution();
		int r1 = 6, c1 = 6;
		int[][] q1 = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(Arrays.toString(s.solution(r1, c1, q1)));
		
		int r2 = 3, c2 = 3;
		int[][] q2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		Solution s2 = new Solution();
		System.out.println(Arrays.toString(s2.solution(r2, c2, q2)));
		
		int r3 = 100, c3 = 97;
		int[][] q3 = {{1,1,100,97}};
		Solution s3 = new Solution();
		System.out.println(Arrays.toString(s3.solution(r3, c3, q3)));
	}
}

class Solution {
	int dirIdx = 0;
	int col = 0;
	int row = 0;
	
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        
        int num = 1;
        
        for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
			}
		}
        
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < queries.length; i++) {
			int sRow = queries[i][0] - 1;
			int sCol = queries[i][1] - 1;
			int eRow = queries[i][2] - 1;
			int eCol = queries[i][3] - 1;
			int diffRow = eRow - sRow;
			int diffCol = eCol - sCol;
			
			int rowCnt = 0;
			int colCnt = 0;
			
			int cirCnt = 0;
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(arr[sRow][sCol]);

			int min = Integer.MAX_VALUE;
			
			int row = sRow, col = sCol;
			
			while(!q.isEmpty()) {
				
				if(cirCnt != 0 && row == sRow && col == sCol) {
					break;
				}
				
				int temp = q.poll();
				
				min = Math.min(min, temp);
				
				if(dirIdx == 0) {
					q.add(arr[row][col + 1]);
					arr[row][col + 1] = temp;
					col++;
				} else if(dirIdx == 1) {
					q.add(arr[row + 1][col]);
					arr[row + 1][col] = temp;
					row++;
				} else if(dirIdx == 2) {
					q.add(arr[row][col-1]);
					arr[row][col - 1] = temp;
					col--;
				} else if(dirIdx == 3) {
					q.add(arr[row - 1][col]);
					arr[row - 1][col] = temp;
					row--;
				}
				
				if(dirIdx == 0 || dirIdx == 2) {
					colCnt++;
				} else if(dirIdx == 1 || dirIdx == 3) {
					rowCnt++;
				}
				
				if(colCnt == diffCol || rowCnt == diffRow) {
					dirIdx = changeDir();
					colCnt = 0;
					rowCnt = 0;
				}
				
				cirCnt++;
			}
			
			list.add(min);
		}
        
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public int changeDir() {
    	return (dirIdx + 1) % 4;
    }
}
