import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueueUserDefinedObjectExample {

	 public static void main(String[] args) {
	        /*
	           The requirement for a PriorityQueue of user defined objects is that

	           1. Either the class should implement the Comparable interface and provide
	              the implementation for the compareTo() function.
	           2. Or you should provide a custom Comparator while creating the PriorityQueue.
	           3. in case both are there then comparator will be taken precedence 
	        */

	        // Create a PriorityQueue
	        PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>((a, b)-> (int)(-a.salary + b.salary));

	        // Add items to the Priority Queue
	        employeePriorityQueue.add(new Employee("Rajeev", 100000.00));
	        employeePriorityQueue.add(new Employee("Chris", 195000.00));
	        employeePriorityQueue.add(new Employee("Andrea", 115000.00));
	        employeePriorityQueue.add(new Employee("Jack", 167000.00));

	        
	        PriorityQueue<Employee> employeePriorityQueue1 = new PriorityQueue<>((a,b)->(a.name.compareTo( b.name)));
	     // Add items to the Priority Queue
	        employeePriorityQueue1.add(new Employee("Rajeev", 100000.00));
	        employeePriorityQueue1.add(new Employee("Chris", 195000.00));
	        employeePriorityQueue1.add(new Employee("Andrea", 115000.00));
	        employeePriorityQueue1.add(new Employee("Jack", 167000.00));
	        
	        
	        while (!employeePriorityQueue.isEmpty()) {
	            System.out.println("Poll "+employeePriorityQueue.poll());
	        }
	        
	        employeePriorityQueue.add(new Employee("Rajeev", 100000.00));
	        employeePriorityQueue.add(new Employee("Chris", 195000.00));
	        employeePriorityQueue.add(new Employee("Andrea", 115000.00));
	        employeePriorityQueue.add(new Employee("Jack", 167000.00));
	        
	        /*
	            The compareTo() method implemented in the Employee class is used to determine
	            in what order the objects should be dequeued.
	        */
	        while (!employeePriorityQueue.isEmpty()) {
	            System.out.println(employeePriorityQueue.remove());
	        }
	        
	        while (!employeePriorityQueue1.isEmpty()) {
	            System.out.println("q1 :"+employeePriorityQueue1.remove());
	        }
	    }
	

static class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Compare two employee objects by their salary
    @Override
    public int compareTo(Employee employee) {
        if(this.getSalary() > employee.getSalary()) {
            return 1;
        } else if (this.getSalary() < employee.getSalary()) {
            return -1;
        } else {
            return 0;
        }
    }
}
}

