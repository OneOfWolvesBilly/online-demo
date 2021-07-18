package io.github.oneofwolvesbilly.onlinedemo.currency;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.github.oneofwolvesbilly.onlinedemo.entity.Currency;
import io.github.oneofwolvesbilly.onlinedemo.request.body.DeleteCurrencyRequest;
import io.github.oneofwolvesbilly.onlinedemo.service.CurrencyService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DeleteCurrencyServiceIntegrationTest {

	final static Logger log = LoggerFactory.getLogger(DeleteCurrencyServiceIntegrationTest.class);
	
	@Autowired
	private CurrencyService currencyService;
	
	@Test
	public void deleteCurrencyTest() {
		/** 移除前查詢 */
		List<Currency>  query1stTime = currencyService.getAllCurrency();
		for (Currency currency : query1stTime) {
			if(currency != null) {
				log.info("Currency list orinin data : {}" , currency.toString()); 
			}
		}
		/** 移除第一筆資料 */
		Currency deleteData = query1stTime.get(0);
		DeleteCurrencyRequest request= new DeleteCurrencyRequest();
		BeanUtils.copyProperties(deleteData, request);
		Assertions.assertTrue(currencyService.delete(request)); 
		log.info("Removed first data. " ); 
		/** 重新查詢 */
		List<Currency>  query2ndTime = currencyService.getAllCurrency();
		Assertions.assertNotNull(query2ndTime);
		Assertions.assertTrue(query2ndTime.size() == (query1stTime.size()-1));
		for (Currency currency : query2ndTime) {
			if(currency != null) {
				log.info("Currency lsit removed data : {}" , currency.toString()); 
			}
		}
	}
}
