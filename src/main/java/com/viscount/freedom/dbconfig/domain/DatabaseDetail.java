package com.viscount.freedom.dbconfig.domain;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "database_detail")
public class DatabaseDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String databaseName;
	private String databaseType;
	private String hostName;
	private byte isActive;
	private byte isSsl;
	private String password;
	private int port;
	private String username;
	@JsonManagedReference
	private Set<GlobalData> globalDatas = new HashSet<>(0);

	public DatabaseDetail() {
	}

	public DatabaseDetail(Set<GlobalData> globalDatas){
		this.globalDatas = globalDatas;
	}
	
	public DatabaseDetail(String databaseName, String databaseType,
			String hostName, byte isActive, byte isSsl, String password,
			int port, String username) {
		this.databaseName = databaseName;
		this.databaseType = databaseType;
		this.hostName = hostName;
		this.isActive = isActive;
		this.isSsl = isSsl;
		this.password = password;
		this.port = port;
		this.username = username;
	}

	public DatabaseDetail(String databaseName, String databaseType,
			String hostName, byte isActive, byte isSsl, String password,
			int port, String username, Set<GlobalData> globalDatas) {
		this.databaseName = databaseName;
		this.databaseType = databaseType;
		this.hostName = hostName;
		this.isActive = isActive;
		this.isSsl = isSsl;
		this.password = password;
		this.port = port;
		this.username = username;
		this.globalDatas = globalDatas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "database_name", nullable = false, length = 45)
	public String getDatabaseName() {
		return this.databaseName;
	}

	public void setDatabaseName(final String databaseName) {
		this.databaseName = databaseName;
	}

	@Column(name = "database_type", nullable = false, length = 45)
	public String getDatabaseType() {
		return this.databaseType;
	}

	public void setDatabaseType(final String databaseType) {
		this.databaseType = databaseType;
	}

	@Column(name = "host_name", nullable = false, length = 45)
	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(final String hostName) {
		this.hostName = hostName;
	}

	@Column(name = "isActive", nullable = false)
	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(final byte isActive) {
		this.isActive = isActive;
	}

	@Column(name = "isSSL", nullable = false)
	public byte getIsSsl() {
		return this.isSsl;
	}

	public void setIsSsl(final byte isSsl) {
		this.isSsl = isSsl;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Column(name = "port", nullable = false)
	public int getPort() {
		return this.port;
	}

	public void setPort(final int port) {
		this.port = port;
	}

	@Column(name = "username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "databaseDetail", cascade = {CascadeType.ALL})
	public Set<GlobalData> getGlobalDatas() {
		return this.globalDatas;
	}

	public void setGlobalDatas(Set<GlobalData> globalDatas) {
		this.globalDatas = globalDatas;
	}

}
