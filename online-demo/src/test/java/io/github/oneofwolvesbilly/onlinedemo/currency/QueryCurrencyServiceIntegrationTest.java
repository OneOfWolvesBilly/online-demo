package io.github.oneofwolvesbilly.onlinedemo.currency;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.github.oneofwolvesbilly.onlinedemo.entity.Currency;
import io.github.oneofwolvesbilly.onlinedemo.service.CurrencyService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class QueryCurrencyServiceIntegrationTest {

	final static Logger log = LoggerFactory.getLogger(QueryCurrencyServiceIntegrationTest.class);
	
	@Autowired
	private CurrencyService currencyService;
	
	@Test
	public void queryCurrencyTest() {
		List<Currency>  result = currencyService.getAllCurrency();
		Assertions.assertNotNull(result);
		for (Currency currency : result) {
			Assertions.assertNotNull(currency);
			if(currency != null) {
				log.info("currency data : {}" , currency.toString()); 
			}
		}
	}
	
}
