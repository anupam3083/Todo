package com.project.springboot.todo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class sayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you doing here?";
	}
	
	@RequestMapping("say-hello-html")
//	@ResponseBody
	public String sayHelloHtml() {
//		StringBuffer sb=new StringBuffer();
//		sb.append("<html>");
//		sb.append("<head>");
//		sb.append("<title>");
//		sb.append("HTML PAGE...............");
//		sb.append("</title>");
//		sb.append("</head>");
//		sb.append("<body>");
//		sb.append("<h1>");
//		sb.append("first HTML PAGE.....................");
//		sb.append("</h1>");
//		sb.append("</body");
//		sb.append("</html>");
		return "sayhello";
	}
}
