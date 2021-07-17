package io.github.oneofwolvesbilly.onlinedemo.response.third_party_api.coindesk;

public class CoinDeskResponseTime {
	
	private String updated;
	
	private String updatedISO;
	
	private String updateduk;

	public CoinDeskResponseTime() {
		super();
	}

	public CoinDeskResponseTime(String updated, String updatedISO, String updateduk) {
		super();
		this.updated = updated;
		this.updatedISO = updatedISO;
		this.updateduk = updateduk;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUpdatedISO() {
		return updatedISO;
	}

	public void setUpdatedISO(String updatedISO) {
		this.updatedISO = updatedISO;
	}

	public String getUpdateduk() {
		return updateduk;
	}

	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}
	
	
}
