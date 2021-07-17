package io.github.oneofwolvesbilly.onlinedemo.controller.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.oneofwolvesbilly.onlinedemo.controller.BaseController;
import io.github.oneofwolvesbilly.onlinedemo.request.body.UpdateCurrencyRequest;
import io.github.oneofwolvesbilly.onlinedemo.response.BaseResponse;
import io.github.oneofwolvesbilly.onlinedemo.service.CurrencyService;

/**
 * 更新幣別
 * @author BillyChen
 *
 */
@RestController
@RequestMapping("/currency")
public class UpdateCurrencyController extends BaseController{
	@Autowired
	private CurrencyService currencyService;
	
	
	/**
	 * 依據seqId更新幣別
	 * @param reuqestBody
	 * @return
	 */
	@PostMapping("/updateCurrency")
	public ResponseEntity<BaseResponse<String>> findByCurrencyCode(@RequestBody UpdateCurrencyRequest reuqestBody) {
		
		if(!validateRequest(reuqestBody)) {
			return mappingRequestFail();
		}
		return mappingBoolean(currencyService.updateCurrency(reuqestBody));
	}
	
	
	/**
	 * 檢查參數
	 * @param requestBody
	 * @return
	 */
	private boolean validateRequest(UpdateCurrencyRequest requestBody) {
		if(requestBody == null || requestBody.getSeqId() ==null|| requestBody.getCurrencyCode() == null || requestBody.getCurrencyName() == null) {
			return false;
		}
		return true;
	}
}
