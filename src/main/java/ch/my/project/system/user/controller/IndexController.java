package ch.my.project.system.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin")
public class IndexController {

	@RequestMapping(value = {"","index"})
	public String index() {
		return "admin/index";
	}
}
