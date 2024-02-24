// CS 0445 Spring 2024
// Recitation Exercise 6 Main Program
public class CS445Rec6
{
	public static String [] data = {"Waldner","Guoliang","Yaping","Hong","Yue",
															"Xin","Liqin","Long"};
	
	public static void main(String [] args)
	{
		A3LList<String> L = new A3LList<String>();
		
		for (int i = 0; i < data.length; i++)
		{
			L.add(data[i]);  // add at end -- no traversal needed
		}
		
		// Testing recursive contains() method
		for (int i = 0; i < data.length; i++)
		{
			String curr = data[i];
			if (L.contains(curr))
				System.out.println(curr + " was found in the list");
		}
		System.out.println();
		
		String curr = "Seemiller";
		if (!L.contains(curr))
			System.out.println(curr + " was not found in the list");
		System.out.println();
		
		// Testing remove(i) which utilizes recursive getNodeAt() method for
		// locations other than front or back.  So we will remove from the
		// middle to test.
		while (L.getLength() > 0)
		{
			int mid = (L.getLength()/2) + 1;
			System.out.print("Removing at index " + mid + ": ");
			curr = L.remove(mid);
			System.out.println(curr);
		}
	}
}
