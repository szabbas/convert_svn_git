package com.newtglobal.eFmFmFleet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the eFmFmClientRouteMapping database table.
 * 
 */
@Entity
@Table(name="eFmFmClientRouteMapping")
public class EFmFmClientRouteMappingPO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id", length=15)
	private int id;
	
	@Transient
	String routeName;

	//bi-directional many-to-one association to EFmFmClientBranchPO
	@ManyToOne
	@JoinColumn(name="BranchId")
	private EFmFmClientBranchPO eFmFmClientBranchPO;

	//bi-directional many-to-one association to eFmFmZoneMaster
	@ManyToOne
	@JoinColumn(name="ZoneId")
	private EFmFmZoneMasterPO eFmFmZoneMaster;

	public EFmFmClientRouteMappingPO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public EFmFmClientBranchPO geteFmFmClientBranchPO() {
		return eFmFmClientBranchPO;
	}

	public void seteFmFmClientBranchPO(EFmFmClientBranchPO eFmFmClientBranchPO) {
		this.eFmFmClientBranchPO = eFmFmClientBranchPO;
	}

	public EFmFmZoneMasterPO geteFmFmZoneMaster() {
		return eFmFmZoneMaster;
	}

	public void seteFmFmZoneMaster(EFmFmZoneMasterPO eFmFmZoneMaster) {
		this.eFmFmZoneMaster = eFmFmZoneMaster;
	}

	
}