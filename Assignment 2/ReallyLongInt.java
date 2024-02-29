// CS 0445 Spring 2024
// This is a partial implementation of the ReallyLongInt class.  You need to
// complete the implementations of the remaining methods.  Also, for this class
// to work, you must complete the implementation of the LinkedListPlus class.
// See additional comments below.



public class ReallyLongInt 	extends LinkedListPlus<Integer> 
							implements Comparable<ReallyLongInt>
{
	private ReallyLongInt()
	{
		super();
	}

	// Data is stored with the LEAST significant digit first in the list.  This is
	// done by adding all digits at the front of the list, which reverses the order
	// of the original string.  Note that because the list is doubly-linked and 
	// circular, we could have just as easily put the most significant digit first.
	// You will find that for some operations you will want to access the number
	// from least significant to most significant, while in others you will want it
	// the other way around.  A doubly-linked list makes this access fairly
	// straightforward in either direction.
	public ReallyLongInt(String s)
	{
		super();
		char c;
		int digit = -1;
		// Iterate through the String, getting each character and converting it into
		// an int.  Then make an Integer and add at the front of the list.  Note that
		// the add() method (from A2LList) does not need to traverse the list since
		// it is adding in position 1.  Note also the the author's linked list
		// uses index 1 for the front of the list.
		for (int i = 0; i < s.length(); i++)
		{
			c = s.charAt(i);
			if (('0' <= c) && (c <= '9'))
			{
				digit = c - '0';
				// Do not add leading 0s
				if (!(digit == 0 && this.getLength() == 0)) 
					this.add(1, Integer.valueOf(digit));
			}
			else throw new NumberFormatException("Illegal digit " + c);
		}
		// If number is all 0s, add a single 0 to represent it
		if (digit == 0 && this.getLength() == 0)
			this.add(1, Integer.valueOf(digit));
	}

	// Copy constructor can just call super()
	public ReallyLongInt(ReallyLongInt rightOp)
	{
		super(rightOp);
	}
	
	// Constructor with a long argument.  You MUST create the ReallyLongInt
	// digits by parsing the long argument directly -- you cannot convert to a String
	// and call the constructor above.  As a hint consider the / and % operators to
	// extract digits from the long value.
	public ReallyLongInt(long X)
	{
		super();
		
		
		if(X == 0)
		{
			
			this.add(1,0);
		}
		else
		
		while(X > 0)
		{
		int tempValue = (int) X % 10;
		this.add(Integer.valueOf(tempValue));
		
		X = X / 10;
		}

	}
	
	
	// Method to put digits of number into a String.  Note that toString()
	// has already been written for LinkedListPlus, but you need to
	// override it to show the numbers in the way they should appear.
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		Node curr = firstNode.prev;
		int i = 0;
		while (i < this.getLength())
		{
			b.append(curr.data.toString());
			b.append("");
			curr = curr.prev;
			i++;
		}
		return b.toString();
	}

	// See notes in the Assignment sheet for the methods below.  Be sure to
	// handle the (many) special cases.  Some of these are demonstrated in the
	// RLITest.java program.

	// Return new ReallyLongInt which is sum of current and argument
	public ReallyLongInt add(ReallyLongInt rightOp)
	{
		
		int l1Length = this.numberOfEntries;
		int l2Length = rightOp.numberOfEntries;
		ReallyLongInt sum = new ReallyLongInt();
		
		int digit = 0;
		int remainder = 0;
		int amount = 0;
		int maxVal = 0;
		
		
		//this code was supposed to add leading 0's to the start of the number with the lesser digits, to make it so they both have
		//the same digits when adding. It kept creating null pointer exceptions that I could not fix. 
		
//		if(l1Length > l2Length)
//		{
//			amount = l1Length - l2Length;
//			maxVal = l1Length;
//			
//			while(amount > 0)
//			{
//				rightOp.add(1,0);
//				amount--;
//			}
//		}
//		if(l1Length < l2Length)
//		{
//			amount = l2Length - l1Length;
//			maxVal = l2Length;
//			
//			while(amount > 0)
//			{
//				this.add(1,0);
//				amount--;
//			}
//		}
		
		
		
		Node temp1 = this.firstNode;
		Node temp2 = rightOp.firstNode;
		
		
		//code for adding. only works with two ReallyBigInts with the same value of digits 
		
		{
			for(int i = 1; i <= l1Length ; i++)
			{
				
				digit = temp2.data + temp2.data + remainder;
				
				if(digit == 10)
				{
					digit = 0;
					remainder = 0;
					sum.add(i, digit);
				}
				else if(digit > 10)
				{
				digit = digit % 10;
				remainder = 10;
				sum.add(i, digit);
				}
				else
				{
					sum.add(i, digit);
					remainder = 0;
					
				}
				
				if(remainder != 0)
				{
					sum.add(1);
				}
				
				temp1 = temp1.next;
				temp2 = temp2.next;
				
				
			}
			
			
		}
			
			
		
		return sum;
		
	}
		
	
	
	// Return new ReallyLongInt which is difference of current and argument
	public ReallyLongInt subtract(ReallyLongInt rightOp)
	{	
	}
	
	
	
	
	// Return new ReallyLongInt which is product of current and argument
	public ReallyLongInt multiply(ReallyLongInt rightOp)
	{
	}
	
	// Return -1 if current ReallyLongInt is less than rOp
	// Return 0 if current ReallyLongInt is equal to rOp
	// Return 1 if current ReallyLongInt is greater than rOp
	public int compareTo(ReallyLongInt rOp)
	{
		Node temp1 = this.firstNode.prev;
		Node temp2 = rOp.firstNode.prev;
		
		if(this.numberOfEntries > rOp.numberOfEntries)
		{
			return 1;
		}
		else if(this.numberOfEntries < rOp.numberOfEntries)
		{
			return -1;
		}
		
		else
		{
			for(int i = 0; i < this.numberOfEntries; i++)
			{
				if(temp1.data > temp2.data)
				{
					return 1;
				}
				else if(temp2.data > temp1.data)
				{
					return -1;
				}
				else
				{}
				temp1 = temp1.prev;
				temp2 = temp2.prev;
			}
			return 0;
		}
	}

	// Is current ReallyLongInt equal to rightOp?  Note that the argument
	// in this case is Object rather than ReallyLongInt.  It is written
	// this way to correctly override the equals() method defined in the
	// Object class.
	public boolean equals(Object rightOp)
	{
		ReallyLongInt rOp = (ReallyLongInt) rightOp;
		
		if(this.compareTo(rOp) == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
