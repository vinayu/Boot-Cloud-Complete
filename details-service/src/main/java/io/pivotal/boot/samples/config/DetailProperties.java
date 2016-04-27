package io.pivotal.boot.samples.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Vinicius Carvalho
 */
@ConfigurationProperties(prefix = "details")
public class DetailProperties {
	private String quotesService;
	private String companiesService;

	public String getQuotesService() {
		return quotesService;
	}

	public void setQuotesService(String quotesService) {
		this.quotesService = quotesService;
	}

	public String getCompaniesService() {
		return companiesService;
	}

	public void setCompaniesService(String companiesService) {
		this.companiesService = companiesService;
	}
}
