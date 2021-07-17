package io.github.oneofwolvesbilly.onlinedemo.service;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.oneofwolvesbilly.onlinedemo.entity.Currency;
import io.github.oneofwolvesbilly.onlinedemo.repository.CurrencyRepository;
import io.github.oneofwolvesbilly.onlinedemo.request.body.DeleteCurrencyRequest;
import io.github.oneofwolvesbilly.onlinedemo.request.body.FindByCurrencyCodeQueryRequest;
import io.github.oneofwolvesbilly.onlinedemo.request.body.FindByCurrencyNameQueryRequest;
import io.github.oneofwolvesbilly.onlinedemo.request.body.SaveCurrencyRequest;
import io.github.oneofwolvesbilly.onlinedemo.request.body.UpdateCurrencyRequest;

/**
 * 幣別服務
 * @author BillyChen
 *
 */
@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepository;
	
	private final Boolean SUCCESS = Boolean.TRUE;
	
	private final Boolean FAIL = Boolean.FALSE;
	
	/**
	 * 新增
	 */
	public Boolean save(SaveCurrencyRequest reuqestBody){
		Currency currency = new Currency();
		BeanUtils.copyProperties(reuqestBody, currency);
		return saveOrUpdate(currency);
	}
	
	/**
	 * 刪除
	 */
	public Boolean delete(DeleteCurrencyRequest requestBody) {
		try {
			Currency currency = new Currency();
			BeanUtils.copyProperties(requestBody, currency);
			currencyRepository.delete(currency);
		return SUCCESS;
		}catch (Exception e) {
			return FAIL;
		}
	}
	
	/**
	 * 修改
	 */
	public Boolean updateCurrency(UpdateCurrencyRequest reuqestBody) {
		Currency currency = new Currency();
		BeanUtils.copyProperties(reuqestBody, currency);
		return saveOrUpdate(currency);
	}
	
	
	private Boolean saveOrUpdate(Currency currency) {
		try {
			currencyRepository.save(currency);
			return SUCCESS;
		}catch (Exception e) {
			return FAIL;
		}
	}


	/**
	 * 查詢
	 */
    public List<Currency> getAllCurrency(){
    	return currencyRepository.findAll();
	}
    
    public Currency findByCurrencyCode(FindByCurrencyCodeQueryRequest requestBean) {
    	return currencyRepository.findByCurrencyCode(requestBean.getCurrencyCode());
    }
    
    public Currency findByCurrencyName(FindByCurrencyNameQueryRequest requestBean) {
    	Currency c = currencyRepository.findByCurrencyName(requestBean.getCurrencyName());
    	return c;
    }
}
