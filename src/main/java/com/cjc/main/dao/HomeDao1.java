package com.cjc.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.main.model.Employee;
import com.cjc.main.model.*;

public interface HomeDao1 extends JpaRepository<Manager, Long>{ 

}
