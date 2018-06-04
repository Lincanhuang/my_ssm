import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import system.dao.SysResourceRepository;
import system.dao.SysRoleRepository;
import system.entity.SysResource;
import system.entity.SysRole;

@ContextConfiguration(value= {"classpath:config/spring-dataSourse.xml"}) 
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class TestMain {
	@Autowired
	private SysResourceRepository sysResourceRepository;
	@Autowired
	private SysRoleRepository sysRoleRepository;
	@Test
	public void test1() {
		sysRoleRepository.findBySysUsersId(1L );
	}
	
	
	@Test
//	@Transactional
	public void test2() {
		Collection<SysRole> rolesId = new ArrayList<>();
		SysRole s1 = new SysRole();
		s1.setId(1L);
		rolesId.add(s1);
		SysRole s2= new SysRole();
		s1.setId(2L);
		rolesId.add(s2);
		sysRoleRepository.saveAll(rolesId);
		sysResourceRepository.findBySysRolesIn(rolesId);
	}

}
