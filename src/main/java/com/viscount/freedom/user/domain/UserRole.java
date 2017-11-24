package com.viscount.freedom.user.domain;

import java.util.HashSet;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = {
		"user_id", "role_id" }))
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRole implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private AdminUser user;
	private Role role;
	private Set<UserRoleModule> userRoleModules = new HashSet<UserRoleModule>(0);

	public UserRole() {
	}

	public UserRole(AdminUser user, Role role) {
		this.user = user;
		this.role = role;
	}

	public UserRole(AdminUser user, Role role, Set<UserRoleModule> userRoleModules) {
		this.user = user;
		this.role = role;
		this.userRoleModules = userRoleModules;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	public AdminUser getUser() {
		return this.user;
	}

	public void setUser(AdminUser user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole")
	public Set<UserRoleModule> getUserRoleModules() {
		return this.userRoleModules;
	}

	public void setUserRoleModules(Set<UserRoleModule> userRoleModules) {
		this.userRoleModules = userRoleModules;
	}

}
