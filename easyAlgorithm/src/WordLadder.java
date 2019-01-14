import java.util.*;

/**
 * 127 单词接龙
 */
public class WordLadder {

    //1
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        int curNum = 1;
        int nextNum = 0;
        int level = 1;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] ch = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    ch[i] = j;
                    String temp = new String(ch);
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) {
                            return level + 1;
                        }
                        nextNum++;
                        queue.add(temp);
                        set.remove(temp);
                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }

    //2
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {

        Set<String> set= new HashSet<>(wordList);
        if (set.contains(beginWord)){
            set.remove(beginWord);
        }
        Map<String,Integer> map= new HashMap<>();
        map.put(beginWord,1);
        Queue<String> queue= new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()){
            String word= queue.poll();
            int currlevel= map.get(word);
            for (int i=0;i<word.length();i++){
                char[] wordUnit = word.toCharArray();
                for (char j='a';j<='z';j++){
                    wordUnit[i]=j;
                    String temp = new String(wordUnit);
                    if (set.contains(temp)){
                        if (temp.equals(endWord)){
                            return currlevel+1;
                        }
                        map.put(temp,currlevel+1);
                        queue.add(temp);
                        set.remove(temp);
                    }

                }
            }
        }
        return 0;
    }
}
