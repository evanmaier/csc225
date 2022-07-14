// Name: Evan Maier
// Student number: V00891872

public class WordFrequencyBST {
  private TreeNode root;
  private int numElements;

  public WordFrequencyBST() {
    root = null;
    numElements = 0;
  }

  /*
   * Purpose: Update the BST by handling input word
   * Parameters: String word - The new word to handle
   * Returns: Nothing
   * Explanation: If there is no entry in the tree
   * representing the word, then the a new entry
   * should be created and placed into the correct
   * location of the BST. Otherwise, the existing
   * entry for the word should have its frequency
   * value incremented.
   */
  public void handleWord(String word) {
    if (root == null) {
      root = new TreeNode(new Entry(word));
    } else {
      handleWordRecursive(word, root);
    }
  }

  /*
   * Purpose: Insert a new node or update existing node
   * Parameters: String word - word to insert / update
   * TreeNode node - the node rooting the subtree
   * we are inserting into
   * Returns: The new subtree root
   */
  private TreeNode handleWordRecursive(String word, TreeNode node) {
    if (node == null) {
      return new TreeNode(new Entry(word));
    }
    int compareResult = node.compareTo(word);
    if (compareResult > 0) {
      node.left = handleWordRecursive(word, node.left);
    } else if (compareResult < 0) {
      node.right = handleWordRecursive(word, node.right);
    } else {
      node.addToFrequency();
    }
    return node;
  }

  /*
   * Purpose: Get the frequency value of the given word
   * Parameters: String word - the word to find
   * Returns: int - the word's associated frequency
   */
  public int getFrequency(String word) {
    return getFrequencyRecursive(word, root);
  }

  /*
   * Purpose: find word and return its frequency
   * Parameters: String word - word to find
   * TreeNode node - root of subtree we are looking in
   * Returns: frequency of word
   */
  private int getFrequencyRecursive(String word, TreeNode node) {
    if (node == null) {
      return 0;
    }
    int compareResult = node.compareTo(word);
    if (compareResult > 0) {
      return getFrequencyRecursive(word, node.left);
    } else if (compareResult < 0) {
      return getFrequencyRecursive(word, node.right);
    } else {
      return node.getData().getFrequency();
    }
  }

  /****************************************************
   * Helper functions for Insertion and Search testing *
   ****************************************************/

  public String inOrder() {
    if (root == null) {
      return "empty";
    }
    return "{" + inOrderRecursive(root) + "}";
  }

  public String inOrderRecursive(TreeNode cur) {
    String result = "";
    if (cur.left != null) {
      result = inOrderRecursive(cur.left) + ",";
    }
    result += cur.getData().getWord();
    if (cur.right != null) {
      result += "," + inOrderRecursive(cur.right);
    }
    return result;
  }

  public String preOrder() {
    if (root == null) {
      return "empty";
    }
    return "{" + preOrderRecursive(root) + "}";
  }

  public String preOrderRecursive(TreeNode cur) {
    String result = cur.getData().getWord();
    if (cur.left != null) {
      result += "," + preOrderRecursive(cur.left);
    }
    if (cur.right != null) {
      result += "," + preOrderRecursive(cur.right);
    }
    return result;
  }

  /****************************************************
   * Helper functions to populate a Heap from this BST *
   ****************************************************/

  public MaxFrequencyHeap createHeapFromTree() {
    MaxFrequencyHeap maxHeap = new MaxFrequencyHeap(numElements + 1);
    addToHeap(maxHeap, root);
    return maxHeap;
  }

  public void addToHeap(MaxFrequencyHeap h, TreeNode n) {
    if (n != null) {
      addToHeap(h, n.left);
      h.insert(n.getData());
      addToHeap(h, n.right);
    }
  }
}