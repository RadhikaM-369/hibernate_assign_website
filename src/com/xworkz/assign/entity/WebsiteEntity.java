package com.xworkz.assign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="website")

@NamedQueries({ 
@NamedQuery(name="getByNameGoogle", query="select web from WebsiteEntity as web where web.wname ='Google'"),
@NamedQuery(name="getByLikeUrly", query="select web from WebsiteEntity as web where web.wUrl like 'http://www.l%'"),
@NamedQuery(name="getByMinSince", query="select web from WebsiteEntity as web where web.since=(select min(web.since) from WebsiteEntity web)"),
@NamedQuery(name="getByMaxSince", query="select web from WebsiteEntity as web where web.since=(select max(web.since) from WebsiteEntity web)"),
@NamedQuery(name="getBySecondMaxSince", query="select web from WebsiteEntity as web where web.since=(select max(web.since) from WebsiteEntity web WHERE web.since NOT IN (SELECT MAX(web.since) FROM WebsiteEntity web))"),
@NamedQuery(name="getBySecondMinSince", query="select web from WebsiteEntity as web where web.since=(select min(web.since) from WebsiteEntity web WHERE web.since NOT IN (SELECT min(web.since) FROM WebsiteEntity web))")
}) 

public class WebsiteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Id")
	private int id;

	@Column(name="w_name")
	private String wname;
	
	@Column(name="W_Owner")
	private String wOwner;
	
	@Column(name="W_url")
	private String wUrl;
	
	@Column(name="W_since")
	private int since;
	
	@Column(name="W_domain")
	private String domain;
	
	public WebsiteEntity() {
		super();
		
	}
	public WebsiteEntity( String wname, String wOwner, String wUrl, int since, String domain) {
		super();
		
		this.wname = wname;
		this.wOwner = wOwner;
		this.wUrl = wUrl;
		this.since = since;
		this.domain = domain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getwOwner() {
		return wOwner;
	}
	public void setwOwner(String wOwner) {
		this.wOwner = wOwner;
	}
	public String getwUrl() {
		return wUrl;
	}
	public void setwUrl(String wUrl) {
		this.wUrl = wUrl;
	}
	public int getSince() {
		return since;
	}
	public void setSince(int since) {
		this.since = since;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@Override
	public String toString() {
		return "WebsiteEntity [ wname=" + wname + ", wOwner=" + wOwner + ", wUrl=" + wUrl + ", since="
				+ since + ", domain=" + domain + "]";
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	}


