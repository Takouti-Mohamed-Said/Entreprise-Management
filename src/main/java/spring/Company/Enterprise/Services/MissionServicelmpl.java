package spring.Company.Enterprise.Services;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.Company.Enterprise.Repository.MissionRepository;
import spring.Company.Enterprise.entities.Mission;



@Service("MissionServicelmpl")
public class MissionServicelmpl implements MissionService {
	
	@Autowired
	MissionRepository Missionrepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Mission> getAll() {
		
		return Missionrepository.findAll();
	}
	@Transactional
	@Override
	public Mission addMission(Mission m) {
		return Missionrepository.save(m);// ajouter dans la base de données
		
	}

	@Override
	public void deleteMission(Mission m) {
			em.remove(m); // supprimer depuis la base de données
	}
	@Transactional
	@Override
	public void updateMission(Mission m) {
		em.merge(m); // modification
		
	}

	@Override
	public Mission findMissionById(int m) {
		return em.find(Mission.class, m);
	}

	@Override
	public List<Mission> listMissions() {
		// TODO Auto-generated method stub
		return null;
	}

}
