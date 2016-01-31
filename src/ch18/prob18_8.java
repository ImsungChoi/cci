package ch18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by imsungchoi on 2016. 1. 28..
 *
 * Suffix Tree
 */
public class prob18_8 {
    public static void main(String[] args) {
        String s = "ababas";
        SuffixTree st = new SuffixTree(s);

        System.out.println(st.search("aba"));
        System.out.println(st.search("ab"));
        System.out.println(st.search("b"));
        System.out.println(st.search("as"));
    }
}

class SuffixTree {
    TrieNode root = new TrieNode();

    public SuffixTree(String s) {
        for(int i = 0; i < s.length(); i++) {
            root.insert(s.substring(i), i);
        }
    }

    public List<Integer> search(String s) {
        return root.search(s);
    }
}

class TrieNode {
    char val;
    Map<Character, TrieNode> children = new HashMap<>();
    List<Integer> indexes = new ArrayList<>();

    public void insert(String s, int index) {
        indexes.add(index);
        if(s != null && s.length() > 0) {
            char c = s.charAt(0);
            TrieNode child = null;
            if(children.containsKey(c)) {
                child = children.get(c);
            } else {
                child = new TrieNode();
                child.val = c;
                children.put(c, child);
            }
            child.insert(s.substring(1), index);
        }
    }

    public List<Integer> search(String s) {
        if(s == null || s.length() == 0) {
            return indexes;
        }

        char c = s.charAt(0);
        if(children.containsKey(c)) {
            return children.get(c).search(s.substring(1));
        }

        return null;
    }
}