import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.my.framework.entity.MenuTypeEnum;
import ch.my.project.system.menu.entity.SysMenu;
import ch.my.project.system.menu.service.SysMenuService;
import ch.my.project.system.user.entity.SysUser;
import ch.my.project.system.user.service.SysUserService;
@ContextConfiguration(value= {"classpath:config/spring-context.xml"}) 
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@Rollback(value = false)
//@Transactional
public class MyTest {
	
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private SysUserService sysUserService;
	
//	 
//	@Test
	public void insertChild() throws Exception {
		
		SysMenu m = new SysMenu();
		m.setMenuName("一级菜单3🌴🐟");
//		SysMenu m1 = new SysMenu();
//		m1.setMenuName("二级菜单3");
//		SysMenu m2 = new SysMenu();
//		m2.setMenuName("二级菜单4");
//		m.getChildren().add(m1);
//		m.getChildren().add(m2);
		sysMenuService.save(m);
//		Shiro
		
//		sysMenuService.deleteById(1L);
	}
//	@Test
	public void insertParent() throws Exception {
		SysMenu m3 = new SysMenu();
		m3.setMenuName("二级菜单3");
		SysMenu m = new SysMenu();
		m.setMenuName("一级菜单2");
		m3.setParent(m);
		sysMenuService.save(m3);
	}
	@Test 
	public void testFind() throws Exception {
		SysUser user = new SysUser();
		user.setUsername("testadmin");
		user.setPassword("123");
		sysUserService.enUserHexPwd(user);
//		sysUserService.save(user);
		sysMenuService.listByMenuType(MenuTypeEnum.MENU);
//		System.out.println(sysMenuService.getById(30L));
		
	}
	public void join() {
		 ExecutorService executor = Executors.newFixedThreadPool(8);
		 List<FutureTask<?>> list = new ArrayList<FutureTask<?>>();
		for(int i = 1; i< 50; i++) {
				FutureTask<Boolean> future = new FutureTask<Boolean>(new Callable<Boolean>() {

					@Override
					public Boolean call() throws Exception {
						return false;
					}
				});
				list.add(future);
				executor.submit(future);
			}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (FutureTask<?> ft : list) {  
            try {  
                System.out.println(ft.get());
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (ExecutionException e) {  
                e.printStackTrace();  
            }  
        }  
	}
}
