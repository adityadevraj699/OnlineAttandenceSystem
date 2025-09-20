package com.myproject.OnlineAttandenceSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class StudentDetail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(nullable = false)
	private String name;
	
	 @Column(nullable = false, unique = true)
	private String rollNo;

	 public long getId() {
		 return Id;
	 }

	 public void setId(long id) {
		 Id = id;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getRollNo() {
		 return rollNo;
	 }

	 public void setRollNo(String rollNo) {
		 this.rollNo = rollNo;
	 }
	
}
