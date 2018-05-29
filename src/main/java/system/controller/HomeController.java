package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.entity.User;
import system.service.UserService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	@Autowired
	private UserService userSerive;
	@RequestMapping(value="")
	public Object inint() {
		User user = new User();
		user.setName("dsgds");
		user.setSalt("dasgdafsgadeage");
		try {
			 userSerive.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getId());
		return null;
	}
}
