package io.github.oneofwolvesbilly.onlinedemo.request.body;


/**
 * 由currencyName查詢幣別請求Body
 * 
 * @author BillyChen
 *
 */
public class FindByCurrencyNameQueryRequest {
	
	private String currencyName;

	public FindByCurrencyNameQueryRequest() {
		super();
	}

	public FindByCurrencyNameQueryRequest(String currencyName) {
		super();
		this.currencyName = currencyName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	
	
}
