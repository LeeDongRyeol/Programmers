package implementation.justNowThatSong;

/**
 *  https://programmers.co.kr/learn/courses/30/lessons/17683
 *  
 *  프로그래머스 방금그곡 - 카카오 기출
 */

import java.util.ArrayList;
import java.util.List;

public class JustNowThatSong {
	public static void main(String[] args) {
		Solution s1 = new Solution();
		String m1 = "ABCDEFG";
		String[] arr1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(s1.solution(m1, arr1));
		
		Solution s2 = new Solution();
		String m2 = "CC#BCC#BCC#BCC#B";
		String[] arr2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println(s2.solution(m2, arr2));
		
		Solution s3 = new Solution();
		String m3 = "ABC";
		String[] arr3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(s3.solution(m3, arr3));
	}
}

class Solution {
	// # 붙은건 다른 문자로 바꾸기
	// A# => V
	// C# => W
	// D# => X
	// F# => Y
	// G# => Z 
    public String solution(String m, String[] musicinfos) {
        List<Song> list = new ArrayList<Song>();
        
        m = replaceString(m);
        
        for (int i = 0; i < musicinfos.length; i++) {
			String[] musicInfo = musicinfos[i].split(",");
			
			String[] start = musicInfo[0].split(":");
			String[] end = musicInfo[1].split(":");
			Song song = new Song();
			String title = musicInfo[2];
			String contents = replaceString(musicInfo[3]);
			
			song.title = title;
			
			int sH = Integer.parseInt(start[0]);
			int eH = Integer.parseInt(end[0]);
			int diff = (eH - sH) * 60;
			
			int sM = Integer.parseInt(start[1]);
			int eM = Integer.parseInt(end[1]);
			
			int minute = (eM + diff) - sM;
			song.time = minute;
			
			String total = "";
			
			int div = minute / contents.length();
			
			for (int j = 0; j < div; j++) {
				total += contents;
			}
			
			if(!"".equals(total) && minute % contents.length() != 0) total += contents.substring(0, minute % contents.length());
			
			if("".equals(total)) total = contents.substring(0, minute);
			
			song.lylics = total;
			
			list.add(song);
		}
        
        int maxTime = Integer.MIN_VALUE;
        String maxTitle = "";
        
        for (int i = 0; i < list.size(); i++) {
			Song song = list.get(i);
			
			if(song.lylics.contains(m)) {
        		if(maxTime < song.time) {
        			maxTitle = song.title;
        			maxTime = Math.max(maxTime, song.time);
        		}
        	}
			
		}
        
        if(!"".equals(maxTitle)) return maxTitle;
        
        return "(None)";
    }
    
    public String replaceString(String s) {
    	return s.replaceAll("A#", "V").replaceAll("C#", "W").replaceAll("D#", "X").replaceAll("F#", "Y").replaceAll("G#", "Z");
    }
}

class Song {
	int time;
	String title;
	String lylics;
	@Override
	public String toString() {
		return "Song [time=" + time + ", title=" + title + ", lylics=" + lylics + "]";
	}
}