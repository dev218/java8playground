package minh.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * I wrote a crawler that visits web pages, stores a few keywords in a database, and follows links to other
 * web pages. I noticed that my crawler was wasting a lot of time visiting the same pages over and over, so
 * I made a hash set, visited, where I'm storing URLs I've already visited. Now the crawler only visits a
 * URL if it hasn't already been visited.
 *
 * Thing is, the crawler is running on my old desktop computer in my parents' basement (where I totally don't
 * live anymore), and it keeps running out of memory because visited is getting so huge.
 *
 * How can I trim down the amount of space taken up by visited?
 *
 */
public class Trie {

    TrieNode root = new TrieNode();

    class TrieNode {
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }

        public boolean hasCharacter(char c) {
            return children.containsKey(c);
        }

        public void addChild(char c){
            children.put(c, new TrieNode());
        }

        public TrieNode getChild(char c){
            return children.get(c);
        }
    }

    public boolean hasVisitedSite(String site) {
        boolean isNewSite = false;
        char endMarker = '\0';

        // start at the root
        TrieNode currentNode = root;

        // now go through every character
        for (int i = 0; i < site.length(); i++) {
            char c = site.charAt(i);

            // if the character not in the dictionary, add it in
            if(!currentNode.hasCharacter(c)) {
                isNewSite = true;
                currentNode.addChild(c);
            }

            // get the next child in the tree
            currentNode = currentNode.getChild(c);
        }

        // at the end, need to put the end marker
        if(!currentNode.hasCharacter(endMarker)) {
            isNewSite = true;
            currentNode.addChild(endMarker);
        }

        return isNewSite;
    }
}
