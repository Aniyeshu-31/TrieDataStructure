class Node{
    Node links[] = new Node[26];
    int ew = 0;
    int cp = 0;
    Node(){
        
    }
    public boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }
    public void put(char ch,Node node){
        links[ch-'a'] = node;
    }
    public Node getKey(char ch){
        return links[ch-'a'];
    }
    public void increaseEnd(){
        ew++;
    }
    public int getEndCount(){
        return ew;
    }
    public void increasePrefix(){
        cp++;
    }
    public int getPrefixCount(){
        return cp;
    }
    public void decCount(){
        ew--;
    }
    public void decPrefix(){
        cp--;
    }
}
public class countsWord {
    Node root;
    countsWord(){
        root = new Node();
    }
    private void insert(String word){
        Node node  = root;
        for(int i = 0;i<word.length();i++){
             if(!node.containsKey(word.charAt(i))){
                 node.put(word.charAt(i),new Node()); 
                }
                node = node.getKey(word.charAt(i));
                node.increasePrefix();
        }
        node.increaseEnd();
    }
    private int countsWordEqualto(String word){
        Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
           node = node.getKey(word.charAt(i));
        }
        return node.getEndCount();
    }
    private int countWordStartingsWith(String word){
            Node node = root;
        for(int i = 0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return node.getPrefixCount();
            }
           node = node.getKey(word.charAt(i));
        }
        return node.getPrefixCount();
    }
    void erase(String word){
        Node node = root;  
        for(int i =0;i<word.length();i++){
                 if(node.containsKey(word.charAt(i))){
                     node.decCount();
                     node.decPrefix();
                  }
                  node = node.getKey(word.charAt(i));          
            }
         }
    public static void main(String args[]){
         countsWord obj = new countsWord();

         obj.insert("apple");
         obj.insert("apple");
         obj.insert("apps");
         obj.insert("appl");

         System.out.println(obj.countWordStartingsWith("app"));
         System.out.println(obj.countsWordEqualto("apps"));
    }
}
