package io.github.oneofwolvesbilly.onlinedemo.request.body;

/**
 * 更新幣別請求Body
 * 
 * @author BillyChen
 *
 */
public class UpdateCurrencyRequest {
	
	/**
	 * 流水號
	 */
	private Integer seqId;
	
	/**
	 * 彆別縮寫
	 */
	private String currencyCode;
	
	/**
	 * 幣別中文
	 */
	private String currencyName;

	public UpdateCurrencyRequest() {
	}

	public UpdateCurrencyRequest(Integer seqId, String currencyCode, String currencyName) {
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
	

}
