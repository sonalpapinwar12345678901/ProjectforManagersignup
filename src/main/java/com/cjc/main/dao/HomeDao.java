package com.cjc.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;


//import com.cjc.main.model.Student;
import com.cjc.main.model.Employee;

public interface HomeDao extends JpaRepository<Employee, Long>{

	//List<Employee> findAll(String emailId, String passWord);

	

}

