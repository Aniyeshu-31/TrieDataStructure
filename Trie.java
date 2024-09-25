import java.util.*;

class Node{
     Node[] links = new Node[26];
     boolean flag = false;
     public void put(char ch,Node node) {
        links[ch-'a'] = node;
     }
     public boolean containsKey(char ch){
        return (links[ch-'a'] != null);
     }
     public Node getKey(char ch){
        return links[ch-'a'];
     }
     public void setEnd(){
        flag = true;
     }
     boolean isEnd(){
        return flag;
     }

}
public class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    // tc -> o(n)
    private void insert(String word){
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.getKey(word.charAt(i));
        }
        node.setEnd();
    }
    private boolean search(String word){
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.getKey(word.charAt(i));
        }
        if(node.isEnd()){
            return true;
        }
        return false;
    }
    public boolean startsWith(String word){
        Node node = root;
        for(int i =0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))return false;

            node = node.getKey(word.charAt(i));
        }
        return true;
    }
    public static void main(String args[]){
        
        Trie obj = new Trie();

        obj.insert("apple");
        obj.insert("apps");
        obj.insert("bad");
        obj.insert("bat");
        String search = "apple";
        String prefix = "ba";
        String prefix2 = "apd";

        System.out.println(obj.startsWith(prefix));
        System.out.println(obj.startsWith(prefix2));
        System.out.println(obj.startsWith(search));

    }
}