package com.adi.equityDemo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.opencsv.bean.CsvBindByName;

@Entity
public class Security {
	@Id
	@CsvBindByName(column = "SC_CODE")
	private Integer sc_code;
	@CsvBindByName(column = "SC_NAME")
	private String sc_name;
	@CsvBindByName(column = "SC_GROUP")
	private String sc_group;
	@CsvBindByName(column = "SC_TYPE")
	private String sc_type;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "security")
	private List<SecurityInfo> infoList;

	public Integer getSc_code() {
		return sc_code;
	}

	public void setSc_code(Integer sc_code) {
		this.sc_code = sc_code;
	}

	public String getSc_name() {
		return sc_name;
	}

	public void setSc_name(String sc_name) {
		this.sc_name = sc_name.trim();
	}

	public String getSc_group() {
		return sc_group;
	}

	public void setSc_group(String sc_group) {
		this.sc_group = sc_group.trim();
	}

	public String getSc_type() {
		return sc_type;
	}

	public void setSc_type(String sc_type) {
		this.sc_type = sc_type.trim();
	}

	public List<SecurityInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<SecurityInfo> infoList) {
		this.infoList = infoList;
	}

	@Override
	public boolean equals(Object obj) {
		return this.getSc_code().equals(((Security) obj).getSc_code());
	}
}
