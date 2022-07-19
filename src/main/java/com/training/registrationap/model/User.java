package com.training.registrationap.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Users")
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", fullName=" + fullName + ", password=" + password
				+ ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="emailId",length=125,nullable=false,unique=true)
	@Email
	@NotEmpty
	private String emailId;
	
	@Column(name="full_name",length=40,nullable=false,unique=true)
	@Size(min = 2,message ="fullName should have at least 2 characters")
	@NotEmpty
	private String fullName;
	
	@Column(name="password",length=40,nullable=false)
	@NotEmpty
	@Size(min =8,message = "Password should have 8 characters")
	@Pattern(regexp = "^(?=\\P{Ll}*\\p{Ll})(?=\\P{Lu}*\\p{Lu})(?=\\P{N}*\\p{N})(?=[\\p{L}\\p{N}]*[^\\p{L}\\p{N}])[\\s\\S]{8,}$",flags = Flag.UNICODE_CASE,message = "Password should contain atleast 1 uppercase,1 lowercase,numbers and also 1 special character")
	private String password;
	
	private String status="active";
	
	
	@Temporal(TemporalType.DATE)
	@CreatedDate
	protected Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	protected Date updatedDate;
	
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public User() {
		
	}
	public User(int id, String emailId, String fullName, String password,String status,Date createdDate,Date updatedDate) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.fullName = fullName;
		this.password = password;
		this.status=status;
		this.createdDate=createdDate;
		this.updatedDate=updatedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
