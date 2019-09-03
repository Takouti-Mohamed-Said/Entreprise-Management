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

import spring.Company.Enterprise.Services.EnterpriseSrvice;
import spring.Company.Enterprise.entities.Enterprise;



@RestController
@RequestMapping("/company")
public class EnterpriseController {
	
	@Autowired
	EnterpriseSrvice enterpriseService;
	
	@PostMapping("/enterprises")
	public Enterprise addEnterprise( @RequestBody Enterprise e) {
		return enterpriseService.addEnterprise(e);
		 
	}
	

	@GetMapping("/enterprises")
	public List<Enterprise> getAllDepartements(){
		return enterpriseService.getAll();
	}
	
	
	@GetMapping("/enterprises/{id}")
	public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable(value="id") int eid){
		
		Enterprise e=enterpriseService.findEnterpriseById(eid);
		
		if(e==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(e);
		
	}
	
	

	@PutMapping("/enterprises/{id}")
	public ResponseEntity<Enterprise> updateEnterprise(@PathVariable(value="id") int eid,@Valid @RequestBody Enterprise cDetails){
		
		Enterprise e=enterpriseService.findEnterpriseById(eid);
		if(e==null) {
			return ResponseEntity.notFound().build();
		}
		
		e.setEmployees(cDetails.getEmployees());
		e.setId(cDetails.getId());
		e.setName(cDetails.getName());
		e.setRaisonSocial(cDetails.getRaisonSocial());

		
		Enterprise updateEnterprise=addEnterprise(e);//////////////////////to modify
		return ResponseEntity.ok().body(updateEnterprise);
		
		
		
	}
	
	@DeleteMapping("/enterprises/{id}")
	public ResponseEntity<?> deleteContarct(@PathVariable(value="id") int eid){
		
		Enterprise e=enterpriseService.findEnterpriseById(eid);
		if(e==null) {
			return ResponseEntity.notFound().build();
		}
		enterpriseService.deleteEnterprise(e);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

