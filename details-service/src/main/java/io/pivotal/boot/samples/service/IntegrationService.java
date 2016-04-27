package io.pivotal.boot.samples.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.soap.Detail;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.pivotal.boot.samples.config.DetailProperties;
import io.pivotal.boot.samples.domain.Company;
import io.pivotal.boot.samples.domain.Quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Vinicius Carvalho
 */
@Component
public class IntegrationService {

	private RestTemplate client;
	private DetailProperties properties;

	private Map<String,Quote> quotesCache = new ConcurrentHashMap<>();
	private Map<String,Company> companiesCache = new ConcurrentHashMap();

	@Autowired
	public IntegrationService(@LoadBalanced RestTemplate client, DetailProperties properties) {
		this.client = client;
		this.properties = properties;
	}


	@HystrixCommand(fallbackMethod = "quoteFromCache",  commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
			@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
	})
	public Quote findQuote(String symbol){
		ResponseEntity<Quote> quoteResponse = client.getForEntity(properties.getQuotesService()+"/quotes/{symbol}",Quote.class,symbol);
		quotesCache.put(symbol,quoteResponse.getBody());
		return quoteResponse.getBody();
	}

	@HystrixCommand(fallbackMethod = "companyFromCache",  commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
			@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
	})
	public Company findCompany(String symbol){
		ResponseEntity<Resource<Company>> resource = client.exchange(properties.getCompaniesService()+"/companies/{symbol}", HttpMethod.GET,null,new ParameterizedTypeReference<Resource<Company>>() {},symbol);
		companiesCache.put(symbol,resource.getBody().getContent());
		return resource.getBody().getContent();
	}

	private Quote quoteFromCache(String symbol){
		return quotesCache.get(symbol);
	}

	private Company companyFromCache(String symbol){
		return companiesCache.get(symbol);
	}



}
