package implementation.openChatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatting {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(record)));
	}
}

class Solution {
	Map<String, String> map = new HashMap<String, String>();
	
    public String[] solution(String[] record) {
        List<String> command = new ArrayList<String>();
        List<String> idList = new ArrayList<String>();
        
        List<String> rtnList = new ArrayList<String>();
        
        for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");
			command.add(arr[0]);
			idList.add(arr[1]);
			
			if(!"Leave".equals(arr[0])) map.put(arr[1], arr[2]);
		}
        
        for (int i = 0; i < command.size(); i++) {
			String name = map.get(idList.get(i));
			String cmd = command.get(i);
			
			switch(cmd) {
				case "Enter" :
					rtnList.add(name + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
					break;
				case "Leave" :
					rtnList.add(name + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
					break;
			}
		}
        
        return rtnList.toArray(new String[rtnList.size()]);
    }
}