// CS 0445 Spring 2024
// In Class Exercise 2
// Testing the toString() method in PrimQ1 and PrimQ2

// This program should run without changes with your PrimQ1 and PrimQ2 classes.  This
// program requires the following files:
//		QueueInterface.java
//		Moves.java
//		PrimQ1.java
//		PrimQ2.java
//		EmptyQueueException.java

public class InClass2
{
	static String [] S = {"Starbuck", "Adama", "Apollo", "Tigh", "Gaius", "NumberSix"};
	public static void main(String [] args)
	{
		QueueInterface<String> Q1 = new PrimQ1<String>(10);
		QueueInterface<String> Q2 = new PrimQ2<String>(10);
		
		for (int i = 0; i < S.length; i++)
		{
			Q1.enqueue(S[i]);
			Q2.enqueue(S[i]);
		}
		
		System.out.println("Q1: " + Q1.toString());
		System.out.println("Q2: " + Q2.toString());
		
		for (int i = 0; i < 2; i++)
		{
			String X = Q1.dequeue();
			X = Q2.dequeue();
		}
		
		Q1.enqueue("Boomer");
		Q2.enqueue("Boomer");

		System.out.println("Q1: " + Q1.toString());
		System.out.println("Q2: " + Q2.toString());	
	}
}
		