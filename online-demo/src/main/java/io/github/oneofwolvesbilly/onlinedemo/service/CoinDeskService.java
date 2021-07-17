package io.github.oneofwolvesbilly.onlinedemo.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.oneofwolvesbilly.onlinedemo.entity.Currency;
import io.github.oneofwolvesbilly.onlinedemo.repository.CurrencyRepository;
import io.github.oneofwolvesbilly.onlinedemo.response.body.coindesk.ConvertCoinDeskResponse;
import io.github.oneofwolvesbilly.onlinedemo.response.body.coindesk.ConvertCoinDeskResponseCurrencyDetail;
import io.github.oneofwolvesbilly.onlinedemo.response.third_party_api.coindesk.CoinDeskResponse;

/**
 * Coindesk相關服務
 * @author BillyChen
 *
 */
@Service
public class CoinDeskService extends BaseService{

	@Value("${coindesk.url}")
	private String coindeskUrl;
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	private final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	
	/**
	 * 回傳取得的JSON格式
	 * @return
	 */
	public CoinDeskResponse getOriginCoinDesk() {
		
		return convertStringToBean(doGet(coindeskUrl));
		
	}

	
	/**
	 * 將JSON格式加工後，組成新的資料當作Response回傳
	 * 
	 * @return
	 */
	public ConvertCoinDeskResponse getConvertCoinDesk() {
	
		CoinDeskResponse coindeskResponse = convertStringToBean(doGet(coindeskUrl));
		
		if(coindeskResponse == null || coindeskResponse.getBpi() == null) {
			return null;
		}
		
		List<String> codeList = new ArrayList<String>();

		if(coindeskResponse.getBpi().getUsd()!=null && coindeskResponse.getBpi().getUsd().getCode() !=null) {
			codeList.add(coindeskResponse.getBpi().getUsd().getCode());
		}
		if(coindeskResponse.getBpi().getGbp()!=null && coindeskResponse.getBpi().getGbp().getCode() !=null) {
			codeList.add(coindeskResponse.getBpi().getGbp().getCode());
		}
		if(coindeskResponse.getBpi().getEur()!=null && coindeskResponse.getBpi().getEur().getCode() !=null) {
			codeList.add(coindeskResponse.getBpi().getEur().getCode());
		}
		
		if(codeList.isEmpty()) {
			return null;
		}
		
		List<Currency> currencyList = currencyRepository.findByCurrencyCodeIn(codeList);
		
		if(currencyList == null || currencyList.isEmpty()) {
			return null;
		}
		
		Map<String,String> currencyNameMap = currencyList.stream().collect(Collectors.toMap(Currency::getCurrencyCode,Currency::getCurrencyName));

		List<ConvertCoinDeskResponseCurrencyDetail> detail = new ArrayList<ConvertCoinDeskResponseCurrencyDetail>();

		return convertToResponse(detail ,coindeskResponse,currencyNameMap);
	}

	/**
	 * 將JSON資料轉為新格式
	 * 
	 * @param detail
	 * @param coindeskResponse
	 * @param currencyNameMap
	 * @return
	 */
	private ConvertCoinDeskResponse  convertToResponse(List<ConvertCoinDeskResponseCurrencyDetail> detail,
			CoinDeskResponse coindeskResponse, Map<String,String> currencyNameMap) {

		ConvertCoinDeskResponse convertCoinDeskResponse = new ConvertCoinDeskResponse();
		
		convertCoinDeskResponse.setUpdateDateTime(LocalDateTime.parse(coindeskResponse.getTime().getUpdatedISO(), DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.of("UTC+0")).withZoneSameInstant(ZoneId.of("UTC+8")).format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
		
		if(coindeskResponse.getBpi().getUsd() != null) {
			ConvertCoinDeskResponseCurrencyDetail usdDetail = new ConvertCoinDeskResponseCurrencyDetail();
			if(coindeskResponse.getBpi().getUsd().getCode() != null) {
				usdDetail.setCurrencyCode(coindeskResponse.getBpi().getUsd().getCode());
				usdDetail.setCurrencyName(currencyNameMap.get(coindeskResponse.getBpi().getUsd().getCode()));
			}
			usdDetail.setRate(coindeskResponse.getBpi().getUsd().getRate());
			detail.add(usdDetail);
		}
		
		if(coindeskResponse.getBpi().getGbp()!= null) {
			ConvertCoinDeskResponseCurrencyDetail gbpDetail = new ConvertCoinDeskResponseCurrencyDetail();
			if(coindeskResponse.getBpi().getGbp().getCode() != null) {
				gbpDetail.setCurrencyCode(coindeskResponse.getBpi().getGbp().getCode());
				gbpDetail.setCurrencyName(currencyNameMap.get(coindeskResponse.getBpi().getGbp().getCode()));
			}
			gbpDetail.setRate(coindeskResponse.getBpi().getGbp().getRate());
			detail.add(gbpDetail);
		}
		
		if(coindeskResponse.getBpi().getEur() != null) {
			ConvertCoinDeskResponseCurrencyDetail eurDetail = new ConvertCoinDeskResponseCurrencyDetail();
			if(coindeskResponse.getBpi().getEur().getCode() != null) {
				eurDetail.setCurrencyCode(coindeskResponse.getBpi().getEur().getCode());
				eurDetail.setCurrencyName(currencyNameMap.get(coindeskResponse.getBpi().getEur().getCode()));
			}
			eurDetail.setRate(coindeskResponse.getBpi().getEur().getRate());
			detail.add(eurDetail);
		}
		
		if(!detail.isEmpty())
		{
			convertCoinDeskResponse.setCurrencyDetailList(detail);
		}
		
		return convertCoinDeskResponse;
	}


	/**
	 * 文字轉Bean
	 *  
	 * @param string
	 * @return
	 */
	public CoinDeskResponse convertStringToBean(String string) {
		if(string == null) {
			return null;
		}
		try {
			ObjectMapper mapper= new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JSONObject json = new JSONObject(string);
		    CoinDeskResponse coinDeskResponse;
			coinDeskResponse = mapper.readValue(json.toString(), CoinDeskResponse.class);
		    return coinDeskResponse;
		}catch (JSONException | JsonProcessingException exception){
			exception.printStackTrace();
		}		
		return null;
	}
	
}
