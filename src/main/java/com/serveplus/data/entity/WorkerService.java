package com.serveplus.data.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "WORKER_SERVICE")
@AssociationOverrides({
    @AssociationOverride(name = "workerServiceId.worker",
        joinColumns = @JoinColumn(name = "WORKER_ID")),
    @AssociationOverride(name = "workerServiceId.service",
        joinColumns = @JoinColumn(name = "SERVICE_ID")) })
public class WorkerService {
		
	@Id
	private WorkerServiceId workerServiceId;
	
	@Column(name = "ISDEFAULT")
	private Boolean isDefault;
	
	@Column(name = "ACTIVE")
	private Boolean active;

	
	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public WorkerServiceId getWorkerServiceId() {
		return workerServiceId;
	}

	public void setWorkerServiceId(WorkerServiceId workerServiceId) {
		this.workerServiceId = workerServiceId;
	}

	

	
}
