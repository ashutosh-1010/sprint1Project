package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Table;





@Entity
@Table(name="payment")
public class IPayment {
	@Id
	@GeneratedValue
	private int pId;

	private int bId;
	
	@OneToOne(cascade=CascadeType.ALL)
	
	ITransaction t;
	
	
	public ITransaction getT() {
		return t;
	}
	public void setT(ITransaction t) {
		this.t = t;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}


	@Override
	public String toString() {
		return "IPayment [pId=" + pId + ", bId=" + bId + ", t=" + t+ "]";
	}
	
}
