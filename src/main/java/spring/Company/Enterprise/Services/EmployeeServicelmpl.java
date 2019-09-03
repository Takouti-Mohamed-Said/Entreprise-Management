package spring.Company.Enterprise.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.Company.Enterprise.Repository.EmployeeRepository;
import spring.Company.Enterprise.entities.Employee;




@Service("EmployeeServicelmpl")
public class EmployeeServicelmpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employerepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Employee> getAll() {
		
		return employerepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return employerepository.save(emp);// ajouter dans la base de données
		
	}

	@Override
	public void deleteEmployee(Employee emp) {
			em.remove(emp); // supprimer depuis la base de données
	}

	@Override
	public void updateEmployee(Employee emp) {
		em.merge(emp); // modification
		
	}

	@Override
	public Employee findEmployeeById(int empid) {
		return em.find(Employee.class, empid);
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
