package io.github.oneofwolvesbilly.onlinedemo.controller.currency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.oneofwolvesbilly.onlinedemo.controller.BaseController;
import io.github.oneofwolvesbilly.onlinedemo.entity.Currency;
import io.github.oneofwolvesbilly.onlinedemo.request.body.FindByCurrencyCodeQueryRequest;
import io.github.oneofwolvesbilly.onlinedemo.request.body.FindByCurrencyNameQueryRequest;
import io.github.oneofwolvesbilly.onlinedemo.response.BaseResponse;
import io.github.oneofwolvesbilly.onlinedemo.service.CurrencyService;

/**
 * 查詢幣別
 * @author BillyChen
 *
 */
@RestController
@RequestMapping("/currency")
public class QueryCurrencyController extends BaseController {

	@Autowired
	private CurrencyService currencyService;
	
	/**
	 * 查詢所有幣別
	 * @return
	 */
	@GetMapping("/queryAll")
	public ResponseEntity<BaseResponse<List<Currency>>> getAllCurrency(){
		return mapping(currencyService.getAllCurrency());
	}
	
	/**
	 * 依據currencyCode查詢幣別
	 * @param reuqestBody
	 * @return
	 */
	@PostMapping("/findByCurrencyCode")
	public ResponseEntity<BaseResponse<Currency>> findByCurrencyCode(@RequestBody FindByCurrencyCodeQueryRequest requestBody) {
		if(!validateRequest(requestBody)) {
			return mappingRequestFail();
		}
		return mapping(currencyService.findByCurrencyCode(requestBody));
	}
	
	/**
	 * 依據currencyName查詢幣別
	 * @param reuqestBody
	 * @return
	 */
	@PostMapping("/findByCurrencyName")
	public ResponseEntity<BaseResponse<Currency>> findByCurrencyName(@RequestBody FindByCurrencyNameQueryRequest requestBody) {
		if(!validateRequest(requestBody)) {
			return mappingRequestFail();
		}
		return mapping(currencyService.findByCurrencyName(requestBody));
	}
	
	
	/**
	 * 檢查參數
	 * @param requestBody
	 * @return
	 */
	private boolean validateRequest(FindByCurrencyCodeQueryRequest requestBody) {
		if(requestBody == null || requestBody.getCurrencyCode() == null ) {
			return false;
		}
		return true;
	}
	
	/**
	 * 檢查參數
	 * @param requestBody
	 * @return
	 */
	private boolean validateRequest(FindByCurrencyNameQueryRequest requestBody) {
		if(requestBody == null || requestBody.getCurrencyName() == null) {
			return false;
		}
		return true;
	}
}
