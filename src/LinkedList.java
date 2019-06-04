/**
 * Data structure which has a 2 objects, one for data and other is address/ref of the next node
 * last node is null
 * First node is head
 */
public class LinkedList {

  Node start, end;
  private int length = 0;

  public void addNode(int val) {
    Node newNode = new Node(val,null);
    length++;
    if(start == null){
      start = newNode;
      end = newNode;
    }
    else {
      end.next = newNode;
      end = newNode;
    }
  }

  public void printLinkedList() {
    Node current = start;
    while(current!=null){
      System.out.println(current.val);
      current = current.next;
    }
  }

  public void printMiddle() {
    Node slowPtr = start;
    Node fastPtr = start;
    int middleVal = -1;

    while (fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
      if (fastPtr.next != null) {
        fastPtr = fastPtr.next;
      }
      middleVal = slowPtr.val;
    }
    System.out.println("This is the middle value::"+middleVal);
  }

  public boolean searchElement(int val){
    Node current = start;
    boolean found = false;
    if(current==null)
      return found;

    while(current!=null){
      if(current.val == val){
        found = true;
        return found;
      }
      current = current.next;
    }
    return found;
  }

  public void deleteNode(int val) {
    Node current = start;
    if(current.val == val) {

    }
  }

}

class Node{
  int val;
  Node next;

  public Node(int val, Node next){
    this.val = val;
    this.next = next;
  }
}
