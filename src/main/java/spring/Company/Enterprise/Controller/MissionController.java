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
import spring.Company.Enterprise.Services.MissionService;
import spring.Company.Enterprise.entities.Mission;



@RestController
@RequestMapping("/company")
public class MissionController {
	
	@Autowired
	MissionService missionService;
	
	
	@PostMapping("/missions")
	public Mission addMission( @RequestBody Mission m) {
		return missionService.addMission(m);
		 
	}
	

	@GetMapping("/missions")
	public List<Mission> getAllDepartements(){
		return missionService.getAll();
	}
	
	
	@GetMapping("/missions/{id}")
	public ResponseEntity<Mission> getMissionById(@PathVariable(value="id") Mission mid){
		
		Mission d=missionService.findMissionById(mid);
		
		if(d==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(d);
		
	}
	
	

	@PutMapping("/missions/{id}")
	public ResponseEntity<Mission> updateMission(@PathVariable(value="id") Mission mid,@Valid @RequestBody Mission mDetails){
		
		Mission m=missionService.findMissionById(mid);
		if(m==null) {
			return ResponseEntity.notFound().build();
		}
		
		m.setDescription(mDetails.getDescription());
		m.setId(mDetails.getId());
		m.setName(mDetails.getName());
		m.setTimesheet(mDetails.getTimesheet());


		Mission updateMission=addMission(m);//////////////////////to modify
		return ResponseEntity.ok().body(updateMission);
		
		
		
	}
	
	@DeleteMapping("/missions/{id}")
	public ResponseEntity<?> deleteContarct(@PathVariable(value="id") Mission mid){
		
		Mission m=missionService.findMissionById(mid);
		if(m==null) {
			return ResponseEntity.notFound().build();
		}
		missionService.deleteMission(m);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

