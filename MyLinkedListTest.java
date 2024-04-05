// we "dont know" that what we "dont know"

public class MyLinkedListTest {
	public static void main(String[] args) {
		Employee emp1 = new Employee(101,"Jack",10000);
		Employee emp2 = new Employee(102,"Jane",20000);
		Employee emp3 = new Employee(103,"Jill",30000);
		
		MyLinkedList list = new MyLinkedList();
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		
		list.printAll();
		
	}
}

class MyLinkedList
{
	Employee start=null;
	Employee current=null;
	
	void addAtBegining(Employee node) {
		if(start==null) {
			start = node; //first object
			current = node;
			start.next = null;
			start.prev = null;
		}
		else {
			
		}
	}
	
	void add(Employee node) {
		if(start==null) {
			start = node; //first object
			current = node;
			start.next = null;
			start.prev = null;
		}
		else {
			current.next = node; //2nd object
			node.prev = current;
			current = node;
		}
	}
	
	void printAll() {
		Employee ptr = start;
		while(ptr!=null) {
			System.out.println(ptr.hashCode()+" "+ptr.show());
			ptr = ptr.next;
		}
		
	}
}

class Employee
{
	private int empNumber;
	private String empName;
	private float empSalary;
	
	Employee next;
	Employee prev;
	
	public Employee(int empNumber, String empName, float empSalary) {
		super();
		this.empNumber = empNumber;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	
	public String show() {
		if(this.prev==null )
			return prev+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next.hashCode();
		else
			if(this.next==null)
				return prev.hashCode()+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next;
			else
				return prev.hashCode()+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next.hashCode();
					
	}
	
	
}