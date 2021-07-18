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

import io.github.oneofwolvesbilly.onlinedemo.response.third_party_api.coindesk.CoinDeskResponse;
import io.github.oneofwolvesbilly.onlinedemo.service.CoinDeskService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CoinDeskServiceOriginDataIntegrationTest {

	final static Logger log = LoggerFactory.getLogger(CoinDeskServiceOriginDataIntegrationTest.class);
	
	@Autowired
	private CoinDeskService coinDeskService;
	
	
	@Test
	public void getOrininData() {
		CoinDeskResponse  originData = coinDeskService.getOriginCoinDesk();
		Assertions.assertNotNull(originData);
		ObjectMapper objectMapper = new ObjectMapper();
		String originDataString =null;
		try {
			originDataString = objectMapper.writeValueAsString(originData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		log.info("\n Origin data : \n {}", originDataString);
		
	}
	
}
