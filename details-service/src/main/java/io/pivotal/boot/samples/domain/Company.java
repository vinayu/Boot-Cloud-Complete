package io.pivotal.boot.samples.domain;


/**
 * @author Vinicius Carvalho
 */
public class Company {


	private String symbol;

	private String name;
	private String sector;
	private String industry;
	private String quoteEndpoint;
	private Integer ipoYear;



	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getQuoteEndpoint() {
		return quoteEndpoint;
	}

	public void setQuoteEndpoint(String quoteEndpoint) {
		this.quoteEndpoint = quoteEndpoint;
	}

	public Integer getIpoYear() {
		return ipoYear;
	}

	public void setIpoYear(Integer ipoYear) {
		this.ipoYear = ipoYear;
	}

	public Double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(Double marketCap) {
		this.marketCap = marketCap;
	}

	private Double marketCap;

}
