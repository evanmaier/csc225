// Name: Evan Maier
// Student number: V00891872

public class WordFrequencyReport {
  private static final int CAPACITY = 5;

  /*
   * Purpose: Obtain the 5 most frequent words found
   * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
   * Returns: Entry[] - an array containing the top 5 entries (which are the
   * word, frequency pairs with the maximum frequency values)
   */
  public static Entry[] overallMostFrequent(MaxFrequencyHeap h) {
    Entry[] top5 = new Entry[CAPACITY];
    int i = 0;
    while (i < 5 && !h.isEmpty()) {
      top5[i] = h.removeMax();
      i++;
    }
    return top5;
  }

  /*
   * Purpose: Obtain the 5 most frequent words found that are at least n charaters
   * long
   * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
   * int n - minimum word length to consider
   * Returns: Entry[] - an array containing the top 5 entries (which are the
   * word, frequency pairs with the maximum frequency values of words
   * that are at least n characters long)
   */
  public static Entry[] atLeastLength(MaxFrequencyHeap h, int n) {
    Entry[] top5 = new Entry[CAPACITY];
    int i = 0;
    while (i < 5 && !h.isEmpty()) {
      Entry e = h.removeMax();
      if (e.getWord().length() >= n) {
        top5[i] = e;
        i++;
      }
    }
    return top5;
  }

  /*
   * Purpose: Obtain the 5 most frequent words found that begin with the given
   * letter
   * Parameters: MaxFrequencyHeap h - the heap containing all the word entry data
   * char letter - only words that begin with given letter are considered
   * Returns: Entry[] - an array containing the top 5 entries (which are the
   * word, frequency pairs with the maximum frequency values of words
   * that begin with the given letter)
   */
  public static Entry[] startsWith(MaxFrequencyHeap h, char letter) {
    Entry[] top5 = new Entry[CAPACITY];
    int i = 0;
    while (i < 5 && !h.isEmpty()) {
      Entry e = h.removeMax();
      if (e.getWord().charAt(0) == letter) {
        top5[i] = e;
        i++;
      }
    }
    return top5;
  }

}
