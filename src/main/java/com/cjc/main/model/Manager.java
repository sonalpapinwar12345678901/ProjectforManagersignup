package com.cjc.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager {
	
	 private String emailId;
    private String firstName;
    private String lastName;
    private String passWord;
    private long dob;
    private String Company;
  
 
    public Manager() {
  
    }
 
    public Manager(String firstName, String lastName, String emailId,String passWord,long dob,String Company) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.emailId = emailId;
         this.passWord=passWord;
         this.dob=dob;
         this.Company=Company;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
   
 
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    
    @Column(name = "pass_word", nullable = false)
    public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Column(name = "dob", nullable = false)
	public long getDob() {
		return dob;
	}

	public void setDob(long dob) {
		this.dob = dob;
	}
	@Column(name = "company", nullable = false)
	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	@Override
	public String toString() {
		return "Manager [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", passWord="
				+ passWord + ", dob=" + dob + ", Company=" + Company + "]";
	}
 
}


