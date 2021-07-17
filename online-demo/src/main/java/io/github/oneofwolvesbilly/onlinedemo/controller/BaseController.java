package io.github.oneofwolvesbilly.onlinedemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.github.oneofwolvesbilly.onlinedemo.entity.BaseEntity;
import io.github.oneofwolvesbilly.onlinedemo.response.BaseResponse;
import io.github.oneofwolvesbilly.onlinedemo.response.body.coindesk.ConvertCoinDeskResponse;
import io.github.oneofwolvesbilly.onlinedemo.response.third_party_api.coindesk.CoinDeskResponse;

/**
 * 基本回傳邏輯
 * 
 * @author BillyChen
 *
 */
public class BaseController {

	private final String SUCCESS = "SUCCESS";
	
	private final String FAIL = "FAIL";
	
	public final String SUCCESS_CODE = "0000";
	
	public final String FAIL_CODE = "0001";
	
	public final String FAIL_REQUEST_CODE = "1001";
	
	
	/**
	 * 查詢結果回傳
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> ResponseEntity <BaseResponse<T>> mapping(T t){			
		if(t == null) {
			return new ResponseEntity<>(new BaseResponse<>(FAIL_CODE,t),HttpStatus.OK);
		}else if (t instanceof List<?>) {
			if(((List<?>) t).isEmpty()) {
				return new ResponseEntity<>(new BaseResponse<>(FAIL_CODE,t),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new BaseResponse<>(SUCCESS_CODE,t),HttpStatus.OK);
			}
		}else if(t instanceof BaseEntity) {
				return new ResponseEntity<>(new BaseResponse<>(SUCCESS_CODE,t),HttpStatus.OK);
		}
		return new ResponseEntity<>(new BaseResponse<>(FAIL_CODE,t),HttpStatus.OK);
	}

	public ResponseEntity<BaseResponse<String>> mappingBoolean(Boolean status) {
			return  booleanCheck((Boolean) status);
		
	}
	
	/**
	 * 新增修改刪除結果回傳
	 * @param status
	 * @return
	 */
	private ResponseEntity<BaseResponse<String>> booleanCheck(Boolean status) {
		if(status == Boolean.TRUE) {
			return new ResponseEntity<>(new BaseResponse<>(SUCCESS_CODE,SUCCESS),HttpStatus.OK);
		}
		return new ResponseEntity<>(new BaseResponse<>(FAIL_CODE,FAIL),HttpStatus.OK);
	}
	
	/**
	 * 驗證失敗時回傳
	 * @param <T>
	 * @return
	 */
	public  <T> ResponseEntity <BaseResponse<T>>  mappingRequestFail() {
		return new ResponseEntity<>(new BaseResponse<>(FAIL_REQUEST_CODE,null),HttpStatus.OK);
	}

	
	/**
	 * coindesk使用
	 * @param <T>
	 * @return
	 */
	public  ResponseEntity<CoinDeskResponse>  mappingCoinDesk(CoinDeskResponse coinDeskResponse) {
		return new ResponseEntity<>(coinDeskResponse,HttpStatus.OK);
	}
	/**
	 * coindesk使用
	 * @param <T>
	 * @return
	 */
	public  ResponseEntity<ConvertCoinDeskResponse>  mappingCoinDeskConvert(ConvertCoinDeskResponse convertCoinDeskResponse) {
		return new ResponseEntity<>(convertCoinDeskResponse,HttpStatus.OK);
	}
	
	/**
	 * coindesk使用
	 * @param <T>
	 * @return
	 */
	public  ResponseEntity<String>  mappingCoinDeskRequestFail() {
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	
}
