package io.github.oneofwolvesbilly.onlinedemo.controller.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.oneofwolvesbilly.onlinedemo.controller.BaseController;
import io.github.oneofwolvesbilly.onlinedemo.request.body.SaveCurrencyRequest;
import io.github.oneofwolvesbilly.onlinedemo.response.BaseResponse;
import io.github.oneofwolvesbilly.onlinedemo.service.CurrencyService;


/**
 * 新增幣別
 * @author BillyChen
 *
 */
@RestController
@RequestMapping("/currency")
public class SaveCurrencyController  extends BaseController{
	
	@Autowired
	private CurrencyService currencyService;
	
	/**
	 * 在currencyCode不重複之下新增幣別
	 * @param reuqestBody
	 * @return
	 */
	@PostMapping("/saveNewCurrency")
	public ResponseEntity<BaseResponse<String>> saveNewCurrency(@RequestBody SaveCurrencyRequest requestBody) {
		
		if(!validateRequest(requestBody)) {
			return mappingRequestFail();
		}
		return mappingBoolean(currencyService.save(requestBody));
	}
	
	/**
	 * 檢查參數
	 * @param requestBody
	 * @return
	 */
	private boolean validateRequest(SaveCurrencyRequest requestBody) {
		if(requestBody == null || requestBody.getCurrencyCode() == null || requestBody.getCurrencyName() == null) {
			return false;
		}
		return true;
	}
}
