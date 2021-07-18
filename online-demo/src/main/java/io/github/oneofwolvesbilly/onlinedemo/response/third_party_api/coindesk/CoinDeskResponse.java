package io.github.oneofwolvesbilly.onlinedemo.response.third_party_api.coindesk;

public class CoinDeskResponse {
	
	private CoinDeskResponseTime time;
	
	private String disclaimer;
	
	private String chartName;
	
	private CoinDeskResponseBpi bpi;

	public CoinDeskResponse() {
		super();
	}

	public CoinDeskResponse(CoinDeskResponseTime time, String disclaimer, String chartName, CoinDeskResponseBpi bpi) {
		super();
		this.time = time;
		this.disclaimer = disclaimer;
		this.chartName = chartName;
		this.bpi = bpi;
	}

	public CoinDeskResponseTime getTime() {
		return time;
	}

	public void setTime(CoinDeskResponseTime time) {
		this.time = time;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public CoinDeskResponseBpi getBpi() {
		return bpi;
	}

	public void setBpi(CoinDeskResponseBpi bpi) {
		this.bpi = bpi;
	}

	@Override
	public String toString() {
		return "CoinDeskResponse [time=" + time + ", disclaimer=" + disclaimer + ", chartName=" + chartName + ", bpi="
				+ bpi + "]";
	}
	
	
}
