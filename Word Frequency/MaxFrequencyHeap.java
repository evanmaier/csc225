// Name: Evan Maier 
// Student number: V00891872

import java.util.ArrayList;

public class MaxFrequencyHeap implements PriorityQueue {

  private static final int DEFAULT_CAPACITY = 10;
  private Entry[] data;
  private int size;
  private ArrayList<Entry> list = new ArrayList<>();

  public MaxFrequencyHeap() {
    data = new Entry[DEFAULT_CAPACITY];
    size = 0;
  }

  public MaxFrequencyHeap(int size) {
    data = new Entry[size];
    size = 0;
  }

  public void insert(Entry element) {
    list.add(element);
    heapifyUp(list.size() - 1);
  }

  public Entry removeMax() {
    swap(0, list.size() - 1);
    Entry largest = list.remove(list.size() - 1);
    heapifyDown(0);
    return largest;
  }

  public boolean isEmpty() {
    if (list.size() == 0) {
      return true;
    }
    return false;
  }

  public int size() {
    return list.size();
  }

  private void heapifyUp(int my_index) {
    // recursive bottom-up
    int parent_index = (my_index - 1) / 2;
    Entry me = list.get(my_index);
    Entry my_parent = list.get(parent_index);
    if (my_index != 0 && me.getFrequency() > my_parent.getFrequency()) {
      swap(parent_index, my_index);
      heapifyUp(parent_index);
    }
  }

  private void swap(int index_a, int index_b) {
    Entry temp = list.get(index_a);
    list.set(index_a, list.get(index_b));
    list.set(index_b, temp);
  }

  private void heapifyDown(int i) {
    // recursive top down
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < list.size() && list.get(left).getFrequency() > list.get(largest).getFrequency()) {
      largest = left;
    }
    if (right < list.size() && list.get(right).getFrequency() > list.get(largest).getFrequency()) {
      largest = right;
    }
    if (largest != i) {
      swap(largest, i);
      heapifyDown(largest);
    }
  }

}
