package com.cjc.main.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cjc.main.dao.HomeDao;
import com.cjc.main.dao.HomeDao1;
import com.cjc.main.exception.ResourceNotFoundException;
import com.cjc.main.model.*;
import com.cjc.main.serviceImpl.ServiceImpl;
/*crossorigin link for front and backend purpose*/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class HomeController {
	
@Autowired
 private HomeDao hs;
@Autowired
private HomeDao1 hs1;
@Autowired
private ServiceImpl ser;
@RequestMapping("/")
public String signup()
{
	return "signup";
}

@RequestMapping("/log")
public  void login(@RequestParam("emailld") String emailId,@RequestParam("passWord") String passWord,Model m)
{
	if(emailId.equals("admin")&&passWord.equals("admin"))
			{
		List<Manager> list=ser.getAlldata(emailId,passWord);
		m.addAttribute("data",list);
		
	
		


			}
}
@PostMapping("/managers")
public Manager createManager(@Valid @RequestBody Manager manager) {
    return hs1.save(manager);
}
@GetMapping("/managers")
	public List<Manager> getAllManagers()
	{
	return hs1.findAll();
}

@GetMapping("/employees")
public List<Employee> getAllEmployees() {
    return hs.findAll();
}

@GetMapping("/employees/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
    throws ResourceNotFoundException {
    Employee employee = hs.findById(employeeId)
      .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    return ResponseEntity.ok().body(employee);
}

@PostMapping("/employees")
public Employee createEmployee(@Valid @RequestBody Employee employee) {
    return hs.save(employee);
}

@PutMapping("/employees/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
     @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
    Employee employee = hs.findById(employeeId)
    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

    employee.setEmailId(employeeDetails.getEmailId());
    employee.setLastName(employeeDetails.getLastName());
    employee.setFirstName(employeeDetails.getFirstName());
    employee.setAddress(employeeDetails.getAddress());
    employee.setCity(employeeDetails.getCity());
    employee.setDob(employeeDetails.getDob());
    employee.setMobile(employeeDetails.getMobile());
    final Employee updatedEmployee = hs.save(employee);
    return ResponseEntity.ok(updatedEmployee);
}

@DeleteMapping("/employees/{id}")
public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
     throws ResourceNotFoundException {
    Employee employee = hs.findById(employeeId)
   .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

    hs.delete(employee);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
}
}
