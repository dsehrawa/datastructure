package trie;

// Java implementation of search and insert operations
// on Trie
public class Trie {

    static int ALPHABET_SIZE = 26;
    static TrieNode root;

    static class TrieNode{
        TrieNode[] childrens = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfTheWorld;
    }

    static void insert(String key){

        TrieNode currentNode = root;

        for(char keyChar : key.toCharArray()){
            int index = keyChar - 'a';

            if (currentNode.childrens[index] == null){
                currentNode.childrens[index] = new TrieNode();
            }
            currentNode = currentNode.childrens[index];
        }
        currentNode.isEndOfTheWorld = true;
    }

    static boolean search(String key){
        TrieNode currentNode = root;

        for(char keyIntem : key.toCharArray()){
            int index = keyIntem - 'a';
            if (currentNode.childrens[index] == null){
                return false;
            }
            currentNode = currentNode.childrens[index];
        }

        return currentNode.isEndOfTheWorld;
    }

    // Driver
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
// This code is contributed by Sumit Ghosh
