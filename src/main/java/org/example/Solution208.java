package org.example;

/**
 * 实现 Trie (前缀树)
 *
 * @author xiaojie.huang
 * @date 2024-01-29
 */
public class Solution208 {
    public static class Trie {
        private Trie[] children;
        private boolean isEnd;
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                Trie child = node.children[index];
                if (child == null) {
                    child = new Trie();
                    node.children[index] = child;
                }
                node = child;
                if (i == word.length() - 1) {
                    node.isEnd = true;
                }
            }
        }

        private Trie find(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

        public boolean search(String word) {
            Trie trie = find(word);
            return trie != null && trie.isEnd;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("app");
        obj.insert("apple");
        obj.insert("beer");
        obj.insert("add");
        obj.insert("jam");
        obj.insert("rental");

        System.out.println(obj.search("apps"));
        System.out.println(obj.search("app"));
        System.out.println(obj.search("ad"));
        System.out.println(obj.search("applepie"));
        System.out.println(obj.search("rest"));
        System.out.println(obj.search("jan"));
        System.out.println(obj.search("rent"));
        System.out.println(obj.search("beer"));
        System.out.println(obj.search("jam"));
        System.out.println(obj.startsWith("apps"));
        System.out.println(obj.startsWith("app"));
        System.out.println(obj.startsWith("ad"));
        System.out.println(obj.startsWith("applepie"));
        System.out.println(obj.startsWith("rest"));
        System.out.println(obj.startsWith("jan"));
        System.out.println(obj.startsWith("rent"));
        System.out.println(obj.startsWith("beer"));
        System.out.println(obj.startsWith("jam"));
    }

}
