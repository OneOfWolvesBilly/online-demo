package io.github.oneofwolvesbilly.onlinedemo.currency;

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
import io.github.oneofwolvesbilly.onlinedemo.request.body.FindByCurrencyCodeQueryRequest;
import io.github.oneofwolvesbilly.onlinedemo.request.body.UpdateCurrencyRequest;
import io.github.oneofwolvesbilly.onlinedemo.service.CurrencyService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UpdateCurrencyServiceIntegrationTest {
final static Logger log = LoggerFactory.getLogger(UpdateCurrencyServiceIntegrationTest.class);
	
	@Autowired
	private CurrencyService currencyService;
	
	@Test
	public void saveCurrencyTest() {
		/**取得即將修改之資料*/
		Currency twdData = currencyService.findByCurrencyCode(new FindByCurrencyCodeQueryRequest("TWD"));
		
		log.info("Origin data: {}", twdData);
		
		/** 更新資料 */
		UpdateCurrencyRequest request = new UpdateCurrencyRequest();
		BeanUtils.copyProperties(twdData, request);
		request.setCurrencyName("新臺幣");
		log.info("Data updated. ");
		Assertions.assertTrue(currencyService.updateCurrency(request));
		
		/**
		 * 重新查詢資料
		 */
		Currency newData = currencyService.findByCurrencyCode(new FindByCurrencyCodeQueryRequest("TWD"));
		
		log.info("New data: {}", newData);
	}
}
