import java.util.*;
class Node{
    Node links[] = new Node[26];
    boolean flag = false;
    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    public Node getKey(char ch){
        return links[ch-'a'];
    }
    public void put(char ch,Node node){
        links[ch-'a'] = node;
    }
    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }
}
public class longestPrefixWord {
    Node root;
    longestPrefixWord(){
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.getKey(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean checkPrefixExists(String word){
        Node node = root;
        for(int  i = 0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.getKey(word.charAt(i));
                if(node.isEnd() == false){
                   return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
    public String completeString(String[] words){
        longestPrefixWord obj = new longestPrefixWord();
        for(int i = 0;i<words.length;i++){
             obj.insert(words[i]);
        }
        String longest = "";
        for(int i = 0;i<words.length;i++){
            if(obj.checkPrefixExists(words[i])){
                if(words[i].length() > longest.length()){
                    longest = words[i];
                }
                else if(words[i].length() == longest.length() && words[i].compareTo(longest) < 0){
                    longest = words[i];
                }
            }
        }
        if(longest == "")return "None";

        return longest;
    }
    public static void main(String args[]){
        longestPrefixWord obj = new longestPrefixWord();
        String words[] ={"n","ni","nin","ninja","ninj","ninga"};
        String result = obj.completeString(words);
        System.out.println(result);
    }
}
