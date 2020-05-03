package com.adi.equityDemo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;

@Entity
public class SecurityInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long infoId;
	
	@ManyToOne
	@JoinColumn(name="sc_code")
	@JsonIgnore
	private Security security;
	@Transient
	@JsonIgnore
	@CsvBindByName(column = "SC_CODE")
	private Integer sc_code;
	@CsvBindByName(column = "OPEN")
	private Double open;
	@CsvBindByName(column = "HIGH")
	private Double high;
	@CsvBindByName(column = "LOW")
	private Double low;
	@CsvBindByName(column = "CLOSE")
	private Double close;
	@CsvBindByName(column = "LAST")
	private Double last;
	@CsvBindByName(column = "PREVCLOSE")
	private Double prevclose;
	@CsvBindByName(column = "NO_TRADES")
	private Long no_trades;
	@CsvBindByName(column = "NO_OF_SHRS")
	private Long no_of_shrs;
	@CsvBindByName(column = "NET_TURNOV")
	private Double net_turnov;
	@CsvBindByName(column = "TDCLOINDI")
	private String tdcloindi;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getLast() {
		return last;
	}

	public void setLast(Double last) {
		this.last = last;
	}

	public Double getPrevclose() {
		return prevclose;
	}

	public void setPrevclose(Double prevclose) {
		this.prevclose = prevclose;
	}

	public Long getNo_trades() {
		return no_trades;
	}

	public void setNo_trades(Long no_trades) {
		this.no_trades = no_trades;
	}

	public Long getNo_of_shrs() {
		return no_of_shrs;
	}

	public void setNo_of_shrs(Long no_of_shrs) {
		this.no_of_shrs = no_of_shrs;
	}

	public Double getNet_turnov() {
		return net_turnov;
	}

	public void setNet_turnov(Double net_turnov) {
		this.net_turnov = net_turnov;
	}

	public String getTdcloindi() {
		return tdcloindi;
	}

	public void setTdcloindi(String tdcloindi) {
		this.tdcloindi = tdcloindi.trim();
	}

	public Integer getSc_code() {
		return sc_code;
	}

	public void setSc_code(Integer sc_code) {
		this.sc_code = sc_code;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public Long getId() {
		return infoId;
	}

	public void setId(Long id) {
		this.infoId = id;
	}
	
}
