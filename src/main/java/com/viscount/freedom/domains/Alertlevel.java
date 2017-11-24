package com.viscount.freedom.domains;
// Generated Mar 2, 2016 10:13:57 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alertlevel generated by hbm2java
 */
@Entity
@Table(name = "alertlevel", schema = "public")
public class Alertlevel implements java.io.Serializable {

	private String serverid;
	private Integer alertlevel;

	public Alertlevel() {
	}

	public Alertlevel(String serverid) {
		this.serverid = serverid;
	}

	public Alertlevel(String serverid, Integer alertlevel) {
		this.serverid = serverid;
		this.alertlevel = alertlevel;
	}

	@Id

	@Column(name = "serverid", unique = true, nullable = false, length = 20)
	public String getServerid() {
		return this.serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	@Column(name = "alertlevel")
	public Integer getAlertlevel() {
		return this.alertlevel;
	}

	public void setAlertlevel(Integer alertlevel) {
		this.alertlevel = alertlevel;
	}

}
