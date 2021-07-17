package io.github.oneofwolvesbilly.onlinedemo.controller.coindesk;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.oneofwolvesbilly.onlinedemo.controller.BaseController;
import io.github.oneofwolvesbilly.onlinedemo.response.body.coindesk.ConvertCoinDeskResponse;
import io.github.oneofwolvesbilly.onlinedemo.response.third_party_api.coindesk.CoinDeskResponse;
import io.github.oneofwolvesbilly.onlinedemo.service.CoinDeskService;


/**
 * coindesk操作Controller
 * @author BillyChen
 *
 */
@RestController
@RequestMapping("/coindesk")
public class CoinDeskController extends BaseController{

	
	@Autowired
	private CoinDeskService coinDeskService;
	
	/**
	 * 取得原始coindesk資訊
	 * @return
	 */
	@GetMapping("/getOriginCoinDesk")
	public ResponseEntity<CoinDeskResponse> getOriginCoinDesk(){
		return mappingCoinDesk(coinDeskService.getOriginCoinDesk());
	}
	
	/**
	 * 取得處理過後的coindesk資訊
	 * @return
	 */
	@GetMapping("/getConvertCoinDesk")
	public ResponseEntity<ConvertCoinDeskResponse>  getConvertCoinDesk(){
		return mappingCoinDeskConvert(coinDeskService.getConvertCoinDesk());
	}
	
}
