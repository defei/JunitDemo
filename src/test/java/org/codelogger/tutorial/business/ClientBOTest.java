package org.codelogger.tutorial.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.codelogger.tutorial.junit.business.ClientBO;
import org.codelogger.tutorial.junit.business.ClientBOImpl;
import org.codelogger.tutorial.junit.business.exception.DifferentCurrenciesException;
import org.codelogger.tutorial.junit.model.Amount;
import org.codelogger.tutorial.junit.model.AmountImpl;
import org.codelogger.tutorial.junit.model.Currency;
import org.codelogger.tutorial.junit.model.Product;
import org.codelogger.tutorial.junit.model.ProductImpl;
import org.codelogger.tutorial.junit.model.ProductType;
import org.junit.Test;


public class ClientBOTest {

	private ClientBO clientBO = new ClientBOImpl();

	@Test
	public void testClientProductSum() throws DifferentCurrenciesException {

		List<Product> products = new ArrayList<Product>();

		products.add(new ProductImpl(100, "Product 15",
				ProductType.BANK_GUARANTEE, new AmountImpl(
						new BigDecimal("5.0"), Currency.CNY)));

		products.add(new ProductImpl(120, "Product 20",
				ProductType.BANK_GUARANTEE, new AmountImpl(
						new BigDecimal("6.0"), Currency.CNY)));

		Amount temp = clientBO.getClientProductsSum(products);

		assertEquals(Currency.CNY, temp.getCurrency());
		assertEquals(new BigDecimal("11.0"), temp.getValue());
	}

	@Test(expected = DifferentCurrenciesException.class)
	public void testClientProductSum1() throws DifferentCurrenciesException {

		List<Product> products = new ArrayList<Product>();

		products.add(new ProductImpl(100, "Product 15",
				ProductType.BANK_GUARANTEE, new AmountImpl(
						new BigDecimal("5.0"), Currency.EUR)));

		products.add(new ProductImpl(120, "Product 20",
				ProductType.BANK_GUARANTEE, new AmountImpl(
						new BigDecimal("6.0"), Currency.CNY)));

		clientBO.getClientProductsSum(products);
	}

	@Test
	public void testClientProductSum2() {

		List<Product> products = new ArrayList<Product>();

		Amount temp = null;

		try {
			temp = clientBO.getClientProductsSum(products);
		} catch (DifferentCurrenciesException ignored) {
		}
		assertNotNull(temp);
		assertEquals(Currency.CNY, temp.getCurrency());
		assertEquals(BigDecimal.ZERO, temp.getValue());
	}

    @Test
    public void testClientProductSum_AllProductsSameCurrency()
            throws DifferentCurrenciesException {

        Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.0"), Currency.CNY),
                new AmountImpl(new BigDecimal("6.0"), Currency.CNY) };

        Amount expected = new AmountImpl(new BigDecimal("11.0"), Currency.CNY);

        List<Product> products = createProductListWithAmounts(amounts);

        Amount actual = clientBO.getClientProductsSum(products);

        assertAmount(actual, expected);
    }

    @Test(expected = DifferentCurrenciesException.class)
    public void testClientProductSum_DifferentCurrencies_ThrowsException()
            throws DifferentCurrenciesException {

        Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.0"), Currency.CNY),
                new AmountImpl(new BigDecimal("6.0"), Currency.EUR) };

        List<Product> products = createProductListWithAmounts(amounts);

        @SuppressWarnings("unused")
        Amount actual = clientBO.getClientProductsSum(products);

    }

    @Test
    public void testClientProductSum_NoProducts()
            throws DifferentCurrenciesException {

        Amount[] amounts = {};
        Amount expected = new AmountImpl(BigDecimal.ZERO, Currency.CNY);

        List<Product> products = createProductListWithAmounts(amounts);

        Amount actual = clientBO.getClientProductsSum(products);


        assertAmount(actual, expected);
    }

    private void assertAmount(Amount actual, Amount expected) {
        assertEquals(expected.getCurrency(), actual.getCurrency());
        assertEquals(expected.getValue(), actual.getValue());
    }

    private List<Product> createProductListWithAmounts(Amount[] amounts) {
        List<Product> products = new ArrayList<Product>();
        for (Amount amount : amounts) {
            products.add(new ProductImpl(100, "Product 15",
                    ProductType.BANK_GUARANTEE, amount));
        }
        return products;
    }
}