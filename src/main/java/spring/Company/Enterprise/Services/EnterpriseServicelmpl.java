package spring.Company.Enterprise.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Company.Enterprise.Repository.EnterpriseRepository;
import spring.Company.Enterprise.entities.Enterprise;




@Service("EnterpriseServicelmpl")
public class EnterpriseServicelmpl implements EnterpriseSrvice {
	
	@Autowired
	EnterpriseRepository Enterpriserepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Enterprise> getAll() {
		
		return Enterpriserepository.findAll();
	}

	@Override
	public Enterprise addEnterprise(Enterprise e) {
		return Enterpriserepository.save(e);// ajouter dans la base de données
		
	}

	@Override
	public void deleteEnterprise(Enterprise e) {
			em.remove(e); // supprimer depuis la base de données
	}

	@Override
	public void updateEnterprise(Enterprise e) {
		em.merge(e); // modification
		
	}

	@Override
	
	public Enterprise findEnterpriseById(int idEntreprise) {
		return em.find(Enterprise.class, idEntreprise);
	}

	@Override
	public List<Enterprise> listEnterprises() {
		// TODO Auto-generated method stub
		return null;
	}

}
