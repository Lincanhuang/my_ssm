import java.util.ArrayList;
import java.util.List;
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

import system.entity.User;
import system.service.UserService;
@ContextConfiguration(value= {"classpath:config/spring-dataSourse.xml"}) 
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@Rollback(value = true)
public class MyTest {
	
	@Autowired
	private UserService userService;
	 
	@Test
//	@Transactional(readOnly =false)
	public void getUser() throws Exception {
		User user = new User();
		user.setName("lin");
		user.setPasswd("kfljsdfkajjfkajhkhja");
		userService.addUser(user);
		
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
