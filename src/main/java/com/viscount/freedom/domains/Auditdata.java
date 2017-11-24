package com.viscount.freedom.domains;
// Generated Mar 2, 2016 10:13:57 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Auditdata generated by hbm2java
 */
@Entity
@Table(name = "auditdata", schema = "public")
public class Auditdata implements java.io.Serializable {

	private long id;
	private Long settime;
	private String userid;
	private String action;
	private String dbtable;
	private String changedata;
	private String originaldata;

	public Auditdata() {
	}

	public Auditdata(long id) {
		this.id = id;
	}

	public Auditdata(long id, Long settime, String userid, String action, String dbtable, String changedata,
			String originaldata) {
		this.id = id;
		this.settime = settime;
		this.userid = userid;
		this.action = action;
		this.dbtable = dbtable;
		this.changedata = changedata;
		this.originaldata = originaldata;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "settime")
	public Long getSettime() {
		return this.settime;
	}

	public void setSettime(Long settime) {
		this.settime = settime;
	}

	@Column(name = "userid", length = 200)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "action", length = 10)
	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Column(name = "dbtable", length = 30)
	public String getDbtable() {
		return this.dbtable;
	}

	public void setDbtable(String dbtable) {
		this.dbtable = dbtable;
	}

	@Column(name = "changedata", length = 1000)
	public String getChangedata() {
		return this.changedata;
	}

	public void setChangedata(String changedata) {
		this.changedata = changedata;
	}

	@Column(name = "originaldata", length = 1000)
	public String getOriginaldata() {
		return this.originaldata;
	}

	public void setOriginaldata(String originaldata) {
		this.originaldata = originaldata;
	}

}