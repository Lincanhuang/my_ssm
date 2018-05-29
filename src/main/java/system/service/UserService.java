package system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.dao.UserRepository;
import system.entity.User;

@Service
public class UserService{
	@Resource
	private UserRepository userRepository;
	@Transactional(readOnly =false)
	public void getUser(User u){
		userRepository.deleteById(6L);
	}
//	@Transactional(readOnly =false)
	public void addUser(User u) {
		userRepository.save(u);
	}
}
