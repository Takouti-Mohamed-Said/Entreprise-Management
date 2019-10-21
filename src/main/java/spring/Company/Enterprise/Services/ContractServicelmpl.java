package spring.Company.Enterprise.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Company.Enterprise.Repository.ContractRepository;
import spring.Company.Enterprise.entities.Contract;




@Service("ContratServicelmpl")
public class ContractServicelmpl implements ContractService {
	
	@Autowired
	ContractRepository Contractrepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Contract> getAll() {
		
		return Contractrepository.findAll();
	}

	@Override
	public Contract addContract(Contract c) {
		return Contractrepository.save(c);// ajouter dans la base de données
		
	}

	@Override
	public void deleteContract(Contract c) {
			em.remove(c); // supprimer depuis la base de données
	}
	@Transactional
	@Override
	public void updateContract(Contract c) {
		em.merge(c); // modification
		
	}

	@Override
	public Contract findContractById(int c) {
		return em.find(Contract.class, c);
	}

	@Override
	public List<Contract> listContracts() {
		// TODO Auto-generated method stub
		return null;
	}

}
