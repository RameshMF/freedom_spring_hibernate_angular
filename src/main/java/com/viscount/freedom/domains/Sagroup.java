package com.viscount.freedom.domains;
// Generated Mar 2, 2016 10:13:57 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Sagroup generated by hbm2java
 */
@Entity
@Table(name = "sagroup", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "sagname", "caid" }))
public class Sagroup implements java.io.Serializable {

	private String sagid;
	private String sagname;
	private String caid;
	private String schedule;
	private Integer acttime;
	private Long startts;
	private Long expirets;
	private Set<Sausers> sauserses = new HashSet<Sausers>(0);

	public Sagroup() {
	}

	public Sagroup(String sagid, String sagname, String caid, String schedule) {
		this.sagid = sagid;
		this.sagname = sagname;
		this.caid = caid;
		this.schedule = schedule;
	}

	public Sagroup(String sagid, String sagname, String caid, String schedule, Integer acttime, Long startts,
			Long expirets, Set<Sausers> sauserses) {
		this.sagid = sagid;
		this.sagname = sagname;
		this.caid = caid;
		this.schedule = schedule;
		this.acttime = acttime;
		this.startts = startts;
		this.expirets = expirets;
		this.sauserses = sauserses;
	}

	@Id

	@Column(name = "sagid", unique = true, nullable = false, length = 50)
	public String getSagid() {
		return this.sagid;
	}

	public void setSagid(String sagid) {
		this.sagid = sagid;
	}

	@Column(name = "sagname", nullable = false, length = 50)
	public String getSagname() {
		return this.sagname;
	}

	public void setSagname(String sagname) {
		this.sagname = sagname;
	}

	@Column(name = "caid", nullable = false, length = 200)
	public String getCaid() {
		return this.caid;
	}

	public void setCaid(String caid) {
		this.caid = caid;
	}

	@Column(name = "schedule", nullable = false, length = 50)
	public String getSchedule() {
		return this.schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@Column(name = "acttime")
	public Integer getActtime() {
		return this.acttime;
	}

	public void setActtime(Integer acttime) {
		this.acttime = acttime;
	}

	@Column(name = "startts")
	public Long getStartts() {
		return this.startts;
	}

	public void setStartts(Long startts) {
		this.startts = startts;
	}

	@Column(name = "expirets")
	public Long getExpirets() {
		return this.expirets;
	}

	public void setExpirets(Long expirets) {
		this.expirets = expirets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sagroup")
	public Set<Sausers> getSauserses() {
		return this.sauserses;
	}

	public void setSauserses(Set<Sausers> sauserses) {
		this.sauserses = sauserses;
	}

}
