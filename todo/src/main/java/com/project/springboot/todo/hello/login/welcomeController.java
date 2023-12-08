package com.project.springboot.todo.hello.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class welcomeController {
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap mp) {
		mp.put("name","Anupam");
		return "welcome";
	}
//	private String getLoggedinUsername() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		return authentication.getName();
//		}
	
	/*
	 * @RequestMapping(value="login",method=RequestMethod.POST) public String
	 * gotoWelcome(@RequestParam String name, @RequestParam String password,
	 * ModelMap mp) { mp.put("name",name); mp.put("password", password);
	 * if(authenticationservice.authenticate(name, password)) { return "welcome"; }
	 * mp.put("errorMsg", "Invalid credentials! give another try"); return "login";
	 * }
	 */
}
