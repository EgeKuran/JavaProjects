package QueueExample;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainClass {
public static void main(String[] args) {
	Deque<String> namesQueue = new ArrayDeque<>();
	
	namesQueue.add("Ege");
	namesQueue.add("Mehmet");
	namesQueue.add("Ali");
	namesQueue.addFirst("Torpilli");
	
	System.out.println("First:" + namesQueue.poll());
	System.out.println("Second:" + namesQueue.poll());
	
	System.out.println("------------------------");

	for (String string : namesQueue) {
		System.out.println(string);
	}
	
}
}
