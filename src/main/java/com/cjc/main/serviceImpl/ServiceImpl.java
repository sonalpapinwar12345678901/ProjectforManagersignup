package com.cjc.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.dao.HomeDao;
import com.cjc.main.dao.HomeDao1;
import com.cjc.main.model.Employee;
import com.cjc.main.model.Manager;
@Service
public class ServiceImpl {
	@Autowired
	HomeDao1 hs1;
	
	
	public List<Manager> getAlldata(String emailId, String passWord) {
		{
			List<Manager> list=hs1.findAll();
			
		// TODO Auto-generated method stub
		return list;
	}
}
}
