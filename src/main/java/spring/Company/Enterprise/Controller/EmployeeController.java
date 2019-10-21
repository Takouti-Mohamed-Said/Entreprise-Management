package spring.Company.Enterprise.Controller;
import java.util.List;
import javax.transaction.Transactional;
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
import spring.Company.Enterprise.Services.ContractService;
import spring.Company.Enterprise.Services.DepartementService;
import spring.Company.Enterprise.Services.EmployeeService;
import spring.Company.Enterprise.Services.EnterpriseSrvice;
import spring.Company.Enterprise.Services.MissionService;
import spring.Company.Enterprise.Services.TimeSheetService;
import spring.Company.Enterprise.entities.Contract;
import spring.Company.Enterprise.entities.Departement;
import spring.Company.Enterprise.entities.Employee;
import spring.Company.Enterprise.entities.Enterprise;
import spring.Company.Enterprise.entities.Mission;
import spring.Company.Enterprise.entities.TimeSheet;


@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EnterpriseSrvice enterpriseService;
	@Autowired
	DepartementService departementService;
	@Autowired
	ContractService contractService;
	@Autowired
	TimeSheetService timeSheetService;
	@Autowired
	MissionService missionService;
	
	
	/* to save an employee*/
	@PostMapping("/addEmployee/{idEntreprise}")
	public Employee addEmployee( @RequestBody Employee emp, @PathVariable(value="idEntreprise") int idEntreprise) {
		Enterprise e = enterpriseService.findEnterpriseById(idEntreprise);
		emp.setEnterprise(e);
		return employeeService.addEmployee(emp);

	}
	@PostMapping("/employees/{empid}/{idD}")
	public String affectEmployeeToDepartement( @PathVariable(value="empid") int empid, @PathVariable(value="idD") int idD) {
		Employee emp = employeeService.findEmployeeById(empid);
		Departement d = departementService.findDepartementById(idD);
		List<Departement> departmentsOfEmployee= emp.getDepartments();
		List<Employee> EmployeesOfdepartment= d.getEmployee();
		departmentsOfEmployee.add(d);
		EmployeesOfdepartment.add(emp);
		d.setEmployee(EmployeesOfdepartment);
		emp.setDepartments(departmentsOfEmployee);
	    employeeService.updateEmployee(emp);
		departementService.updateDepartement(d);
		// return employeeService.addEmployee(emp);
		return "affectation reussie";  

	}
	
	@PostMapping("/contractemployee/{empid}/{idC}")
	public String affectContractToEmployee( @PathVariable(value="empid") int empid, @PathVariable(value="idC") int idC) {
		Employee emp = employeeService.findEmployeeById(empid);
		Contract c= contractService.findContractById(idC);
		emp.setContract(c);
		employeeService.updateEmployee(emp);
		c.setEmployee(emp);
		contractService.updateContract(c);

		return "affectation reussie"; 
		
	}
	
	@PostMapping("/timesheet/{empid}/{idM}")
	public String affectMissionToEmployee(@RequestBody TimeSheet t, @PathVariable(value="empid") int empid,@PathVariable(value="idM") int idM) {
		Employee emp = employeeService.findEmployeeById(empid);
		Mission m=missionService.findMissionById(idM);
		t.setEmployee(emp);
		t.setMission(m);
		List<TimeSheet> timeSheetOfEmployee = emp.getTimesheet();
		List<TimeSheet> timeSheetOfMission = m.getTimesheet();
		timeSheetOfEmployee.add(t);
		timeSheetOfMission.add(t);
		emp.setTimesheet(timeSheetOfEmployee);
		m.setTimesheet(timeSheetOfMission);
		employeeService.updateEmployee(emp);
		missionService.updateMission(m);
		timeSheetService.addTimeSheet(t);

		return "affectation reussie"; 
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
	
	@GetMapping("/employees/{empid}/{idD}")
	public ResponseEntity<Employee> getEmployeeByIdEmpAndByIdIdD(@PathVariable(value="empid") int empid, @PathVariable(value="idD") int idD){
		
		Employee emp=employeeService.findEmployeeById(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	

	@Transactional
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
		emp.setDepartments(empDetails.getDepartments());
		
		Employee updateEmployee=employeeService.addEmployee(emp);//////////////////////to modify
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	/*Delete an employee*/
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") int empid){
		
		Employee emp=employeeService.findEmployeeById(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeService.deleteEmployee(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

