package spring.Company.Enterprise.Services;

import java.util.List;

import spring.Company.Enterprise.entities.Employee;



public interface EmployeeService {

	public List<Employee> getAll();
	
	public Employee addEmployee(Employee emp);
	
	public void deleteEmployee(Employee emp);
	
	public void updateEmployee(Employee emp);
	
	public Employee findEmployeeById(int empid);

	List<Employee> listEmployees();
	
}
 