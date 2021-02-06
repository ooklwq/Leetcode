import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public class TrieNode{
        boolean isWord;
        Map<Character, TrieNode> children;
        public TrieNode() {
            isWord = false;
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String prefix : dictionary) {
            insert(prefix);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findPrefix(words[i]);
        }
        return String.join(" ", words);
    }

    private void insert(String str) {
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (cur.children.get(c) == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    private String findPrefix(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (cur.children.get(c) == null) {
                return word;
            }
            if (cur.children.get(c).isWord) {
                return word.substring(0, i + 1);
            }
            cur = cur.children.get(c);
        }
        return word;
    }




}