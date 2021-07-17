package io.github.oneofwolvesbilly.onlinedemo.response.body.coindesk;

import java.util.List;

public class ConvertCoinDeskResponse {
	
	private String updateDateTime;
	
	private List<ConvertCoinDeskResponseCurrencyDetail> currencyDetailList;


	public ConvertCoinDeskResponse() {
		super();
	}

	public ConvertCoinDeskResponse(String updateDateTime,
			List<ConvertCoinDeskResponseCurrencyDetail> currencyDetailList) {
		super();
		this.updateDateTime = updateDateTime;
		this.currencyDetailList = currencyDetailList;
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public List<ConvertCoinDeskResponseCurrencyDetail> getCurrencyDetailList() {
		return currencyDetailList;
	}

	public void setCurrencyDetailList(List<ConvertCoinDeskResponseCurrencyDetail> currencyDetailList) {
		this.currencyDetailList = currencyDetailList;
	}


	
	
}
