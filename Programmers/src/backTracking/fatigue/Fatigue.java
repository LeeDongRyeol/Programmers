package backTracking.fatigue;

public class Fatigue {
	public static void main(String[] args) {
		Solution s = new Solution();
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		System.out.println(s.solution(k, dungeons));
	}
}

class Solution {
	boolean[] check;
	int max = Integer.MIN_VALUE;
	int len;
	int hp;
	
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        check = new boolean[len];
        find(0, k, dungeons, 0);
        
        return max;
    }
    
    public void find(int dgCnt, int hp, int[][] dungeons, int cnt) {
    	if(hp >= 0) {
    		max = Math.max(max, cnt);
    	}
    	
    	for (int i = 0; i < dungeons.length; i++) {
			if(!check[i]) {
				check[i] = true;
				int needHp = 0;
				if(dungeons[i][0] <= hp) {
					needHp = dungeons[i][1];
					find(dgCnt + 1, hp - needHp, dungeons, cnt + 1);
				}

				check[i] = false;
			}
		}
    }
}