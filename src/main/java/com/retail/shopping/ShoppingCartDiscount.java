package com.retail.shopping;

import com.retail.shopping.core.DiscountFactory;
import com.retail.shopping.enums.CustomerType;

import java.text.NumberFormat;

/**
 * @author Naresh Podichetty
 *
 */
public class ShoppingCartDiscount {

    private static NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        testCalculateBillRegularType(CustomerType.REGULAR.name());
        System.out.println("======================================");
        testCalculateBillPremiumType(CustomerType.PREMIUM.name());
    }

    public static void displayDiscount(String rewardType, float amount, float discount) {
        System.out.print(rewardType);
        System.out.print(" customer spends ");
        System.out.print(formatter.format(amount));
        System.out.print(", so we discount ");
        System.out.print(formatter.format(discount));
        System.out.print(", so he owes ");
        amount -= discount;
        System.out.print(formatter.format(amount));
        System.out.println(".");
    }

    /**
     * Test method to calculate the bill for the premium type customer.
     *
     * @param customerType
     */
    private static void testCalculateBillPremiumType(String customerType) {
        DiscountFactory discountFactory = new DiscountFactory();

        // Slab 1 test
        float amount = 4000f;
        float discountedAmount = discountFactory.calculateDiscount(customerType, amount);
        displayDiscount(customerType, amount, discountedAmount);

        // Slab 2 test
        amount = 8000f;
        discountedAmount = discountFactory.calculateDiscount(customerType, amount);
        displayDiscount(customerType, amount, discountedAmount);

        // Slab 3 test
        amount = 12000f;
        discountedAmount = discountFactory.calculateDiscount(customerType, amount);
        displayDiscount(customerType, amount, discountedAmount);

        // Slab 4 test
        amount = 20000f;
        discountedAmount = discountFactory.calculateDiscount(customerType, amount);
        displayDiscount(customerType, amount, discountedAmount);
    }

    /**
     * Test method to calculate the bill for the regular type customer.
     *
     * @param customerType
     */
    private static void testCalculateBillRegularType(String customerType) {
        DiscountFactory discountFactory = new DiscountFactory();

        // Slab 1 test
        float amount = 5000f;
        float discountedAmount = discountFactory.calculateDiscount(customerType, amount);
        displayDiscount(customerType, amount, discountedAmount);

        // Slab 2 test
        amount = 10000f;
        discountedAmount = discountFactory.calculateDiscount(customerType, amount);
        displayDiscount(customerType, amount, discountedAmount);

        // Slab 3 test
        amount = 15000f;
        discountedAmount = discountFactory.calculateDiscount(customerType, amount);
        displayDiscount(customerType, amount, discountedAmount);
    }
}
