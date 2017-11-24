package com.viscount.freedom.domains;
// Generated Mar 2, 2016 10:13:57 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Zonegroups generated by hbm2java
 */
@Entity
@Table(name = "zonegroups", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "siteid",
		"name" }))
public class Zonegroups implements java.io.Serializable {

	private int zonegroupid;
	private String name;
	private String description;
	private Boolean apbEnabled;
	private Integer apbType;
	private Date apbForgivetime;
	private Boolean apbOnexit;
	private int siteid;
	private Set<Zonegroupzones> zonegroupzoneses = new HashSet<Zonegroupzones>(0);
	private Set<Zonegroupexempt> zonegroupexempts = new HashSet<Zonegroupexempt>(0);
	private Set<Zoneusers> zoneuserses = new HashSet<Zoneusers>(0);

	public Zonegroups() {
	}

	public Zonegroups(int zonegroupid, int siteid) {
		this.zonegroupid = zonegroupid;
		this.siteid = siteid;
	}

	public Zonegroups(int zonegroupid, String name, String description, Boolean apbEnabled, Integer apbType,
			Date apbForgivetime, Boolean apbOnexit, int siteid, Set<Zonegroupzones> zonegroupzoneses,
			Set<Zonegroupexempt> zonegroupexempts, Set<Zoneusers> zoneuserses) {
		this.zonegroupid = zonegroupid;
		this.name = name;
		this.description = description;
		this.apbEnabled = apbEnabled;
		this.apbType = apbType;
		this.apbForgivetime = apbForgivetime;
		this.apbOnexit = apbOnexit;
		this.siteid = siteid;
		this.zonegroupzoneses = zonegroupzoneses;
		this.zonegroupexempts = zonegroupexempts;
		this.zoneuserses = zoneuserses;
	}

	@Id

	@Column(name = "zonegroupid", unique = true, nullable = false)
	public int getZonegroupid() {
		return this.zonegroupid;
	}

	public void setZonegroupid(int zonegroupid) {
		this.zonegroupid = zonegroupid;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "apb_enabled")
	public Boolean getApbEnabled() {
		return this.apbEnabled;
	}

	public void setApbEnabled(Boolean apbEnabled) {
		this.apbEnabled = apbEnabled;
	}

	@Column(name = "apb_type")
	public Integer getApbType() {
		return this.apbType;
	}

	public void setApbType(Integer apbType) {
		this.apbType = apbType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "apb_forgivetime", length = 29)
	public Date getApbForgivetime() {
		return this.apbForgivetime;
	}

	public void setApbForgivetime(Date apbForgivetime) {
		this.apbForgivetime = apbForgivetime;
	}

	@Column(name = "apb_onexit")
	public Boolean getApbOnexit() {
		return this.apbOnexit;
	}

	public void setApbOnexit(Boolean apbOnexit) {
		this.apbOnexit = apbOnexit;
	}

	@Column(name = "siteid", nullable = false)
	public int getSiteid() {
		return this.siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "zonegroups")
	public Set<Zonegroupzones> getZonegroupzoneses() {
		return this.zonegroupzoneses;
	}

	public void setZonegroupzoneses(Set<Zonegroupzones> zonegroupzoneses) {
		this.zonegroupzoneses = zonegroupzoneses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "zonegroups")
	public Set<Zonegroupexempt> getZonegroupexempts() {
		return this.zonegroupexempts;
	}

	public void setZonegroupexempts(Set<Zonegroupexempt> zonegroupexempts) {
		this.zonegroupexempts = zonegroupexempts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "zonegroups")
	public Set<Zoneusers> getZoneuserses() {
		return this.zoneuserses;
	}

	public void setZoneuserses(Set<Zoneusers> zoneuserses) {
		this.zoneuserses = zoneuserses;
	}

}
