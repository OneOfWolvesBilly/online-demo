package io.github.oneofwolvesbilly.onlinedemo.response.body.coindesk;

public class ConvertCoinDeskResponseCurrencyDetail {
	
	private String currencyCode;
	
	private String currencyName;
	
	private String rate;

	public ConvertCoinDeskResponseCurrencyDetail() {
		super();
	}

	public ConvertCoinDeskResponseCurrencyDetail(String currencyCode, String currencyName, String rate) {
		super();
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
		this.rate = rate;
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

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
	
}
