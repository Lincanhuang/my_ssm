package common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface CommonRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>{

	
	
}
