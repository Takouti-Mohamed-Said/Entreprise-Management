package spring.Company.Enterprise.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.Company.Enterprise.entities.TimeSheet;


@Repository("TimeSheetRepository")
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer>{

}