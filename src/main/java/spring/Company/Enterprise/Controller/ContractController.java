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

import spring.Company.Enterprise.Services.ContractService;
import spring.Company.Enterprise.entities.Contract;



@RestController
@RequestMapping("/company")
public class ContractController {
	
	@Autowired
	ContractService contractService;
	
	
	@PostMapping("/contracts")
	public Contract addContract( @RequestBody Contract c) {
		return contractService.addContract(c);
		 
	}
	

	@GetMapping("/contracts")
	public List<Contract> getAllDepartements(){
		return contractService.getAll();
	}
	
	
	@GetMapping("/contracts/{id}")
	public ResponseEntity<Contract> getContractById(@PathVariable(value="id") Contract cid){
		
		Contract d=contractService.findContractById(cid);
		
		if(d==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(d);
		
	}
	
	

	@PutMapping("/contracts/{id}")
	public ResponseEntity<Contract> updateContract(@PathVariable(value="id") Contract cid,@Valid @RequestBody Contract cDetails){
		
		Contract c=contractService.findContractById(cid);
		if(c==null) {
			return ResponseEntity.notFound().build();
		}
		
		c.setDateDebut(cDetails.getDateDebut());
		c.setEmployee(cDetails.getEmployee());
		c.setRef(cDetails.getRef());
		c.setSalaire(cDetails.getSalaire());
	

		
		Contract updateContract=addContract(c);//////////////////////to modify
		return ResponseEntity.ok().body(updateContract);
		
		
		
	}
	
	@DeleteMapping("/contracts/{id}")
	public ResponseEntity<?> deleteContarct(@PathVariable(value="id") Contract cid){
		
		Contract c=contractService.findContractById(cid);
		if(c==null) {
			return ResponseEntity.notFound().build();
		}
		contractService.deleteContract(c);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

