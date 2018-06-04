import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import system.entity.SysResource;
import system.service.SysResourceService;
@ContextConfiguration(value= {"classpath:config/spring-dataSourse.xml"}) 
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
//@Rollback(value = true)
//@Transactional
public class MyTest {
	
	@Autowired
	private SysResourceService sysResourceService;
//	 
//	@Test
	public void insertChild() throws Exception {
		SysResource parent = new SysResource();
		SysResource child1 = new SysResource();
		SysResource child2 = new SysResource();
		parent.setName("0");
		child1.setName("child1");
		child2.setName("child2");
		Set<SysResource> children =new LinkedHashSet<>();
		children.add(child1);
		children.add(child2);
		parent.setChildren(children);
		sysResourceService.save(parent);
	}
//	@Test
	public void insertParent() throws Exception {
		SysResource parent = new SysResource();
		SysResource child = new SysResource();
		SysResource son = new SysResource();
		parent.setName("parent");
		child.setName("child1");
		son.setName("son");
		son.setParent(child);
		child.setParent(parent);
		sysResourceService.save(son);
	}
//	@Test
	public void dele() throws Exception {
		SysResource parent = new SysResource();
		parent.setId(33L);
		sysResourceService.delete(parent);
	}
	@Test
	public void select() {
		sysResourceService.listByUserId(1L);
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
