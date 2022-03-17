package com.FinalProject.Entity;

public class accounts {
	
	private int sno;
	private int vendorid;
	private String subscription;
	private int paidamount;
	private String paiddate;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public String getSubscription() {
		return subscription;
	}
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	public int getPaidamount() {
		return paidamount;
	}
	public void setPaidamount(int paidamount) {
		this.paidamount = paidamount;
	}
	public String getPaiddate() {
		return paiddate;
	}
	public void setPaiddate(String paiddate) {
		this.paiddate = paiddate;
	}
	public accounts(int sno, int vendorid, String subscription, int paidamount, String paiddate) {
		super();
		this.sno = sno;
		this.vendorid = vendorid;
		this.subscription = subscription;
		this.paidamount = paidamount;
		this.paiddate = paiddate;
	}
	public accounts() {
		super();
	}
	
	

}
