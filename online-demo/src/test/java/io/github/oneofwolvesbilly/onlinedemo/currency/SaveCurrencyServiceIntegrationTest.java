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
import io.github.oneofwolvesbilly.onlinedemo.request.body.SaveCurrencyRequest;
import io.github.oneofwolvesbilly.onlinedemo.service.CurrencyService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SaveCurrencyServiceIntegrationTest {
	final static Logger log = LoggerFactory.getLogger(SaveCurrencyServiceIntegrationTest.class);
	
	@Autowired
	private CurrencyService currencyService;
	
	@Test
	public void saveCurrencyTest() {
		/** 儲存前查詢 */
		List<Currency>  query1stTime = currencyService.getAllCurrency();
		for (Currency currency : query1stTime) {
			if(currency != null) {
				log.info("Currency list orinin data : {}" , currency.toString()); 
			}
		}
		/** 儲存一筆新資料 */
		SaveCurrencyRequest request= new SaveCurrencyRequest();
		request.setCurrencyCode("CAD");
		request.setCurrencyName("加幣");
		Assertions.assertTrue(currencyService.save(request)); 
		log.info("Removed first data. " ); 
		/** 重新查詢 */
		List<Currency>  query2ndTime = currencyService.getAllCurrency();
		Assertions.assertNotNull(query2ndTime);
		Assertions.assertTrue(query2ndTime.size() == (query1stTime.size()+1));
		for (Currency currency : query2ndTime) {
			if(currency != null) {
				log.info("Currency lsit added data : {}" , currency.toString()); 
			}
		}
	}
}
