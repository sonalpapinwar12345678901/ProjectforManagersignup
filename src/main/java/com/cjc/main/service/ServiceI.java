package com.cjc.main.service;

import java.util.List;

import com.cjc.main.model.Manager;

public interface ServiceI {
List<Manager> getAlldata(String emailId,String passWord);
}
