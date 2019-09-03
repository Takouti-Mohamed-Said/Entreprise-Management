package spring.Company.Enterprise.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.Company.Enterprise.entities.Employee;



@Repository("EmployeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}