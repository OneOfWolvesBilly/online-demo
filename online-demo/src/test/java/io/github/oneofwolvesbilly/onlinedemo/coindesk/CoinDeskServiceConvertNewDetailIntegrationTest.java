package io.github.oneofwolvesbilly.onlinedemo.coindesk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.oneofwolvesbilly.onlinedemo.response.body.coindesk.ConvertCoinDeskResponse;
import io.github.oneofwolvesbilly.onlinedemo.service.CoinDeskService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CoinDeskServiceConvertNewDetailIntegrationTest {

	final static Logger log = LoggerFactory.getLogger(CoinDeskServiceConvertNewDetailIntegrationTest.class);
	
	@Autowired
	private CoinDeskService coinDeskService;
	
	@Test
	public void getConvertData() {
		ConvertCoinDeskResponse  convertData = coinDeskService.getConvertCoinDesk();
		Assertions.assertNotNull(convertData);
		ObjectMapper objectMapper = new ObjectMapper();
		String convertDataString =null;
		try {
			convertDataString = objectMapper.writeValueAsString(convertData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		log.info("\n Convert data : \n {}", convertDataString);
		
	}
}
