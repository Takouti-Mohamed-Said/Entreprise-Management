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
import spring.Company.Enterprise.Services.DepartementService;
import spring.Company.Enterprise.entities.Departement;



@RestController
@RequestMapping("/company")
public class DepartementController {
	
	@Autowired
	DepartementService departementService;
	
	
	@PostMapping("/departements")
	public Departement addDepartement( @RequestBody Departement d) {
		return departementService.addDepartement(d);
		 
	}
	

	@GetMapping("/departements")
	public List<Departement> getAllDepartements(){
		return departementService.getAll();
	}
	
	
	@GetMapping("/departements/{id}")
	public ResponseEntity<Departement> getDepartementById(@PathVariable(value="id") Departement did){
		
		Departement d=departementService.findDepartementById(did);
		
		if(d==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(d);
		
	}
	
	

	@PutMapping("/departements/{id}")
	public ResponseEntity<Departement> updateDepartement(@PathVariable(value="id") Departement did,@Valid @RequestBody Departement dDetails){
		
		Departement d=departementService.findDepartementById(did);
		if(d==null) {
			return ResponseEntity.notFound().build();
		}
		
		d.setNom(dDetails.getNom());
		d.setId(dDetails.getId());

		
		Departement updateDepartement=addDepartement(d);//////////////////////to modify
		return ResponseEntity.ok().body(updateDepartement);
		
		
		
	}
	
	@DeleteMapping("/departements/{id}")
	public ResponseEntity<?> deleteDepartement(@PathVariable(value="id") Departement did){
		
		Departement d=departementService.findDepartementById(did);
		if(d==null) {
			return ResponseEntity.notFound().build();
		}
		departementService.deleteDepartement(d);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

