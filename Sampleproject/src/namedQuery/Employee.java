package namedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(
		{
			@NamedQuery(
					name="findEmployeeByName",
					 query = "from Employee e where e.name = :name"  
					)
		}
		)

@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	private int salary;
	private String job;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Employee(int id, String name, int salary, String job) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.job = job;
	}
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", job=" + job + "]";
	}
	
}
