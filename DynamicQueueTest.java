import java.util.Scanner;
import java.io.File;

public class DynamicQueueTest{

  public static final int N = 4;

  public static void main(String args[]){

    DynamicQueue[] queues = new DynamicQueue[N];
    for(int i = 0; i < N; i++) {
      queues[i] = new DynamicQueue();
    }
    File source = new File("data.txt");
    Scanner stream;
    
    try {
      stream = new Scanner(source);

      while(stream.hasNextLine()) {
        String value = stream.next();
        int i = stream.nextInt();
        stream.nextLine();

        System.out.print("Read key " + value + " for queue " + i + ". ");
        
        queues[i].insert(value);

        System.out.println("Q" + i + ":" + queues[i].print());
      }

      stream.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("\n..Final Queues..");
    for(int i = 0; i < N; i++) {
      System.out.println("Q" + i + ":" + queues[i].print());
    }

  } // end main
} // end class DynamicQueueTest

