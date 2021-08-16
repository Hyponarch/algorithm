package LeetCode;

import java.util.*;

/*
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]

 */
public class Problem_208 {
    public static void main(String[] args) {
        Trie t = new Problem_208().new Trie();
        t.insert("apple");
        Trie.Node n = t.root;
//        while (n != null){
//            for(Map.Entry<Character, Trie.Node> entry : n.child.entrySet()){
//                n = entry.getValue();
//                System.out.println(entry.getKey());
//            }
////            n = n.child.entrySet()
//        }

        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
    }

    class Trie {
        Node root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }
        //每个字符一个节点？单词结束需要一个结束符号，避免覆盖的情况，比如on, one
        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] wordArr = word.toCharArray();
            Node node = root;

            for(char c : wordArr){
                if(!node.child.containsKey(c)){
                    Node tmp = new Node(c);
                    node.child.put(c, tmp);
                    node = tmp;
                }else {
                    node = node.child.get(c);
                }
            }
            //循环结束后，插入结束符
            node.child.put('0', new Node('0'));
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                if(node.child.containsKey(word.charAt(i))){
                    node = node.child.get(word.charAt(i));
                }else {
                    return false;
                }
            }
            return node.child.containsKey('0');
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node node = root;
            for(int i = 0; i < prefix.length(); i++){
                if(node.child.containsKey(prefix.charAt(i))){
                    node = node.child.get(prefix.charAt(i));
                }else {
                    return false;
                }
            }
            return true;
        }

        class Node{
            char c;
            Map<Character, Node> child = new HashMap<>();
            public Node() {}
            public Node(char c){
                this.c = c;
            }
//            @Override
//            public int hashCode(){
//                return c;
//            }
//            @Override
//            public boolean equals(Object obj){
//                if(!(obj instanceof Node)){
//                    return false;
//                }
//                return this.c == ((Node)obj).c;
//            }
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
