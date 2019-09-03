package spring.Company.Enterprise.Services;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.Company.Enterprise.Repository.DepartementRepository;
import spring.Company.Enterprise.entities.Departement;



@Service("DepartementServicelmpl")
public class DepartementServicelmpl implements DepartementService {
	
	@Autowired
	DepartementRepository Departementrepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Departement> getAll() {
		
		return Departementrepository.findAll();
	}

	@Override
	public Departement addDepartement(Departement d) {
		return Departementrepository.save(d);// ajouter dans la base de données
		
	}

	@Override
	public void deleteDepartement(Departement d) {
			em.remove(d); // supprimer depuis la base de données
	}

	@Override
	public void updateDepartement(Departement d) {
		em.merge(d); // modification
		
	}

	@Override
	public Departement findDepartementById(Departement d) {
		return em.find(Departement.class, d.getId());
	}

	@Override
	public List<Departement> listDepartements() {
		// TODO Auto-generated method stub
		return null;
	}

}
