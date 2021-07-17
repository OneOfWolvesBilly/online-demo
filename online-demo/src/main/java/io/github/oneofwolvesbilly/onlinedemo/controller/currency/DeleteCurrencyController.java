package io.github.oneofwolvesbilly.onlinedemo.controller.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.oneofwolvesbilly.onlinedemo.controller.BaseController;
import io.github.oneofwolvesbilly.onlinedemo.request.body.DeleteCurrencyRequest;
import io.github.oneofwolvesbilly.onlinedemo.response.BaseResponse;
import io.github.oneofwolvesbilly.onlinedemo.service.CurrencyService;

/**
 * 刪除幣別
 * @author BillyChen
 *
 */
@RestController
@RequestMapping("/currency")
public class DeleteCurrencyController  extends BaseController {

	@Autowired
	private CurrencyService currencyService;
	
	/**
	 * 依據整個Currency刪除對應之幣別資料
	 * @param reuqestBody
	 * @return
	 */
	@PostMapping("/deleteCurrency")
	public ResponseEntity<BaseResponse<String>> findByCurrencyCode(@RequestBody DeleteCurrencyRequest requestBody) {
		
		
		if(!validateRequest(requestBody)) {
			return mappingRequestFail();
		}
		
		return mappingBoolean(currencyService.delete(requestBody));
	}

	
	/**
	 * 檢查參數
	 * @param requestBody
	 * @return
	 */
	private boolean validateRequest(DeleteCurrencyRequest requestBody) {
		if(requestBody == null || requestBody.getSeqId() ==null || requestBody.getCurrencyCode() == null || requestBody.getCurrencyName() == null) {
			return false;
		}
		return true;
	}

}
