package com.serveplus.data.dao;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Configurable;


public class EntityBaseEventListener {

	
	@PrePersist
	public void touchForCreate(Object target) {
		System.out.println();
	}
	
	@PreUpdate
	public void touchForUpdate(Object target) {
		System.out.println();
	}
}
