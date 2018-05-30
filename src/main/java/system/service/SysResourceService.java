package system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.dao.SysResourceRepository;
import system.entity.SysResource;

@Service
public class SysResourceService {
	@Autowired
	private SysResourceRepository sysResourceRepository;
	
	public SysResource save(SysResource resource) {
		resource = sysResourceRepository.save(resource);
		return resource;
	}
	
	public void delete(SysResource resource) {
		sysResourceRepository.deleteById(resource.getId());
	}
	
	public void updateId(Long oldId, Long newId) {
		SysResource sysResource = sysResourceRepository.getOne(oldId);
		sysResource.setId(newId);
		sysResourceRepository.save(sysResource);
	}
	public SysResource select(Long id) {
		return sysResourceRepository.getOne(id);
	}
}
