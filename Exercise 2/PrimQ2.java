// CS 0445 Spring 2024
// Primitive Generic Queue that adds at the rear of an array
// and removes from index 0 of the array

public class PrimQ2<T> implements QueueInterface<T>, Moves
{
	private T [] theQueue;  // Parameter used for array data
	private int size;
	private int moves;

	public PrimQ2(int initsize)
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
		theQueue[size] = element;
		moves++;  // only 1 move needed for enqueue
		size++;
	}
	
	public T dequeue()
	{
		if (size > 0)
		{
			T temp = theQueue[0];
			shift(size-1);
			theQueue[size-1] = null;
			moves++;
			size--;
			return temp;
		}
		else
			throw new EmptyQueueException("Queue is empty");
	}
	
	public T getFront()
	{
		if (size > 0)
			return theQueue[0];
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
		for (int i = 0; i < amt; i++)
		{
			theQueue[i] = theQueue[i+1];
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
		
		
		
		for (int i = 0; i < size -1; i++)
		{
			B.append(theQueue[i].toString());
			
		}
		
		return B.toString();
	}
	
}