public class DynamicQueue{

  private DynamicNode front, rear;
  private int size;

  private static final int QUEUESIZE = 4;

  public DynamicQueue(){
    front = null;
    rear = null;
    size = 0;
  }

  public boolean empty(){
    return (front == null);
  }

  public String print(){
    if(front == null)
      return "";
    String queue = "";
    DynamicNode p = front;
    while(p.getNext() != null){
      queue += p.getInfo().toString() + "->";
      p = p.getNext();
    }
    queue += p.getInfo().toString();
    return queue;
  } // end print

  public void insert(Object x){

    DynamicNode p = new DynamicNode(x, null);

    if(empty()) {   //if empty add node, add size
      front = p;
      size++;
    } else if (search(x)) {           //if node exists
      if (rear.getInfo().equals(x)){  //if node is already at rear, do nothing
        System.out.print(x.toString() + " is already in rear. ");
        return;
      }
      if(front.getInfo().equals(x)) { //if node is at front, move to rear
        p = front;
        rear.setNext(p);
        front = p.getNext();
        rear = p;
        p.setNext(null);
        System.out.print("Moving " + x.toString() + " to rear. ");
        return;
      }                               //if not front or rear, must be in middle, search and move to rear
      p = front;
      while (!p.getNext().getInfo().equals(x))
        p = p.getNext();
      DynamicNode q = p.getNext();
      p.setNext(q.getNext());
      rear.setNext(q);
      q.setNext(null);
      System.out.print("Moving " + x.toString() + " to rear. ");
      return;
    } else {    //if node not already in queue, check size and add to rear
      if(size == QUEUESIZE) {
        System.out.print("Q is full, removing front. ");
        front = front.getNext();
        size--; 
      }
      rear.setNext(p);
      size++;
    }
    System.out.print("Inserting " + x.toString() + " in rear. ");
    rear = p;

  } // end insert

  public Object remove(){

    if(empty()){
      System.out.println("queue underflow");
      System.exit(1);
    }

    DynamicNode p = front;
    Object temp = p.getInfo();
    front = p.getNext();
    if(front == null)
      rear = null;

    return temp;

  } // end remove

  private boolean search(Object x){
    DynamicNode q = front;
    while(q != null) {
      if (q.getInfo().equals(x)){
        return true;
      }
      q = q.getNext();
    }
    return false;
  } // end search


} // end class DynamicQueue
