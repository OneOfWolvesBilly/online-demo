package io.github.oneofwolvesbilly.onlinedemo.request.body;

import org.springframework.lang.NonNull;

/**
 * 由currencyCode查詢幣別請求Body
 * 
 * @author BillyChen
 *
 */
public class FindByCurrencyCodeQueryRequest {
	
	@NonNull
	private String currencyCode;

	public FindByCurrencyCodeQueryRequest() {
		super();
	}

	public FindByCurrencyCodeQueryRequest(String currencyCode) {
		super();
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	
}
