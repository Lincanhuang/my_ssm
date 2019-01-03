package common.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
