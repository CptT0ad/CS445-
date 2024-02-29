// CS 0445 Spring 2024
// In Class Exercise 4
// Recursing on two arrays of different lengths.  Think about how this can help
// you with Assignment 3. Even though Assignment 3 is utilizing linked lists
// rather than arrays, the recursive approach will be similar.

public class InClass4
{
	static Integer [] A1 = {1000, 2000, 3000, 4000, 5000};
	static Integer [] A2 = {100, 200, 300, 400, 500, 600, 700};
	static Integer [] A3 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
	static Integer [] A4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public static void main(String [] args)
	{
		showData(A1);
		showData(A2);
		showData(A3);
		showData(A4);
		
		Integer [] ans = addThem(A1, A2);  // second arg is longer
		showData(ans);
		
		ans = addThem(A3, ans);  // first arg is longer
		showData(ans);
		
		ans = addThem(ans, A4);  // both args have same length
		showData(ans);
	}
	
	public static void showData(Integer [] data)
	{
		System.out.print("Data is: ");
		showDataRec(data, 0);
	}
	
	public static void showDataRec(Integer [] data, int loc)
	{
		if (loc < data.length)
		{
			System.out.print(data[loc] + " ");
			showDataRec(data, loc+1);
		}
		else
			System.out.println();
	}
	
	public static Integer [] addThem(Integer [] left, Integer [] right)
	{
		// Implement this method.  Note: You will want to write a second
		// method to do the actual recursion.
	}
	
}
		