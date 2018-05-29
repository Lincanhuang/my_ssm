package system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import system.entity.Resource;
@Repository
public interface ResourceRepository  extends JpaRepository<Resource, Long>{
	  
	
}