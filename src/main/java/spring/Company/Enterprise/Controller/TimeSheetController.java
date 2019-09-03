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

import spring.Company.Enterprise.Services.TimeSheetService;
import spring.Company.Enterprise.entities.TimeSheet;



@RestController
@RequestMapping("/company")
public class TimeSheetController {
	
	@Autowired
	TimeSheetService timeSheetService;
	
	
	@PostMapping("/timeSheets")
	public TimeSheet addTimeSheet( @RequestBody TimeSheet t) {
		return timeSheetService.addTimeSheet(t);
		 
	}
	

	@GetMapping("/timeSheets")
	public List<TimeSheet> getAllDepartements(){
		return timeSheetService.getAll();
	}
	
	
	@GetMapping("/timeSheets/{id}")
	public ResponseEntity<TimeSheet> getTimeSheetById(@PathVariable(value="id") TimeSheet tid){
		
		TimeSheet d=timeSheetService.findTimeSheetById(tid);
		
		if(d==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(d);
		
	}
	
	

	@PutMapping("/timeSheets/{id}")
	public ResponseEntity<TimeSheet> updateTimeSheet(@PathVariable(value="id") TimeSheet tid,@Valid @RequestBody TimeSheet tDetails){
		
		TimeSheet t=timeSheetService.findTimeSheetById(tid);
		if(t==null) {
			return ResponseEntity.notFound().build();
		}
		
		t.setDateDebut(tDetails.getDateDebut());
		t.setDateFin(tDetails.getDateFin());
		t.setEmployee(tDetails.getEmployee());
		t.setId(tDetails.getId());
		t.setMission(tDetails.getMission());

	

		
		TimeSheet updateTimeSheet=addTimeSheet(t);//////////////////////to modify
		return ResponseEntity.ok().body(updateTimeSheet);
		
		
		
	}
	
	@DeleteMapping("/timeSheets/{id}")
	public ResponseEntity<?> deleteContarct(@PathVariable(value="id") TimeSheet tid){
		
		TimeSheet t=timeSheetService.findTimeSheetById(tid);
		if(t==null) {
			return ResponseEntity.notFound().build();
		}
		timeSheetService.deleteTimeSheet(t);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}

