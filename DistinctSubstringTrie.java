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
public class DistinctSubstringTrie {
    Node root;
    DistinctSubstringTrie(){
        root = new Node();
    }
    public int CountDistinct(String word){
        int cnt = 0;
        for(int i  =0;i<word.length();i++){
            Node node = root;
            for(int j = i;j<word.length();j++){
                if(!node.containsKey(word.charAt(j))){
                    node.put(word.charAt(j), new Node());
                    cnt++;
                }
                node = node.getKey(word.charAt(j));
            }
        }
        return cnt + 1;
    }
    public static void main(String[] args) {
        DistinctSubstringTrie obj = new DistinctSubstringTrie();
        String word = "abab";
        int res = obj.CountDistinct(word);
        System.out.println(res);
    }
}