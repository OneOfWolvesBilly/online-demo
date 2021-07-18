package io.github.oneofwolvesbilly.onlinedemo.entity;

import javax.persistence.*;


/**
 * 幣別Entity
 * 
 * @author BillyChen
 *
 */
@Entity
@Table(name="CURRENCY")
public class Currency extends BaseEntity{
	
	/**
	 * 流水號
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SEQ_ID")
	private Integer seqId;
	
	/**
	 * 彆別縮寫
	 */
	@Column(name="CURRENCY_CODE")
	private String currencyCode;
	
	/**
	 * 幣別中文
	 */
	@Column(name="CURRENCY_NAME")
	private String currencyName;

	public Currency() {
	}
	
	public Currency(Integer seqId, String currencyCode, String currencyName) {
		super();
		this.seqId = seqId;
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
	}

	public Integer getSeqId() {
		return seqId;
	}

	public void setSeqId(Integer seqId) {
		this.seqId = seqId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "Currency [seqId=" + seqId + ", currencyCode=" + currencyCode + ", currencyName=" + currencyName + "]";
	}
	
	
}
