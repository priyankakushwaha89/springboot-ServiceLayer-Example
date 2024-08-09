package com.project.springboot_ServiceLayer_example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{

	@Autowired
	StudentService serv;//object of service layer
	
	@RequestMapping("/test")//Basic end for test run
	public String test()
	{
		return "Service Layer example";
	}
	
	//endpoint for saving student data
	@PostMapping("/save")
	public Student save(@RequestBody Student student)
	{
		return serv.addStudent(student);
	}
	
	//endpoint for displaying the student data in the form of list
	@GetMapping("/all")
	public List<Student> allData()
	{
		return serv.studentlist();
	}
	
	//endpoint for retreving a specific student data using name
	@GetMapping("/{name}")
	public List<Student> byName(@PathVariable String name)
	{
		return serv.studentname(name);
	}
	
	//endpoint for updating the data
	@PutMapping("/upd/{id}")
	public Student update(@PathVariable int id,@RequestBody Student student)
	{
		return serv.getUpdate(id,student);
	}
	
	//endpoint for retreving a specific student data using id
	@GetMapping("/by/{id}")
	public Optional<Student> byId(@PathVariable int id)
	{
		return serv.getById(id);
	}
	
	//endpoint for deleting student data
	@DeleteMapping("/del/{id}")
	public String delete(@PathVariable int id)
	{
		return serv.deleteById(id);
	}
}
