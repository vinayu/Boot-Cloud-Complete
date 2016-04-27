package io.pivotal.boot.samples.service;


import io.pivotal.boot.samples.domain.Company;
import io.pivotal.boot.samples.domain.Details;
import io.pivotal.boot.samples.domain.Quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vinicius Carvalho
 */
@RestController
public class DetailsService {

	private IntegrationService service;

	@Autowired
	public DetailsService(IntegrationService service) {
		this.service = service;
	}


	@RequestMapping(value = "/details/{symbol}")
	public Details details(@PathVariable("symbol") String symbol){
		Quote quote = service.findQuote(symbol);
		Company company = service.findCompany(symbol);
		Details details = new Details(company,quote);
		return details;
	}

}
