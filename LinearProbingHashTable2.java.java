// Java Program to Implement Hash Tables with Linear Probing

// Importing all classes from
// java.util package
// Importing all input output classes
import java.io.*;
import java.util.*;
// Importing Scanner class as in do-while
// inputs are entered at run-time when
// menu is popped to user to perform desired action
import java.util.Scanner;

// Helper class - LinearProbingHashTable
class LinearProbingHashTable2 {
	// Member variables of this class
	private int currentSize, maxSize;
	private String[] keys;
	private Object[] vals;

	// Constructor of this class
	public LinearProbingHashTable2(int capacity)
	{
		currentSize = 0;
		maxSize = capacity;
		keys = new String[maxSize];
		vals = new Object[maxSize];
	}

	// Method 1
	// Function to clear hash table
	public void makeEmpty()
	{
		currentSize = 0;
		keys = new String[maxSize];
		vals = new Object[maxSize];
	}

	// Method 2
	// Function to get size of hash table
	public int getSize() { return currentSize; }

	// Method 3
	// Function to check if hash table is full
	public boolean isFull()
	{
		return currentSize == maxSize;
	}

	// Method 4
	// Function to check if hash table is empty
	public boolean isEmpty() { return getSize() == 0; }

	// Method 5
	// Function to check if hash table contains a key
	public boolean contains(String key)
	{
		return get(key) != null;
	}

	// Method 6
	// Function to get hash code of a given key
	private int hash(String key)
	{
		return key.hashCode() % maxSize;
	}

	// Method 7
	// Function to insert key-value pair
	public void insert(String key, Object val)
	{
		int tmp = hash(key);
		int i = tmp;

		// Do-while loop
		// Do part for performing actions
		do {
			if (keys[i] == null) {
				keys[i] = key;
				vals[i] = val;
				currentSize++;
				return;
			}

			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}

			i = (i + 1) % maxSize;

		}

		// Do-while loop
		// while part for condition check
		while (i != tmp);
	}

	// Method 8
	// Function to get value for a given key
	public Object get(String key)
	{
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key))
				return vals[i];
			i = (i + 1) % maxSize;
		}
		return null;
	}

	// Method 9
	// Function to remove key and its value
	public void remove(String key)
	{
		if (!contains(key)) {
			System.out.println("!contains(key) : "+key);
			return;
		}

		// Find position key and delete
		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % maxSize;
		
		//keys[i] = vals[i] = null;
		keys[i] = null; vals[i] = null;

		// rehash all keys
		for (i = (i + 1) % maxSize; keys[i] != null;
			i = (i + 1) % maxSize) {
			String tmp1 = keys[i];
			Object tmp2 = vals[i];
			System.out.println("tmp1:"+tmp1 +"tmp2 : "+tmp2);
			
			//keys[i] = vals[i] = null;
			keys[i] = null;
			vals[i] = null;
			
			currentSize--;
			insert(tmp1, tmp2);
		}
		currentSize--;
	}

	// Method 10
	// Function to print HashTable
	public void printHashTable()
	{
		System.out.println("\nHash Table: ");
		for (int i = 0; i < maxSize; i++)
			if (keys[i] != null)
				System.out.println(keys[i] + " " + vals[i]);
		System.out.println();
	}
}

class Book
{
	int bookId;
	String bookName;
	float bookPrice;
	
	public Book(int bookId, String bookName, float bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}
	
	
}
// Main testing class
// Main Class for LinearProbingHashTableTest
public class BookHashTableTest {
	// Main driver method
	public static void main(String[] args)
	{
		
		Book book1 = new Book(101,"Java5",1000);
		Book book2 = new Book(201,"Java8",2000);
		Book book3 = new Book(301,"Java11",3000);
		Book book4 = new Book(401,"Java15",4000);
		Book book5 = new Book(501,"Java21",5000);
		
		ArrayList list = new ArrayList();
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		list.add(book5);
		
		
		// Creating a scanner object
		// to take input from user
		Scanner scan = new Scanner(System.in);

		// Display messages
		System.out.println("Hash Table Test\n\n");
		System.out.println("Enter size");//5

		// maxSizeake object of LinearProbingHashTable
		LinearProbingHashTable2 lpht
			= new LinearProbingHashTable2(scan.nextInt());

		char ch;

		// Do-while loop
		// Do part for performing actions
		do
		// Menu is displayed
		// LinearProbingHashTable operations performed as
		// per keys Users enter 'y' to continue 'n' if
		// entered by user , the program terminates

		{
			// Menu
			// Display messages
			System.out.println("\nHash Table Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. remove");
			System.out.println("3. get");
			System.out.println("4. clear");
			System.out.println("5. size");

			// Reading integer using nextInt()
			int choice = scan.nextInt();

			// Switch case
			switch (choice) {

			// Case 1
			case 1:

				// Display message
				System.out.println("Enter key and value");
				lpht.insert(scan.next(), list.get(scan.nextInt())); // 0 1 2 3 4
				// Break statement to terminate a case
				break;

			// Case 2
			case 2:

				// Display message
				System.out.println("Enter key");
				lpht.remove(scan.next());
				// Break statement to terminate a case
				break;

			// Case 3
			case 3:

				// Print statements
				System.out.println("Enter key");
				System.out.println("Value = "
								+ lpht.get(scan.next()));
				// Break statement to terminate a case
				break;

			// Case 4
			case 4:

				lpht.makeEmpty();
				// Print statement
				System.out.println("Hash Table Cleared\n");
				// Break statement to terminate a case
				break;

			// Case 5
			case 5:

				// Print statement
				System.out.println("Size = "
								+ lpht.getSize());
				break;

			// Default case
			// Executed when mentioned switch cases are not
			// matched
			default:
				// Print statement
				System.out.println("Wrong Entry \n ");
				// Break statement
				break;
			}

			// Display hash table
			lpht.printHashTable();

			// Display message asking the user whether
			// he/she wants to continue
			System.out.println(
				"\nDo you want to continue (Type y or n) \n");

			// Reading character using charAt() method to
			// fetch
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
