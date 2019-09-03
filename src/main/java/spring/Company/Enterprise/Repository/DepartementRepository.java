package spring.Company.Enterprise.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.Company.Enterprise.entities.Departement;


@Repository("DepartementRepository")
public interface DepartementRepository extends JpaRepository<Departement, Integer>{

}