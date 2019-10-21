package spring.Company.Enterprise.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Company.Enterprise.Repository.TimeSheetRepository;
import spring.Company.Enterprise.entities.TimeSheet;


@Service("TimeSheetServicelmpl")
public class TimeSheetServicelmpl implements TimeSheetService {
	
	@Autowired
	TimeSheetRepository TimeSheetrepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public List<TimeSheet> getAll() {
		
		return TimeSheetrepository.findAll();
	}
	@Transactional
	@Override
	public TimeSheet addTimeSheet(TimeSheet t) {
		return TimeSheetrepository.save(t);// ajouter dans la base de données
		
	}

	@Override
	public void deleteTimeSheet(TimeSheet t) {
			em.remove(t); // supprimer depuis la base de données
	}
	@Transactional
	@Override
	public void updateTimeSheet(TimeSheet t) {
		em.merge(t); // modification
		
	}

	@Override
	public TimeSheet findTimeSheetById(int t) {
		return em.find(TimeSheet.class, t);
	}

	@Override
	public List<TimeSheet> listTimeSheet() {
		// TODO Auto-generated method stub
		return null;
	}

}
