// CS 0445 Spring 2024
// Primitive Generic Queue that adds at the rear of an array
// and removes from index 0 of the array.  In other words, index
// 0 will always represent the front item of the queue. Some of this 
// is already completed for you.

// Complete this class so that it works correctly with the program
// CS445Rec1.java

public class PrimQ2<T> implements QueueInterface<T>, Moves
{
	private T [] theQueue;	// the queue array
	private int size;		// logical size (number of items in the queue)
	private int moves;		// moves variable (for bookkeeping)

	// Constructor method.  Note how the array is created here.
	public PrimQ2(int initsize)
	{
		@SuppressWarnings("unchecked")	
		T [] temp = (T []) new Object[initsize];
		theQueue = temp;
		size = 0;
	}

	// See the interface files QueueInterface.java and Moves.java
	// for the requirements for the methods below.
	public void enqueue(T element)
	{
		
	}
	
	public T dequeue()
	{

	}
	
	public T getFront()
	{
		
	}
	
	public boolean isEmpty()
	{
		
	}
	
	public void clear()
	{
		
	}
	
	// I have implemented these already -- fairly simple methods for
	// the Moves interface.	 However, be sure to correctly update the
	// moves variable in your enqueue and dequeue methods.
	public int getMoves()
	{
		return moves;
	}
	
	public void setMoves(int val)
	{
		moves = val;
	}
	
}