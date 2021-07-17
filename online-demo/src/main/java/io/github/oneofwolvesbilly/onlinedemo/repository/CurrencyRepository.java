package io.github.oneofwolvesbilly.onlinedemo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.oneofwolvesbilly.onlinedemo.entity.Currency;

/**
 * 幣別Repository
 * 
 * @author BillyChen
 *
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
	
	Currency findByCurrencyCode(String currencyCode);

	Currency findByCurrencyName(String currencyName);

	List<Currency> findByCurrencyCodeIn(List<String> currencyCodeList);
	
	
}
