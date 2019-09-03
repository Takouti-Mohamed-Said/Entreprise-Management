package spring.Company.Enterprise.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.Company.Enterprise.Services.EmployeeService;
import spring.Company.Enterprise.Services.EnterpriseSrvice;
import spring.Company.Enterprise.entities.Employee;
import spring.Company.Enterprise.entities.Enterprise;


@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EnterpriseSrvice enterpriseService;
	
	/* to save an employee*/
	@PostMapping("/employees/{idEntreprise}")
	public Employee addEmployee( @RequestBody Employee emp, @PathVariable(value="idEntreprise") int idEntreprise) {
		Enterprise e = enterpriseService.findEnterpriseById(idEntreprise);
		emp.setEnterprise(e);
		return employeeService.addEmployee(emp);

	}
	
	/*get all employees*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAll();
	}
	
	/*get employee by empid*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") int empid){
		
		Employee emp=employeeService.findEmployeeById(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") int empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp=employeeService.findEmployeeById(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setNom(empDetails.getNom());
		emp.setPrenom(empDetails.getPrenom());
		emp.setContrat(empDetails.getContract());
		emp.setEmail(empDetails.getEmail());
		emp.setRole(empDetails.getRole());
		emp.setId(empDetails.getId());
		emp.setDepartments(empDetails.getDepartments());
		
		Employee updateEmployee=employeeService.addEmployee(emp);//////////////////////to modify
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value="id") int empid){
		
		Employee emp=employeeService.findEmployeeById(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeService.deleteEmployee(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

