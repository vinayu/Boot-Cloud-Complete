package io.pivotal.boot.samples.domain;

/**
 * @author Vinicius Carvalho
 */
public class Details {
	private Company company;
	private Quote quote;

	public Details(Company company, Quote quote) {
		this.company = company;
		this.quote = quote;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}
}
