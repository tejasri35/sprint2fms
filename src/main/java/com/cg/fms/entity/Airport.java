package com.cg.fms.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="airport_tbl")
public class Airport {

@Id
@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
@SequenceGenerator(name="mygen",sequenceName="center_seq",allocationSize=1)
@Column(name="acode")
private int acode;

@Column(name="aname",length=15)
private String aname;

@Column(name="alocation",length=15)
private String alocation;

public int getAcode() {
	return acode;
}

public void setAcode(int acode) {
	this.acode = acode;
}

public String getAname() {
	return aname;
}

public void setAname(String aname) {
	this.aname = aname;
}

public String getAlocation() {
	return alocation;
}

public void setAlocation(String alocation) {
	this.alocation = alocation;
}

public Airport(int acode, String aname, String alocation) {
	super();
	this.acode = acode;
	this.aname = aname;
	this.alocation = alocation;
}

public Airport() {
	super();
}


}

