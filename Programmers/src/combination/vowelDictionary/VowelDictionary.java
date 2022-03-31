package combination.vowelDictionary;

public class VowelDictionary {
	public static void main(String[] args) {
		Solution s1 = new Solution();
		System.out.println(s1.solution("AAAAE"));
		Solution s2 = new Solution();
		System.out.println(s2.solution("AAAE"));
		Solution s3 = new Solution();
		System.out.println(s3.solution("I"));
		Solution s4 = new Solution();
		System.out.println(s4.solution("EIO"));
		
	}
}

class Solution {
	char[] arr = {'A', 'E', 'I', 'O', 'U'};
	int num = 0;
	String word;
	boolean isFind = false;
	
    public int solution(String word) {
        this.word = word;
        find(0, "");
        return num;
    }
    
    public void find(int idx, String str) {
    	for (int i = idx; i < 5; i++) {
    		
    		String temp = str + arr[i];
    		int len = temp.length();
    		num++;
    		
        	if(word.equals(temp)) {
    			isFind = true;
    			return;
    		}
        	
        	if(len == 5) continue;
    		
        	find(idx, temp);
        	
    		if(isFind) return;
		}    	
    }
}