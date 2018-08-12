package org.codelogger.tutorial.junit.business;

import java.util.List;

import org.codelogger.tutorial.junit.business.exception.DifferentCurrenciesException;
import org.codelogger.tutorial.junit.model.Amount;
import org.codelogger.tutorial.junit.model.Product;


public interface ClientBO {

	Amount getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException;

}