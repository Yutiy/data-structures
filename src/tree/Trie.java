package tree;

import java.util.TreeMap;

/**
 * Author: yutiy
 * Date: 2020/12/16 下午4:12
 * Email: 494657028@qq.com
 */
class Node {
    public boolean isWord;
    public TreeMap<Character, Node> next;

    public Node(boolean isWord){
        this.isWord = isWord;
        next = new TreeMap<>();
    }

    public Node(){
        this(false);
    }
}

public class Trie {
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }
}
