package com.vk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PersonLeave")
public class PersonLeave {

	@Id
	@Column(name="lid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	
	@Column(name="eid")
    private String eid;
	
	@Column(name="email")
	private String email;

	@Column(name="leave_type")
	private String leave_type;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="leave_start")
	private String leave_start;
	
	@Column(name="leave_end")
	private String leave_end;
	
    @Column(name="days")
	private String days;
    
    @Column(name="reason")
	private String reason;
	
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}


	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
	

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}



	
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLeave_start() {
		return leave_start;
	}

	public void setLeave_start(String leave_start) {
		this.leave_start = leave_start;
	}

	public String getLeave_end() {
		return leave_end;
	}

	public void setLeave_end(String leave_end) {
		this.leave_end = leave_end;
	}

	public String getDays() {
		return days;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setDays(String days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString(){
		return "lid="+lid+",leave_type="+leave_type+", fullname="+fullname+",leave_start="+leave_start+",leave_end="+leave_end+",days="+days+",reason="+reason+"";
	}
}
