package com.viscount.freedom.domains;
// Generated Mar 2, 2016 10:13:57 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Instructions generated by hbm2java
 */
@Entity
@Table(name = "instructions", schema = "public")
public class Instructions implements java.io.Serializable {

	private long instructionId;
	private String description;
	private String details;
	private Date updatedAt;
	private String adId;
	private Long usnchanged;
	private int siteid;

	public Instructions() {
	}

	public Instructions(long instructionId, String description, String details, Date updatedAt, int siteid) {
		this.instructionId = instructionId;
		this.description = description;
		this.details = details;
		this.updatedAt = updatedAt;
		this.siteid = siteid;
	}

	public Instructions(long instructionId, String description, String details, Date updatedAt, String adId,
			Long usnchanged, int siteid) {
		this.instructionId = instructionId;
		this.description = description;
		this.details = details;
		this.updatedAt = updatedAt;
		this.adId = adId;
		this.usnchanged = usnchanged;
		this.siteid = siteid;
	}

	@Id

	@Column(name = "instruction_id", unique = true, nullable = false)
	public long getInstructionId() {
		return this.instructionId;
	}

	public void setInstructionId(long instructionId) {
		this.instructionId = instructionId;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "details", nullable = false, length = 1024)
	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, length = 29)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "ad_id", length = 200)
	public String getAdId() {
		return this.adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	@Column(name = "usnchanged")
	public Long getUsnchanged() {
		return this.usnchanged;
	}

	public void setUsnchanged(Long usnchanged) {
		this.usnchanged = usnchanged;
	}

	@Column(name = "siteid", nullable = false)
	public int getSiteid() {
		return this.siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

}
