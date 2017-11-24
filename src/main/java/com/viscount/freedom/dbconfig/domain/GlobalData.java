package com.viscount.freedom.dbconfig.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "global_data")
public class GlobalData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@JsonBackReference
	private DatabaseDetail databaseDetail;
	private String keyname;
	private String value;

	public GlobalData() {
	}

	public GlobalData(final DatabaseDetail databaseDetail, final String keyname) {
		this.databaseDetail = databaseDetail;
		this.keyname = keyname;
	}

	public GlobalData(final DatabaseDetail databaseDetail, final String keyname, final String value) {
		this.databaseDetail = databaseDetail;
		this.keyname = keyname;
		this.value = value;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "database_detail_id", nullable = false)
	public DatabaseDetail getDatabaseDetail() {
		return this.databaseDetail;
	}

	public void setDatabaseDetail(final DatabaseDetail databaseDetail) {
		this.databaseDetail = databaseDetail;
	}

	@Column(name = "keyname", nullable = false, length = 45)
	public String getKeyname() {
		return this.keyname;
	}

	public void setKeyname(final String keyname) {
		this.keyname = keyname;
	}

	@Column(name = "value", length = 45)
	public String getValue() {
		return this.value;
	}

	public void setValue(final String value) {
		this.value = value;
	}
	
}
