package io.pivotal.boot.samples.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author Vinicius Carvalho
 */
@Component
@RefreshScope
public class CompanyService {
	@Value("${companies.fetch.size}")
	private Integer fetchSize;
}
