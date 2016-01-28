package com.newtglobal.eFmFmFleet.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the eFmFmEmployeeTravelRequest database table.
 * 
 */
@Entity
@Table(name="eFmFmEmployeeTravelRequest")
public class EFmFmEmployeeTravelRequestPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RequestId", length=10)
	private int requestId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RequestDate", length=30)
	private Date requestDate;
	
	@Transient
	private String employeeId;
	
	@Transient
	private String weekOffs;
	
	@Transient
	private String updateRegularRequest;
	
	@Transient
	private int zoneId;
	
	@Transient
	private int areaId;
	
	
	@Transient
	private String resheduleDate;	
	
	
	@Column(name="RequestStatus", length=10)
	private String requestStatus;
	
	@Column(name="RequestType", length=10)
	private String requestType;

	
	@Column(name="TripType", length=10)
	private String tripType;

	@Column(name="DropSequence", length=50)
	private int dropSequence;
	
	@Column(name="ShiftTime", length=30)
	private Time shiftTime;

	
	@Column(name="Approve_Status", length=10)
	private String approveStatus;
		
	@Transient
	private int branchId;

	
	@Transient
	private String userRole;

	@Column(name="ReadFlg", length=10)
	private String readFlg;
	
	@Column(name="IsActive", length=10)
	private String isActive;
	
	@Column(name="PickUpTime")
	private Time pickUpTime;
	
	@Column(name="CompletionStatus", length=10)
	private String completionStatus;
	
	@Transient
	private String pickTime;
	
	
	@Transient
	private Integer employeeCount;
	
	
	@Transient
	private Integer innovaCount;
	
	@Transient
	private Integer tempoCount;
	
	@Transient
	private String typeExecution;
	
	@Transient
	private String filePath;
	

	@Transient
	private String executionDate;

	
	@Transient
	private String time;

	//bi-directional one-to-one association to EFmFmEmployeeMaster
	@ManyToOne
	@JoinColumn(name="TripId")
	private EFmFmEmployeeRequestMasterPO eFmFmEmployeeRequestMaster;
	
	//bi-directional many-to-one association to EFmFmUserMaster
	@ManyToOne
	@JoinColumn(name="UserId")
	private EFmFmUserMasterPO efmFmUserMaster;

	//bi-directional many-to-one association to EFmFmAreaMaster
	@ManyToOne
	@JoinColumn(name="RouteAreaId")
	private EFmFmRouteAreaMappingPO eFmFmRouteAreaMapping;



	public Time getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(Time pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public EFmFmEmployeeTravelRequestPO() {
	}

	public int getRequestId() {
		return requestId;
	}
	
	

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Time getShiftTime() {
		return shiftTime;
	}

	public void setShiftTime(Time shiftTime) {
		this.shiftTime = shiftTime;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	


	public String getPickTime() {
		return pickTime;
	}

	public void setPickTime(String pickTime) {
		this.pickTime = pickTime;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	
	
	public String getWeekOffs() {
		return weekOffs;
	}

	public void setWeekOffs(String weekOffs) {
		this.weekOffs = weekOffs;
	}

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getReadFlg() {
		return readFlg;
	}

	public void setReadFlg(String readFlg) {
		this.readFlg = readFlg;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTripType() {
		return tripType;
	}
	
	

	public String getResheduleDate() {
		return resheduleDate;
	}

	public void setResheduleDate(String resheduleDate) {
		this.resheduleDate = resheduleDate;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	
	

	public String getUpdateRegularRequest() {
		return updateRegularRequest;
	}

	public void setUpdateRegularRequest(String updateRegularRequest) {
		this.updateRegularRequest = updateRegularRequest;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public EFmFmEmployeeRequestMasterPO geteFmFmEmployeeRequestMaster() {
		return eFmFmEmployeeRequestMaster;
	}

	public void seteFmFmEmployeeRequestMaster(
			EFmFmEmployeeRequestMasterPO eFmFmEmployeeRequestMaster) {
		this.eFmFmEmployeeRequestMaster = eFmFmEmployeeRequestMaster;
	}

	public EFmFmUserMasterPO getEfmFmUserMaster() {
		return efmFmUserMaster;
	}

	public void setEfmFmUserMaster(EFmFmUserMasterPO efmFmUserMaster) {
		this.efmFmUserMaster = efmFmUserMaster;
	}

	public EFmFmRouteAreaMappingPO geteFmFmRouteAreaMapping() {
		return eFmFmRouteAreaMapping;
	}

	public void seteFmFmRouteAreaMapping(
			EFmFmRouteAreaMappingPO eFmFmRouteAreaMapping) {
		this.eFmFmRouteAreaMapping = eFmFmRouteAreaMapping;
	}

	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	public int getDropSequence() {
		return dropSequence;
	}

	public void setDropSequence(int dropSequence) {
		this.dropSequence = dropSequence;
	}

	public Integer getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(Integer employeeCount) {
		this.employeeCount = employeeCount;
	}

	public Integer getInnovaCount() {
		return innovaCount;
	}

	public void setInnovaCount(Integer innovaCount) {
		this.innovaCount = innovaCount;
	}

	public Integer getTempoCount() {
		return tempoCount;
	}

	public void setTempoCount(Integer tempoCount) {
		this.tempoCount = tempoCount;
	}

	public String getTypeExecution() {
		return typeExecution;
	}

	public void setTypeExecution(String typeExecution) {
		this.typeExecution = typeExecution;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	
	
}