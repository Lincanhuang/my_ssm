package system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import system.entity.Group;
@Repository
public interface GroupRepository  extends JpaRepository<Group, Long>{
	  
	
}