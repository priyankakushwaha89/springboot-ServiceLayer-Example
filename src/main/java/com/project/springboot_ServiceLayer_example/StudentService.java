package com.project.springboot_ServiceLayer_example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{

	@Autowired
	StudentRepository srepo;
	public Student addStudent(Student student)
	{
		return srepo.save(student);
		
	}
	public List<Student> studentlist() 
	{
		return srepo.findAll();
	}
	public List<Student> studentname(String name)
	{
		return srepo.findByName(name);
	}
	public Student getUpdate(int id, Student student)
	{
		Student s=srepo.findById(id).get();
		s.setName(student.getName());
		s.setSchool(student.getSchool());
		s.setAge(student.getAge());
		return srepo.save(s);
		
	}
	public Optional<Student> getById(int id)
	{
		return srepo.findById(id);
	}
	public String deleteById(int id) 
	{
		 srepo.deleteById(id);
		 return "Data is deleted";
	}
	
	

}
