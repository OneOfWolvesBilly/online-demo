package io.github.oneofwolvesbilly.onlinedemo.request.body;


/**
 * 新增幣別請求Body
 * 
 * @author BillyChen
 *
 */
public class SaveCurrencyRequest {
	
	private String currencyCode;
	
	private String currencyName;

	public SaveCurrencyRequest() {
		super();
	}

	public SaveCurrencyRequest(String currencyCode, String currencyName) {
		super();
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
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
