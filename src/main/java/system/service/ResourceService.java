package system.service;

import org.springframework.beans.factory.annotation.Autowired;

import system.dao.SysResourceRepository;
import system.entity.SysResource;


public class ResourceService {
	@Autowired
	private SysResourceRepository sysResourceRepository;
	
	public SysResource save(SysResource resource) {
		resource = sysResourceRepository.save(resource);
		return resource;
	}
	
	public void delete(SysResource resource) {
		sysResourceRepository.deleteById(resource.getId());
	}
}
