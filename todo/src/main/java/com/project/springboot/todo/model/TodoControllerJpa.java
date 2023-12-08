package com.project.springboot.todo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoControllerJpa {
	
	/*
	 * @Autowired private TodoService td;          this TodoService we have used to implement static list which we have overriden with TodoRepository where we are using JPARepository methodsS
	 */	
	@Autowired
	private TodoRepository tdr;
	
	
	
	
	
	public TodoControllerJpa( TodoRepository tdr) {
		//this.td = td;
		this.tdr=tdr;
	}



	@RequestMapping("list-todos")
	public String ListAllTodo(ModelMap mp) {
//		String username=getLoggedInUsername(mp);
		List<Todo> todos=tdr.findByUsername("Anupam");
		mp.addAttribute("todos",todos);
		System.out.println(todos);
		return "listTodos";
	}




	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap mp) {
		
//		String username=getLoggedInUsername(mp);
		Todo todo=new Todo(0,"Anupam","", LocalDate.now().plusYears(1),false);
		mp.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodoPage(ModelMap mp, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUsername("Anupam");
		//String username=getLoggedInUsername(mp);
	//s	td.addTodo("Anupam",todo.getDescription(),todo.getTargetDate(),todo.isDone());
		
		tdr.save(todo);
		return "redirect:list-todos";
	}
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
	//	td.deleteById(id);
		tdr.deleteById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap mp) {
		//Todo todo=td.findById(id);
		Todo todo=tdr.findById(id).get();
		mp.addAttribute("todo", todo);
		return "todo";
	}
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap mp, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
//		String username=getLoggedInUsername(mp);
		todo.setUsername("Anupam");
	//	td.updateTodo(todo);
		tdr.save(todo);

		return "redirect:list-todos";
	}

//	private String getLoggedInUsername(ModelMap mp) {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		return authentication.getName();
//	}
	
}
