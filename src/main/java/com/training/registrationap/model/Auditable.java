package com.training.registrationap.model;


import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //capture auditing information while you are inserting a record or updating a record
public class Auditable {
	
	@Temporal(TemporalType.DATE)
	@CreatedDate
	protected Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	protected Date updatedDate;
	
	

}
