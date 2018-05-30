package system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import system.entity.SysResource;
@Repository
public interface SysResourceRepository  extends JpaRepository<SysResource, Long>{
	  
}