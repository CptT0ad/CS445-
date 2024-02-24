// CS 0445 Spring 2024
// LinkedListPlus<T> class partial implementation

// See the commented methods below.  You must complete this class by
// filling in the method bodies for the remaining methods.  Note that you
// may NOT add any new instance variables, but you may use method variables
// as needed.

public class LinkedListPlus<T> extends A2LList<T>
{
	// Default constructor simply calls super()
	public LinkedListPlus()
	{
		super();
	}
	
	// Copy constructor.  This is a "deepish" copy so it will make new
	// Node objects for all of the nodes in the old list.  However, it
	// is not totally deep since it does NOT make copies of the objects
	// within the Nodes -- rather it just copies the references.  The
	// idea of this method is as follows:  If oldList has at least one
	// Node in it, create the first Node for the new list, then iterate
	// through the old list, appending a new Node in the new list for each
	// Node in the old List.  At the end, link the Nodes around to make sure
	// that the list is circular.
	
	// Note: This method implementation is the topic of Recitation Exercise
	// 4 on Friday, February 9, 2024.  If you cannot get it to work, see the
	// posted solution after the recitation is complete.
	public LinkedListPlus(LinkedListPlus<T> oldList)
	{
		super();
		if (oldList.getLength() > 0)
		{
			// Special case for first Node since we need to set the
			// firstNode instance variable.
			Node temp = oldList.firstNode;
			Node newNode = new Node(temp.data);
			firstNode = newNode;
			
			// Now we traverse the old list, appending a new Node with
			// the correct data to the end of the new list for each Node
			// in the old list.  Note how the loop is done and how the
			// Nodes are linked.
			Node currNode = firstNode;
			temp = temp.next;
			int count = 1;
			while (count < oldList.getLength())
			{
				newNode = new Node(temp.data);
				currNode.next = newNode;
				newNode.prev = currNode;
				temp = temp.next;
				currNode = currNode.next;
				count++;
			}
			currNode.next = firstNode;  // currNode is now at the end of the list.
			firstNode.prev = currNode;	// link to make the list circular
			numberOfEntries = oldList.numberOfEntries;
		}			
	}


	// Make a StringBuilder then traverse the nodes of the list, appending the
	// toString() of the data for each node to the end of the StringBuilder.
	// Finally, return the StringBuilder as a String.  Note that since the list
	// is circular, we cannot look for null.  Rather we must count the Nodes as
	// we progress down the list.
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		Node curr = firstNode;
		int i = 0;
		while (i < this.getLength())
		{
			b.append(curr.data.toString());
			b.append(" ");
			curr = curr.next;
			i++;
		}
		return b.toString();
	}
	
	// Remove num items from the front of the list
	// Note: This code was developed / discussed in In-Class Exercise 3 during
	// Lecture 10.  See solution from that exercise.
	public void leftShift(int num)
	{
		if(num <= 0)
		{
			
		}
		else if(num >= numberOfEntries)
		{
			clear();
		}
		else
		{
			Node lastNode = firstNode.prev;
			for(int i = 0; i < num; i++)
			{
				firstNode = firstNode.next;
			}
			firstNode.setPrevNode(lastNode);
			lastNode.setNextNode(firstNode);
			numberOfEntries -= num;
		}
		
	}

	// Remove num items from the end of the list
	public void rightShift(int num)
	{
		if(num <= 0)
		{
			
		}
		else if(num >= numberOfEntries)
		{
			clear();
		}
		else
		{
			Node lastNode = firstNode.prev;
			for(int i = 0; i < num; i++)
			{
				lastNode = lastNode.prev;
			}
			firstNode.setPrevNode(lastNode);
			lastNode.setNextNode(firstNode);
			numberOfEntries -= num;
		}
		
	}

	// Rotate to the left num locations in the list.  No Nodes
	// should be created or destroyed.
	public void leftRotate(int num)
	{
		if(num < 0)
		{
			rightRotate(Math.abs(num));
		}
		num = num % numberOfEntries;
		
		
		for(int i = 0; i < num; i++)
		{
			firstNode = firstNode.next;
			
	
		}
			
	}

	// Rotate to the right num locations in the list.  No Nodes
	// should be created or destroyed.
	public void rightRotate(int num)
	{
		if(num < 0)
		{
			leftRotate(Math.abs(num));
		}
		num = num % numberOfEntries;
		
		
		for(int i = 0; i < num; i++)
		{
			firstNode = firstNode.prev;
			
	
		}
			
	}
	}	


