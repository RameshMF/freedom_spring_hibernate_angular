package com.viscount.freedom.domains;
// Generated Mar 2, 2016 10:13:57 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Inputaction generated by hbm2java
 */
@Entity
@Table(name = "inputaction", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = { "description",
		"siteid" }))
public class Inputaction implements java.io.Serializable {

	private String iaid;
	private Deviceports deviceportsByConditiondev1;
	private Deviceports deviceportsByResetReader;
	private Deviceports deviceportsByResetPort;
	private Deviceports deviceportsByConditionstate2;
	private Deviceports deviceportsByIndevice;
	private Deviceports deviceportsByInport;
	private Deviceports deviceportsByShuntDev;
	private Deviceports deviceportsByOutport;
	private Deviceports deviceportsByConditiondev2;
	private Deviceports deviceportsByConditionport1;
	private Deviceports deviceportsByOutdevice;
	private Deviceports deviceportsByShuntPort;
	private Rargroup rargroup;
	private Schedule schedule;
	private Boolean instate;
	private Integer action;
	private Integer predelay;
	private Integer ontime;
	private Boolean alarm;
	private Integer conditionstate1;
	private Integer conditionport2;
	private Integer condition;
	private String description;
	private Integer alarmlevel;
	private String alarmmsg;
	private String zoneid;
	private Integer zoneaction;
	private Integer supvstate;
	private Long instructionId;
	private Boolean ackrequired;
	private Long usnchanged;
	private String netcam;
	private Integer netcamport;
	private Integer netcamaction;
	private Integer netcampreeventtime;
	private Integer netcamactivationtime;
	private Integer shuntWindow;
	private int siteid;
	private String homeZoneid;
	private Boolean enabled;
	private Boolean exceptSchedule;

	public Inputaction() {
	}

	public Inputaction(String iaid, String description, int siteid) {
		this.iaid = iaid;
		this.description = description;
		this.siteid = siteid;
	}

	public Inputaction(String iaid, Deviceports deviceportsByConditiondev1, Deviceports deviceportsByResetReader,
			Deviceports deviceportsByResetPort, Deviceports deviceportsByConditionstate2,
			Deviceports deviceportsByIndevice, Deviceports deviceportsByInport, Deviceports deviceportsByShuntDev,
			Deviceports deviceportsByOutport, Deviceports deviceportsByConditiondev2,
			Deviceports deviceportsByConditionport1, Deviceports deviceportsByOutdevice,
			Deviceports deviceportsByShuntPort, Rargroup rargroup, Schedule schedule, Boolean instate, Integer action,
			Integer predelay, Integer ontime, Boolean alarm, Integer conditionstate1, Integer conditionport2,
			Integer condition, String description, Integer alarmlevel, String alarmmsg, String zoneid,
			Integer zoneaction, Integer supvstate, Long instructionId, Boolean ackrequired, Long usnchanged,
			String netcam, Integer netcamport, Integer netcamaction, Integer netcampreeventtime,
			Integer netcamactivationtime, Integer shuntWindow, int siteid, String homeZoneid, Boolean enabled,
			Boolean exceptSchedule) {
		this.iaid = iaid;
		this.deviceportsByConditiondev1 = deviceportsByConditiondev1;
		this.deviceportsByResetReader = deviceportsByResetReader;
		this.deviceportsByResetPort = deviceportsByResetPort;
		this.deviceportsByConditionstate2 = deviceportsByConditionstate2;
		this.deviceportsByIndevice = deviceportsByIndevice;
		this.deviceportsByInport = deviceportsByInport;
		this.deviceportsByShuntDev = deviceportsByShuntDev;
		this.deviceportsByOutport = deviceportsByOutport;
		this.deviceportsByConditiondev2 = deviceportsByConditiondev2;
		this.deviceportsByConditionport1 = deviceportsByConditionport1;
		this.deviceportsByOutdevice = deviceportsByOutdevice;
		this.deviceportsByShuntPort = deviceportsByShuntPort;
		this.rargroup = rargroup;
		this.schedule = schedule;
		this.instate = instate;
		this.action = action;
		this.predelay = predelay;
		this.ontime = ontime;
		this.alarm = alarm;
		this.conditionstate1 = conditionstate1;
		this.conditionport2 = conditionport2;
		this.condition = condition;
		this.description = description;
		this.alarmlevel = alarmlevel;
		this.alarmmsg = alarmmsg;
		this.zoneid = zoneid;
		this.zoneaction = zoneaction;
		this.supvstate = supvstate;
		this.instructionId = instructionId;
		this.ackrequired = ackrequired;
		this.usnchanged = usnchanged;
		this.netcam = netcam;
		this.netcamport = netcamport;
		this.netcamaction = netcamaction;
		this.netcampreeventtime = netcampreeventtime;
		this.netcamactivationtime = netcamactivationtime;
		this.shuntWindow = shuntWindow;
		this.siteid = siteid;
		this.homeZoneid = homeZoneid;
		this.enabled = enabled;
		this.exceptSchedule = exceptSchedule;
	}

	@Id

	@Column(name = "iaid", unique = true, nullable = false, length = 200)
	public String getIaid() {
		return this.iaid;
	}

	public void setIaid(String iaid) {
		this.iaid = iaid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conditiondev1")
	public Deviceports getDeviceportsByConditiondev1() {
		return this.deviceportsByConditiondev1;
	}

	public void setDeviceportsByConditiondev1(Deviceports deviceportsByConditiondev1) {
		this.deviceportsByConditiondev1 = deviceportsByConditiondev1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reset_reader")
	public Deviceports getDeviceportsByResetReader() {
		return this.deviceportsByResetReader;
	}

	public void setDeviceportsByResetReader(Deviceports deviceportsByResetReader) {
		this.deviceportsByResetReader = deviceportsByResetReader;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reset_port")
	public Deviceports getDeviceportsByResetPort() {
		return this.deviceportsByResetPort;
	}

	public void setDeviceportsByResetPort(Deviceports deviceportsByResetPort) {
		this.deviceportsByResetPort = deviceportsByResetPort;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conditionstate2")
	public Deviceports getDeviceportsByConditionstate2() {
		return this.deviceportsByConditionstate2;
	}

	public void setDeviceportsByConditionstate2(Deviceports deviceportsByConditionstate2) {
		this.deviceportsByConditionstate2 = deviceportsByConditionstate2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indevice")
	public Deviceports getDeviceportsByIndevice() {
		return this.deviceportsByIndevice;
	}

	public void setDeviceportsByIndevice(Deviceports deviceportsByIndevice) {
		this.deviceportsByIndevice = deviceportsByIndevice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inport")
	public Deviceports getDeviceportsByInport() {
		return this.deviceportsByInport;
	}

	public void setDeviceportsByInport(Deviceports deviceportsByInport) {
		this.deviceportsByInport = deviceportsByInport;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shunt_dev")
	public Deviceports getDeviceportsByShuntDev() {
		return this.deviceportsByShuntDev;
	}

	public void setDeviceportsByShuntDev(Deviceports deviceportsByShuntDev) {
		this.deviceportsByShuntDev = deviceportsByShuntDev;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "outport")
	public Deviceports getDeviceportsByOutport() {
		return this.deviceportsByOutport;
	}

	public void setDeviceportsByOutport(Deviceports deviceportsByOutport) {
		this.deviceportsByOutport = deviceportsByOutport;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conditiondev2")
	public Deviceports getDeviceportsByConditiondev2() {
		return this.deviceportsByConditiondev2;
	}

	public void setDeviceportsByConditiondev2(Deviceports deviceportsByConditiondev2) {
		this.deviceportsByConditiondev2 = deviceportsByConditiondev2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conditionport1")
	public Deviceports getDeviceportsByConditionport1() {
		return this.deviceportsByConditionport1;
	}

	public void setDeviceportsByConditionport1(Deviceports deviceportsByConditionport1) {
		this.deviceportsByConditionport1 = deviceportsByConditionport1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "outdevice")
	public Deviceports getDeviceportsByOutdevice() {
		return this.deviceportsByOutdevice;
	}

	public void setDeviceportsByOutdevice(Deviceports deviceportsByOutdevice) {
		this.deviceportsByOutdevice = deviceportsByOutdevice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shunt_port")
	public Deviceports getDeviceportsByShuntPort() {
		return this.deviceportsByShuntPort;
	}

	public void setDeviceportsByShuntPort(Deviceports deviceportsByShuntPort) {
		this.deviceportsByShuntPort = deviceportsByShuntPort;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reset_group")
	public Rargroup getRargroup() {
		return this.rargroup;
	}

	public void setRargroup(Rargroup rargroup) {
		this.rargroup = rargroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule")
	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Column(name = "instate")
	public Boolean getInstate() {
		return this.instate;
	}

	public void setInstate(Boolean instate) {
		this.instate = instate;
	}

	@Column(name = "action")
	public Integer getAction() {
		return this.action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	@Column(name = "predelay")
	public Integer getPredelay() {
		return this.predelay;
	}

	public void setPredelay(Integer predelay) {
		this.predelay = predelay;
	}

	@Column(name = "ontime")
	public Integer getOntime() {
		return this.ontime;
	}

	public void setOntime(Integer ontime) {
		this.ontime = ontime;
	}

	@Column(name = "alarm")
	public Boolean getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Boolean alarm) {
		this.alarm = alarm;
	}

	@Column(name = "conditionstate1")
	public Integer getConditionstate1() {
		return this.conditionstate1;
	}

	public void setConditionstate1(Integer conditionstate1) {
		this.conditionstate1 = conditionstate1;
	}

	@Column(name = "conditionport2")
	public Integer getConditionport2() {
		return this.conditionport2;
	}

	public void setConditionport2(Integer conditionport2) {
		this.conditionport2 = conditionport2;
	}

	@Column(name = "condition")
	public Integer getCondition() {
		return this.condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	@Column(name = "description", nullable = false, length = 50)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "alarmlevel")
	public Integer getAlarmlevel() {
		return this.alarmlevel;
	}

	public void setAlarmlevel(Integer alarmlevel) {
		this.alarmlevel = alarmlevel;
	}

	@Column(name = "alarmmsg", length = 100)
	public String getAlarmmsg() {
		return this.alarmmsg;
	}

	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	@Column(name = "zoneid", length = 200)
	public String getZoneid() {
		return this.zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

	@Column(name = "zoneaction")
	public Integer getZoneaction() {
		return this.zoneaction;
	}

	public void setZoneaction(Integer zoneaction) {
		this.zoneaction = zoneaction;
	}

	@Column(name = "supvstate")
	public Integer getSupvstate() {
		return this.supvstate;
	}

	public void setSupvstate(Integer supvstate) {
		this.supvstate = supvstate;
	}

	@Column(name = "instruction_id")
	public Long getInstructionId() {
		return this.instructionId;
	}

	public void setInstructionId(Long instructionId) {
		this.instructionId = instructionId;
	}

	@Column(name = "ackrequired")
	public Boolean getAckrequired() {
		return this.ackrequired;
	}

	public void setAckrequired(Boolean ackrequired) {
		this.ackrequired = ackrequired;
	}

	@Column(name = "usnchanged")
	public Long getUsnchanged() {
		return this.usnchanged;
	}

	public void setUsnchanged(Long usnchanged) {
		this.usnchanged = usnchanged;
	}

	@Column(name = "netcam", length = 200)
	public String getNetcam() {
		return this.netcam;
	}

	public void setNetcam(String netcam) {
		this.netcam = netcam;
	}

	@Column(name = "netcamport")
	public Integer getNetcamport() {
		return this.netcamport;
	}

	public void setNetcamport(Integer netcamport) {
		this.netcamport = netcamport;
	}

	@Column(name = "netcamaction")
	public Integer getNetcamaction() {
		return this.netcamaction;
	}

	public void setNetcamaction(Integer netcamaction) {
		this.netcamaction = netcamaction;
	}

	@Column(name = "netcampreeventtime")
	public Integer getNetcampreeventtime() {
		return this.netcampreeventtime;
	}

	public void setNetcampreeventtime(Integer netcampreeventtime) {
		this.netcampreeventtime = netcampreeventtime;
	}

	@Column(name = "netcamactivationtime")
	public Integer getNetcamactivationtime() {
		return this.netcamactivationtime;
	}

	public void setNetcamactivationtime(Integer netcamactivationtime) {
		this.netcamactivationtime = netcamactivationtime;
	}

	@Column(name = "shunt_window")
	public Integer getShuntWindow() {
		return this.shuntWindow;
	}

	public void setShuntWindow(Integer shuntWindow) {
		this.shuntWindow = shuntWindow;
	}

	@Column(name = "siteid", nullable = false)
	public int getSiteid() {
		return this.siteid;
	}

	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}

	@Column(name = "home_zoneid", length = 200)
	public String getHomeZoneid() {
		return this.homeZoneid;
	}

	public void setHomeZoneid(String homeZoneid) {
		this.homeZoneid = homeZoneid;
	}

	@Column(name = "enabled")
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "except_schedule")
	public Boolean getExceptSchedule() {
		return this.exceptSchedule;
	}

	public void setExceptSchedule(Boolean exceptSchedule) {
		this.exceptSchedule = exceptSchedule;
	}

}
