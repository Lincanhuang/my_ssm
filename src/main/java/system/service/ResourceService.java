package system.service;

import org.springframework.beans.factory.annotation.Autowired;

import system.dao.ResourceRepository;
import system.entity.Resource;


public class ResourceService {
	@Autowired
	private ResourceRepository resourceRepository;
	
	public Resource save(Resource resource) {
		resource = resourceRepository.save(resource);
		return resource;
	}
	
	public void delete(Resource resource) {
		resourceRepository.deleteById(resource.getId());
	}
}
