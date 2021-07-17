package io.github.oneofwolvesbilly.onlinedemo.response.third_party_api.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinDeskResponseBpi {
	
	@JsonProperty("USD")
	private ExchangeMassege usd;
	
	@JsonProperty("GBP")
	private ExchangeMassege gbp;
	
	@JsonProperty("EUR")
	private ExchangeMassege eur;

	public CoinDeskResponseBpi() {
		super();
	}

	public CoinDeskResponseBpi(ExchangeMassege usd, ExchangeMassege gbp, ExchangeMassege eur) {
		super();
		this.usd = usd;
		this.gbp = gbp;
		this.eur = eur;
	}

	public ExchangeMassege getUsd() {
		return usd;
	}

	public void setUsd(ExchangeMassege usd) {
		this.usd = usd;
	}

	public ExchangeMassege getGbp() {
		return gbp;
	}

	public void setGbp(ExchangeMassege gbp) {
		this.gbp = gbp;
	}

	public ExchangeMassege getEur() {
		return eur;
	}

	public void setEur(ExchangeMassege eur) {
		this.eur = eur;
	}
	
	
}
