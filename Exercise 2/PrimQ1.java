// CS 0445 Spring 2024
// Primitive Generic Queue that adds at index 0 of the array
// and removes from the rear of the array

public class PrimQ1<T> implements QueueInterface<T>, Moves
{
	private T [] theQueue;  // Parameter used for array data
	private int size;
	private int moves;

	public PrimQ1(int initsize)
	{
		@SuppressWarnings("unchecked")	
		T [] temp = (T []) new Object[initsize];
		theQueue = temp;
		size = 0;
	}

	public void enqueue(T element)
	{
		if (size == theQueue.length)
			return;
		shift(size);
		moves++;
		theQueue[0] = element;
		size++;
		//System.out.println("Added " + element);
	}
	
	public T dequeue()
	{
		if (size > 0)
		{
			T temp = theQueue[size-1];
			theQueue[size-1] = null;
			size--;
			moves++;  // only 1 move for dequeue
			return temp;
		}
		else
			throw new EmptyQueueException("Queue is empty");
	}
	
	public T getFront()
	{
		if (size > 0)
			return theQueue[size-1];
		else
			throw new EmptyQueueException("Queue is empty");
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void clear()
	{
		@SuppressWarnings("unchecked")
		T [] temp = (T []) new Object[theQueue.length];
		theQueue = temp;
		size = 0;
	}	
	
	private void shift(int amt)
	{
		for (int i = amt; i > 0; i--)
		{
			theQueue[i] = theQueue[i-1];
			moves++;  // each shift requires a move
		}
	}
	
	public int getMoves()
	{
		return moves;
	}
	
	public void setMoves(int val)
	{
		moves = val;
	}
	
	public String toString()
	{
		
		StringBuilder B = new StringBuilder();
		
		String qString;
		
		for (int i = size-1; i <= 0; i++)
		{
			B.append(theQueue[i].toString());
			
		}
		
		return B.toString();
	}
	
}